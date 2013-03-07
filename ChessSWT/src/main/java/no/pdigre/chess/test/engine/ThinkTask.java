package no.pdigre.chess.test.engine;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.eval.IThinker;

public class ThinkTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971959747250168203L;
	final private IThinker thinker;
	final private int[] board;
	final private int bitmap;
	
	public ThinkTask(IThinker thinker, int[] board, int bitmap) {
		this.thinker = thinker;
		this.board = board;
		this.bitmap = bitmap;
	}
	
	@Override
	protected Integer compute() {
		return thinker.think(Bitmap.apply(board, bitmap), bitmap, 0, IThinker.MIN, IThinker.MAX);
	}

}
