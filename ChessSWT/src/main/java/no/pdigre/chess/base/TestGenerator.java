package no.pdigre.chess.base;

import no.pdigre.chess.eval.FindMoves;
import no.pdigre.chess.eval.Move;
import no.pdigre.chess.eval.MoveBitmap;
import no.pdigre.chess.test.StandardMovesTest.Counter;

public class TestGenerator implements IAdder {

    final private int bitmap;

    final private int level;

    final private Counter[] counters;

    final private Counter counter;

    final private int[] board;

    private int from;

    public TestGenerator(int bitmap, int level, Counter[] counters, int[] board) {
        this.bitmap = bitmap;
        this.level = level;
        this.counters = counters;
        this.counter = counters[level];
        this.board = MoveBitmap.apply(board, bitmap);
    }

    private void run() {
        int enpassant = 0;
        for (from = 0; from < 64; from++) {
            int type = board[from];
            if (type == 0)
                continue;
            boolean white = MoveBitmap.white(type);
            if (white == MoveBitmap.white(bitmap)) {
                NodeGenerator.addMovesForPiece(this, board, from, type, white, enpassant,
                    MoveBitmap.getCastlingState(bitmap));
            }
        }
    }

    @Override
    public void move(int to, int from) {
        if(!NodeGenerator.checkSafe(board, to, MoveBitmap.white(bitmap)))
            return;
//        loop(to);
    }

    private void loop(int to) {
        int bitmap2 = MoveBitmap.mapMove(from, to, MoveBitmap.halfMoves(bitmap), bitmap);
        int[] board2 = MoveBitmap.apply(board,bitmap2);
        if(NodeGenerator.isCheck(board2,MoveBitmap.white(bitmap))){
            counter.checks++;
//            if(FindMoves.isMate(move, board2))
//                counter.mates++;
        }
        if (level + 1 < counters.length)
            new TestGenerator(bitmap, level + 1, counters, board).run();
    }

    @Override
    public void movePromote(int to, int from) {
        counter.promotions++;
    }

    @Override
    public void capture(int to, int from) {
        counter.captures++;
    }

    @Override
    public void capturePromote(int to, int from) {
        counter.promotions++;
        counter.captures++;
    }

    @Override
    public void castling(int to, int from) {
        counter.castlings++;
    }

    @Override
    public void enpassant(int to, int from) {
        counter.enpassants++;
    }

    public static void run(int bitmap, int[] board, Counter[] counters) {
        new TestGenerator(bitmap, 0, counters, board).run();
    }

}
