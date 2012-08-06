package no.pdigre.chess.base;

import no.pdigre.chess.eval.MoveBitmap;
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
        this.board = MoveBitmap.apply(board, bitmap);
    }


    public static void run(int bitmap, int[] board, Counter[] counters) {
        new TestGenerator(bitmap, 0, counters, board).run();
    }

    private void loop(int bitmap2) {
        counter.moves++;
        int[] board2 = MoveBitmap.apply(board,bitmap2);
        if(NodeGenerator.isCheck(board2,MoveBitmap.white(bitmap))){
            counter.checks++;
//            String printMove = MoveBitmap.printMove(bitmap2, board2);
//            String brd=FEN.printBoard(board2);
            if(!NodeGenerator.hasLegalMoves(board2, bitmap2))
                counter.mates++;
        }
        if (level + 1 < counters.length)
            new TestGenerator(bitmap2, level + 1, counters, board2).run();
    }

    public void run() {
        NodeGenerator.loopLegalMoves(this, board, bitmap);
    }

    @Override
    public void move(int bitmap) {
        loop(bitmap);
    }

    @Override
    public void movePromote(int bitmap) {
        counter.promotions++;
        loop(bitmap);
    }

    @Override
    public void capture(int bitmap) {
        counter.captures++;
        loop(bitmap);
    }

    @Override
    public void capturePromote(int bitmap) {
        counter.promotions++;
        counter.captures++;
        loop(bitmap);
    }

    @Override
    public void castling(int bitmap) {
        counter.castlings++;
        loop(bitmap);
    }

    @Override
    public void enpassant(int bitmap) {
        counter.enpassants++;
        loop(bitmap);
    }
}
