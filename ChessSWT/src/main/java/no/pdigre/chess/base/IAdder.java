package no.pdigre.chess.base;


public interface IAdder {

    public abstract void move(final int to);

    public abstract void movePromote(final int to);

    public abstract void capture(final int to);

    public abstract void capturePromote(final int to);

    public abstract void support(final int to);

    public abstract void castling(final int to);

    public abstract void enpassant(final int to);
}
