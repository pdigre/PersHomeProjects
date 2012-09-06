package no.pdigre.chess.test;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodePull;
import no.pdigre.chess.test.StandardMovesTest.Counter;

public class TestCount {

    final protected int bitmap;

    final protected int level;

    final protected Counter[] counters;

    final protected Counter counter;

    final protected int[] board;

    public TestCount(int bitmap, int level, Counter[] counters, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.counters = counters;
        this.counter = counters[level];
        this.board = board;
    }

    private void loop(int bitmap2, int[] board2) {
        counter.moves++;
        boolean white = Bitmap.white(bitmap);
        if (!NodePull.checkSafe(board2, NodePull.getKingPos(board2, white), white)) {
            counter.checks++;
            if (!(new NodePull(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)).next()!=0))
                counter.mates++;
        }
        if (level + 1 < counters.length)
            new TestCount(bitmap2, level + 1, counters, board2).run();
    }

    public void run() {
        NodePull pull = new NodePull(board, bitmap);
        int bitmap=pull.next();
        while(bitmap!=0){
            count(bitmap);
            loop(bitmap, Bitmap.apply(board, bitmap));
            bitmap=pull.next();
        }
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
