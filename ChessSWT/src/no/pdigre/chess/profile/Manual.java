package no.pdigre.chess.profile;

import no.pdigre.chess.engine.fen.FEN;


public class Manual extends Player {

    public Manual(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(FEN.getFen(game.position));
                game.eval= new JustMoves(game.position.getBoard(), game.position.getBitmap());
                game.updateMarkers();
            }
        }).run();
    }

}
