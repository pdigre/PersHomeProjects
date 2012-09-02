package no.pdigre.chess.test;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodeGenerator;
import no.pdigre.chess.base.NodePull;
import no.pdigre.chess.test.StandardMovesTest.Counter;

public class TestGenerator2 {

    final private int bitmap;

    final private int level;

    final private Counter[] counters;

    final private Counter counter;

    final private int[] board;

    public TestGenerator2(int bitmap, int level, Counter[] counters, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.counters = counters;
        this.counter = counters[level];
        this.board = board;
    }

    public static void run(int bitmap, int[] board, Counter[] counters) {
        new TestGenerator2(bitmap, 0, counters, board).run();
    }

    private void loop(int bitmap2, int[] board2) {
        counter.moves++;
        boolean white = Bitmap.white(bitmap);
        int kpos = NodeGenerator.getKingPos(board2, white);
        boolean check = !NodeGenerator.checkSafe(board2, kpos, white);
        if (check) {
            counter.checks++;
            if (!NodeGenerator.hasLegalMoves(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)))
                counter.mates++;
        }
        if (level + 1 < counters.length)
            new TestGenerator2(bitmap2, level + 1, counters, board2).run();
    }

    public void run() {
        NodePull pull = new NodePull(board, bitmap);
        int next=pull.next();
        while(next!=0){
            move(next);
            next=pull.next();
        }
    }

    public void move(int bitmap) {
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
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

}
