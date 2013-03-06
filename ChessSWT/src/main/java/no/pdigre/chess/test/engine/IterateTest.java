package no.pdigre.chess.test.engine;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

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
	 * 3.6s normal
	 * 1.4s parallel
	 * @param eval
	 */
	public static void testThinker(IThinker eval) {
		String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
		StartGame start = new StartGame(fen);
		int[] board = start.getBoard();
		int[] moves = NodeUtil.getAllBestFirst(board, start.getInherit());
		int processors = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(processors);
        ArrayList<Iterator> tasks = new ArrayList<Iterator>();
		int extra = moves.length / 3;
		for (int bitmap : moves) {
			Iterator task = new Iterator(eval,board, bitmap,3);
			tasks.add(task);
			pool.execute(task);
		}
		for (Iterator task : tasks) {
			if(extra--<0)
				break;
			task.join();
			task.lookDeeper();
			pool.execute(task);
		}
		for (Iterator task : tasks) {
			System.out.println(task.join());
		}
	}

}
