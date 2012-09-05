package no.pdigre.chess.test;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodePull;
import no.pdigre.chess.test.StandardMovesTest.Counter;

public class TestGenerator implements IAdder {

    final private int bitmap;

    final private int level;

    final private Counter[] counters;

    final private Counter counter;

    final private int[] board;

    public TestGenerator(int bitmap, int level, Counter[] counters, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.counters = counters;
        this.counter = counters[level];
        this.board = board;
    }

    public static void run(int bitmap, int[] board, Counter[] counters) {
        new TestGenerator(bitmap, 0, counters, board).run();
    }

    private void loop(int bitmap2, int[] board2) {
        counter.moves++;
        boolean white = Bitmap.white(bitmap);
        int kpos = NodePull.getKingPos(board2, white);
        boolean check = !NodePull.checkSafe(board2, kpos, white);
        if (check) {
            counter.checks++;
            if (!(new NodePull(board2, bitmap2 & (IConst.CASTLING_STATE | IConst.HALFMOVES)).next()!=0))
                counter.mates++;
        }
        if (level + 1 < counters.length)
            new TestGenerator(bitmap2, level + 1, counters, board2).run();
    }

    public void run() {
        NodePull pull = new NodePull(board, bitmap);
        int bitmap1 = pull.next();
        while (bitmap1 != 0) {
            if (Bitmap.isCapture(bitmap1)) {
                if (Bitmap.isEnpassant(bitmap1))
                    this.enpassant(bitmap1);
                else if (Bitmap.isPromotion(bitmap1))
                    this.capturePromote(bitmap1);
                else
                    this.capture(bitmap1);
            } else {
                if (Bitmap.isCastling(bitmap1))
                    this.castling(bitmap1);
                else if (Bitmap.isPromotion(bitmap1))
                    this.movePromote(bitmap1);
                else
                    this.move(bitmap1);
            }
            bitmap1 = pull.next();
        }
    }

    @Override
    public void move(int bitmap) {
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

    @Override
    public void movePromote(int bitmap) {
        counter.promotions++;
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

    @Override
    public void capture(int bitmap) {
        counter.captures++;
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

    @Override
    public void capturePromote(int bitmap) {
        counter.promotions++;
        counter.captures++;
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

    @Override
    public void castling(int bitmap) {
        counter.castlings++;
        loop(bitmap, Bitmap.apply(board, bitmap));
    }

    @Override
    public void enpassant(int bitmap) {
        counter.enpassants++;
        counter.captures++;
        loop(bitmap, Bitmap.apply(board, bitmap));
    }
}
