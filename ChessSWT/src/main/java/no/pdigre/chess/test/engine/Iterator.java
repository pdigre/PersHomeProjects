package no.pdigre.chess.test.engine;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.fen.FEN;

public class Iterator extends RecursiveTask<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971959747250168203L;
	private IThinker eval;
	private int[] board;
	private int bitmap;
	private int level;
	private StringBuffer status=new StringBuffer();
	
	public Iterator(IThinker eval, int[] board, int bitmap, int level) {
		this.eval = eval;
		this.board = board;
		this.bitmap = bitmap;
		this.level = level;
	}

	public void lookDeeper(){
		level++;
	}
	
	@Override
	protected String compute() {
		int score = eval.run(Bitmap.apply(board, bitmap), bitmap, level);
		if(status.length()>0)
			status.append(",");
		status.append(score);
		return FEN.printMove(bitmap, board) + " (" +status.toString()+")"+level;
	}

}
