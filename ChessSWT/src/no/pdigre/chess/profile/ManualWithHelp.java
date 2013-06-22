package no.pdigre.chess.profile;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.eval.MoveEval;
import no.pdigre.chess.engine.fen.FEN;


public class ManualWithHelp extends Player {

    public ManualWithHelp(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(FEN.getFen(game.position));
                AlphaBeta eval = new AlphaBeta(game.position.getBoard(), game.position.getBitmap(), 5);
                game.eval = eval;
                game.draw_targets = new int[64];
                game.draw_score = new int[64];
                for (MoveEval move : eval.moves) {
                    int from = Bitmap.getFrom(move.bitmap);
                    if (game.draw_score[from] == 0)
                        game.draw_score[from] = move.score;
                }
                game.updateMarkers();
            }
        }).run();
    }

}
