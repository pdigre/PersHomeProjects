package no.pdigre.chess.swt;

public class Manual extends Player {

    public Manual(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                game.manual();
                game.updateMarkers();
            }
        }).run();
    }

}
