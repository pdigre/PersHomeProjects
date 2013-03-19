package no.pdigre.chess.test.engine;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;

public class CountMore extends RecursiveTask<Counter[]>{

    private static final long serialVersionUID = -3058348234963748664L;

    final protected Counter[] counters;
    final protected int bitmap;

    final protected int[] board;

	public CountMore(int bitmap, int depth, int[] board) {
        this.bitmap = bitmap;
        this.board = board;
        counters = new Counter[depth];
        for (int i = 0; i < depth; i++)
            counters[i] = new Counter();
    }

	protected void countMove(int bitmap2, int[] board2) {
	    counters[0].moves++;
        boolean white = Bitmap.white(bitmap);
        if (!NodeGen.checkSafe(board2, NodeGen.getKingPos(board2, white), white)) {
            counters[0].checks++;
            if (!(new NodeGen(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)).nextSafe()!=0))
                counters[0].mates++;
        }
	}

	public void count(int bitmap) {
        if(Bitmap.isCapture(bitmap)){
            counters[0].captures++;
            if(Bitmap.isEnpassant(bitmap))
                counters[0].enpassants++;
        } else {
            if(Bitmap.isCastling(bitmap))
                counters[0].castlings++;
        }
        if(Bitmap.isPromotion(bitmap))
            counters[0].promotions++;
    }

	@Override
	protected Counter[] compute() {
        NodeGen pull = new NodeGen(board, bitmap);
        int bitmap=pull.nextSafe();
        while(bitmap!=0){
            int[] board2 = Bitmap.apply(board, bitmap);
            count(bitmap);
            countMove(bitmap, board2);
			if (counters.length>1)
			    Counter.total(counters, new CountMore(bitmap, counters.length-1, board2).compute());
            bitmap=pull.nextSafe();
        }
        return counters;
	}

}
