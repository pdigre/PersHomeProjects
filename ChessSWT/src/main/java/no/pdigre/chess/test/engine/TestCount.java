package no.pdigre.chess.test.engine;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;

public class TestCount extends RecursiveTask<Counter[]>{

	private static final long serialVersionUID = -3058348904963758664L;

	final protected int bitmap;

    final protected int level;

    final protected Counter[] counters;

    final protected Counter counter;

    final protected int[] board;

    private boolean countJustMoves=false;

    public TestCount(int bitmap, int level, int MAXDEPTH, int[] board,boolean countJustMoves) {
        this.countJustMoves=countJustMoves;
        this.bitmap = bitmap;
        this.level = level;
        this.board = board;
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        counter = counters[level];
    }

    public TestCount(int bitmap, int level, int MAXDEPTH, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.board = board;
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        counter = counters[level];
    }

	private void countMove(int bitmap2, int[] board2) {
		counter.moves++;
		if(countJustMoves)
		    return;
        boolean white = Bitmap.white(bitmap);
        if (!NodeGen.checkSafe(board2, NodeGen.getKingPos(board2, white), white)) {
            counter.checks++;
            if (!(new NodeGen(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)).nextSafe()!=0))
                counter.mates++;
        }
	}

    public Counter[] computeParallel() {
        NodeGen pull = new NodeGen(board, bitmap);
        int processors = Runtime.getRuntime().availableProcessors();
//        System.out.println("No of processors: " + processors);
		ForkJoinPool pool=new ForkJoinPool(processors);
        ArrayList<TestCount> tasks = new ArrayList<TestCount>();
        int bitmap=pull.nextSafe();
        while(bitmap!=0){
            count(bitmap);
			int[] board2 = Bitmap.apply(board, bitmap);
            countMove(bitmap, board2);
			if (level + 1 < counters.length) {
				TestCount task = new TestCount(bitmap, level + 1, counters.length, board2);
				tasks.add(task);
				pool.execute(task);
			}
            bitmap=pull.nextSafe();
        }
        for (TestCount task : tasks)
    		Counter.total(counters, task.join());
        return counters;
    }

    public void count(int bitmap) {
        if(Bitmap.isCapture(bitmap)){
            counter.captures++;
            if(Bitmap.isEnpassant(bitmap))
                counter.enpassants++;
        } else {
            if(Bitmap.isCastling(bitmap))
                counter.castlings++;
        }
        if(Bitmap.isPromotion(bitmap))
            counter.promotions++;
    }

	@Override
	protected Counter[] compute() {
        NodeGen pull = new NodeGen(board, bitmap);
        int bitmap=pull.nextSafe();
        while(bitmap!=0){
            count(bitmap);
			int[] board2 = Bitmap.apply(board, bitmap);
            countMove(bitmap, board2);
			if (level + 1 < counters.length)
			    Counter.total(counters, new TestCount(bitmap, level + 1, counters.length, board2).compute());
            bitmap=pull.nextSafe();
        }
        return counters;
	}

}
