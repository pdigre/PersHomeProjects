package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.Evaluator;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.eval.NegaMax;
import no.pdigre.chess.engine.eval.NegaMaxCutoff;
import no.pdigre.chess.engine.eval.NegaMaxEnd;
import no.pdigre.chess.engine.fen.StartGame;

import org.junit.Test;

@SuppressWarnings("static-method")
public class ThinkerTest {

    /**
     * Takes 2.2 sec with quadcore i7
     */
    @Test
    public void testNegamax() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        NegaMax first = new NegaMax(new NegaMax(new NegaMax(new NegaMaxEnd())));
        NegaMax second = new NegaMax(new NegaMax(new NegaMax(new NegaMax(new NegaMaxEnd()))));
        testThinker(fen,first, second);
    }

    /**
     * Takes 148ms with quadcore i7
     */
    @Test
    public void testNegamaxCutoff() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        IThinker first = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd())));
        IThinker second = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd()))));
        testThinker(fen,first, second);
    }

    /**
     * Takes 148ms with quadcore i7
     */
    @Test
    public void testNegamaxCutoffWithTransposition() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        IThinker first = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd())));
        IThinker second = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd()))));
        testThinker(fen,first, second);
    }

    /**
     * @param first
     */
    public static void testThinker(String fen,IThinker first, IThinker second) {
        StartGame start = new StartGame(fen);
        int[] board = start.getBoard();
        int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
        Evaluator[] evals = new Evaluator[moves.length];
        for (int i = 0; i < moves.length; i++)
            evals[i] = new Evaluator(board, moves[i]);
        for (Evaluator eval : evals)
            eval.think(first);
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        int extra = moves.length / 3;
        for (Evaluator eval : evals) {
            if (extra-- < 0)
                break;
            eval.think(second);
        }
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
    }

}
