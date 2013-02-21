package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;

public class TestCount {

    final protected int bitmap;

    final protected int level;

    final protected Counter[] counters;

    final protected Counter counter;

    final protected int[] board;

    public TestCount(int bitmap, int level, int MAXDEPTH, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.board = board;
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        counter = counters[level];
    }

    private void loop(int bitmap2, int[] board2) {
        counter.moves++;
        boolean white = Bitmap.white(bitmap);
        if (!NodeGen.checkSafe(board2, NodeGen.getKingPos(board2, white), white)) {
            counter.checks++;
            if (!(new NodeGen(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)).nextSafe()!=0))
                counter.mates++;
        }
        if (level + 1 < counters.length)
            Counter.total(counters, new TestCount(bitmap2, level + 1, counters.length, board2).process());
    }

    public Counter[] process() {
        NodeGen pull = new NodeGen(board, bitmap);
        int bitmap=pull.nextSafe();
        while(bitmap!=0){
            count(bitmap);
            loop(bitmap, Bitmap.apply(board, bitmap));
            bitmap=pull.nextSafe();
        }
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

}
