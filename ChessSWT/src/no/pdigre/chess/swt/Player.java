package no.pdigre.chess.swt;

public abstract class Player {

    protected GameData game;

    public Player(GameData game) {
        this.game=game;
    }

    public abstract void run();

}
