package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.eval.EvalUnit;
import no.pdigre.chess.engine.fen.StartGame;

import org.junit.Test;


@SuppressWarnings("static-method")
public class EloTest {

    @Test
    public void testEvalUnit2() {
        String fen = "8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1";
        StartGame start = new StartGame(fen);
        EvalUnit top = new EvalUnit(start.getBoard(), start.getBitmap());
        top.runFirstPass();
        top.runSecondPass(20);
        top.printScore();
    }

}
