package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.eval.AlphaBeta;
import no.pdigre.chess.eval.MoveEval;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.StartGame;

import org.junit.Test;

public class IterateTest {
    
    /**
     * Historic scores::
     * =================
     * minmax even 5 times slower
     * depth 5 with allmoves  - 37,5 secs
     * depth 5 with pullmoves - 10,2 secs
     * depth 5 with Unsafe    -  3.3 secs
     */
    @SuppressWarnings("static-method")
    @Test
    public void testAlphaBeta() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        StartGame move = new StartGame(fen);
        int[] board = move.getBoard();
        AlphaBeta eval = new AlphaBeta(board, move.getInherit(), 5);
        MoveEval mv = eval.moves[0];
        String txt = FEN.printMove(mv.bitmap, mv.board) + " (" + mv.score + ")";
        assertEquals("WHITE_PAWN from e2 to e3 (-25)", txt);
    }

}
