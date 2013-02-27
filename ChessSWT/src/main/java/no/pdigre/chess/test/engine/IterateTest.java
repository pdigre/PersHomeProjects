package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.eval.NegaMax;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.StartGame;

import org.junit.Test;

public class IterateTest {

    /**
     * Historic scores:: ================= minmax even 5 times slower depth 5
     * with allmoves - 37,5 secs depth 5 with pullmoves - 10,2 secs depth 5 with
     * Unsafe - 3.3 secs
     */
    @SuppressWarnings("static-method")
    @Test
    public void testNegamax() {
        testThinker(new NegaMax());
    }

    public static void testThinker(IThinker eval) {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        StartGame start = new StartGame(fen);
        int[] board = start.getBoard();
        int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
        for (int bitmap : moves) {
            int score3 = eval.run(Bitmap.apply(board, bitmap), bitmap, 3);
            int score5 = eval.run(Bitmap.apply(board, bitmap), bitmap, 5);
            System.out.println(FEN.printMove(bitmap, board) + " (" + score3 + ", " + score5+")");
        }
    }

}
