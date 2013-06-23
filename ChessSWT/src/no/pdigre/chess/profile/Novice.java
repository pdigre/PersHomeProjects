package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;

public class Novice extends Player {

    @Override
    public void run() {
        printFEN();
        bitmaps = new AlphaBeta(getBoard(), getBitmap(), 5).getBitmaps();
        int bitmap = bitmaps[0];
		makeMove(bitmap);
    }
}
