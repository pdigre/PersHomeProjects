package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;

public class ManualWithHelp extends Manual {

    @Override
    public void run() {
    	printFEN();
        AlphaBeta eval = new AlphaBeta(getBoard(), getBitmap(), 5);
        bitmaps = eval.getBitmaps();
        scores = eval.getScores();
		game.updateBoard();
    }
}
