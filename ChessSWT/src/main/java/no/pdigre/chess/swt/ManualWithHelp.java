package no.pdigre.chess.swt;

public class ManualWithHelp extends Player {

    public ManualWithHelp(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                game.manualWithHelp();
                game.updateMarkers();
            }
        }).run();
    }

}
