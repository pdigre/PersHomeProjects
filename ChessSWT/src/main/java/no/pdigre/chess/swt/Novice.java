package no.pdigre.chess.swt;

public class Novice extends Player {

    public Novice(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                game.noviceMove();
                game.updateMarkers();
            }
        }).run();
    }

}
