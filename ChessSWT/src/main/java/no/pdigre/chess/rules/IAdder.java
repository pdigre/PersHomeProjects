package no.pdigre.chess.rules;


public interface IAdder {

    public abstract void move(final int to);

    public abstract void movePromote(final int to);

    public abstract void beat(final int to);

    public abstract void capturePromote(final int to);

    public abstract void support(final int to);

    public abstract void castling(final int to);

    public abstract void enpassant(final int to);

    public abstract int getEnpassant();

    public abstract int getCastlingState();
}
