package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.Evaluator;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.eval.NegaMax;
import no.pdigre.chess.engine.eval.NegaMaxCutoff;
import no.pdigre.chess.engine.eval.NegaMaxEnd;
import no.pdigre.chess.engine.eval.NegaMaxTransposition;
import no.pdigre.chess.engine.fen.StartGame;

import org.junit.Test;

/**
 * Count at level 3
 * Negamax  13391      - 197s
 * w/cutoff 1891/13391 - 2.5s
 * w/transp 1300/13391 - 2.1s
 * @author Per Digre
 *
 */
@SuppressWarnings("static-method")
public class ThinkerTest {

    /**
     * Takes 2.2 sec with quadcore i7
     */
    @Test
    public void testNegamax() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        NegaMax first = new NegaMax(new NegaMax(new NegaMax(new NegaMaxEnd())));
        NegaMax tt = new NegaMax(first);
        testThinker(fen, first, new NegaMax(tt));
        tt.printHitrate();
    }

    /**
     * Takes 148ms with quadcore i7
     */
    @Test
    public void testNegamaxCutoff() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        IThinker first = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd())));
        NegaMaxCutoff tt = new NegaMaxCutoff(first);
        testThinker(fen, first, new NegaMaxCutoff(tt));
        tt.printHitrate();
    }

    /**
     * Takes 148ms with quadcore i7
     * 
     * with test2 
     * 5201/39731
     */
    @Test
    public void testNegamaxCutoffWithTransposition() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        IThinker first = new NegaMaxCutoff(new NegaMaxEnd());
        NegaMaxTransposition tt = new NegaMaxTransposition(first);
        testThinker2(fen, first, new NegaMax(tt));
        tt.printHitrate();
    }

    /**
     * @param first
     */
    public static void testThinker(String fen, IThinker first, IThinker second) {
        StartGame start = new StartGame(fen);
        int[] board = start.getBoard();
        int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
        Evaluator[] evals = new Evaluator[moves.length];
        for (int i = 0; i < moves.length; i++)
            evals[i] = new Evaluator(board, moves[i]);
        for (Evaluator eval : evals)
            eval.async(first);
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        int extra = moves.length / 3;
        for (Evaluator eval : evals) {
            if (extra-- < 0)
                break;
            eval.async(second);
        }
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
    }

    public static void testThinker2(String fen, IThinker first, IThinker second) {
        StartGame start = new StartGame(fen);
        int[] board = start.getBoard();
        int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
        Evaluator[] evals = new Evaluator[moves.length];
        for (int i = 0; i < moves.length; i++)
            evals[i] = new Evaluator(board, moves[i]);
        for (Evaluator eval : evals)
            eval.sync(second);
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
    }
}
