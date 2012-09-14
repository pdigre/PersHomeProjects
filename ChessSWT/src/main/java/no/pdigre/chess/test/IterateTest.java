package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.base.NodeGen;
import no.pdigre.chess.eval.AlphaBeta;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.StartGame;

import org.junit.Test;

public class IterateTest {
    
    private static final int MAXDEPTH = 5;

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
        int[] allMoves = NodeGen.getAllMoves(board, move.getInherit());
        
        int max_score=-100000;
        int max_bitmap=0;
        int[] max_board=null;
        for (int bitmap : allMoves) {
            int score = AlphaBeta.alphaBeta(MAXDEPTH, board, bitmap);
            if(score>max_score){
                max_score=score;
                max_bitmap=bitmap;
                max_board=board;
            }
        }
        String txt = FEN.printMove(max_bitmap, max_board) + " (" + max_score + ")";
        assertEquals("WHITE_PAWN from e2 to e3 (-25)", txt);
    }

}
