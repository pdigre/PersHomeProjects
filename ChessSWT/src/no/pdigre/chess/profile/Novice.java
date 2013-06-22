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
                AlphaBeta eval = new AlphaBeta(game.position.getBoard(), game.position.getBitmap(), 5);
                game.eval = eval;
                Move bestmove = new Move(game.position, eval.getBitmaps()[0]);
                game.setup(bestmove);
                game.updateMarkers();
            }
        }).run();
    }

}
