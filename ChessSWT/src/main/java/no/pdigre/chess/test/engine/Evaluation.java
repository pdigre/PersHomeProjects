package no.pdigre.chess.test.engine;

import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.fen.FEN;

public class Evaluation {

	static ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime()
			.availableProcessors());

	final private int bitmap;
	final private int[] board;
	private StringBuffer status = new StringBuffer();
	EvalTask task;

	public Evaluation(int[] board, int bitmap) {
		this.board = board;
		this.bitmap = bitmap;
	}

	public void execute(IThinker eval, int level) {
		task = new EvalTask(eval, board, bitmap, level);
		pool.execute(task);
	}

	public void join() {
		if (task != null){
			if(status.length()>0)
				status.append(",");
			status.append(task.join());
		}
		task = null;
	}

	@Override
	public String toString() {
		return FEN.printMove(bitmap, board) + " (" +status.toString()+")";
	}
}