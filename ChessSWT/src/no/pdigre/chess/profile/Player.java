package no.pdigre.chess.profile;


public abstract class Player {

    protected GameData game;

    public Player(GameData game) {
        this.game=game;
    }

    public abstract void run();

}
