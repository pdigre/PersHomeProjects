package no.pdigre.chess.test.engine;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.eval.IThinker;

public class EvalTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971959747250168203L;
	private IThinker eval;
	private int[] board;
	private int bitmap;
	private int level;
	
	public EvalTask(IThinker eval, int[] board, int bitmap, int level) {
		this.eval = eval;
		this.board = board;
		this.bitmap = bitmap;
		this.level = level;
	}
	
	@Override
	protected Integer compute() {
		return eval.run(Bitmap.apply(board, bitmap), bitmap, level);
	}

}
