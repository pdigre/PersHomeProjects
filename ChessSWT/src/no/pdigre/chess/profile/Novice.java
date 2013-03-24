package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Move;


public class Novice extends Player {

    public Novice(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(FEN.getFen(game.position));
                game.eval = new AlphaBeta(game.position.getBoard(), game.position.getBitmap(), 5);
                game.setup(new Move(game.position, game.eval.getBitmaps()[0]));
                game.updateMarkers();
            }
        }).run();
    }

}
