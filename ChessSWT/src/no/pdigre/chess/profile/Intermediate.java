package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.fen.IPosition;

public class Intermediate extends Player {

    public Intermediate(GameData game) {
        super(game);
    }

    @Override
    public void run() {
        checkPolyglot();
        if (bitmaps.length == 0) {
            IPosition pos = game.position;
            AlphaBeta eval = new AlphaBeta(pos.getBoard(), pos.getBitmap(), 5);
            bitmaps = eval.getBitmaps();
            scores = eval.getScores();
        }
        game.makeMove(bitmaps[0]);
    }


}
