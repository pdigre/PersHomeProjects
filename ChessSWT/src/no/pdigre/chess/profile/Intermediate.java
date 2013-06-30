package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;

public class Intermediate extends Player {

	@Override
	public void run() {
		checkPolyglot();
		if (bitmaps.length > 0) {
			makeMove(bitmaps[0]);
			return;
		}
		AlphaBeta eval = new AlphaBeta(getBoard(), getBitmap(), 5);
		bitmaps = eval.getBitmaps();
		scores = eval.getScores();
		makeMove(bitmaps[0]);
	}

}
