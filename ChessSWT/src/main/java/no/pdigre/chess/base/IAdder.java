package no.pdigre.chess.base;


public interface IAdder {

    public abstract void move(final int bitmap);

    public abstract void movePromote(final int bitmap);

    public abstract void capture(int bitmap);

    public abstract void capturePromote(final int bitmap);

    public abstract void castling(final int bitmap);

    public abstract void enpassant(final int bitmap);
}
