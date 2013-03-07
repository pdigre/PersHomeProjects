package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.eval.NegaMax;
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

	/**
	 * 3.6s normal 2.2s parallel
	 * 
	 * @param strategy
	 */
	public static void testThinker(IThinker strategy) {
		String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
		StartGame start = new StartGame(fen);
		int[] board = start.getBoard();
		int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
		Evaluation[] evals = new Evaluation[moves.length];
		for (int i = 0; i < moves.length; i++)
			evals[i] = new Evaluation(board, moves[i]);

		int extra = evals.length / 3;
		for (Evaluation eval : evals)
			eval.execute(strategy, 3);
		for (Evaluation eval : evals)
			eval.join();
		for (Evaluation eval : evals) {
			if (extra-- < 0)
				break;
			eval.execute(strategy, 4);
		}
		for (Evaluation eval : evals){
			eval.join();
			System.out.println(eval.toString());
		}
	}

}
