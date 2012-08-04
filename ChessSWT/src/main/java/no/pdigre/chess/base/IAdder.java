package no.pdigre.chess.base;


public interface IAdder {

    public abstract void move(final int to, int from);

    public abstract void movePromote(final int to, int from);

    public abstract void capture(final int to, int from);

    public abstract void capturePromote(final int to, int from);

    public abstract void castling(final int to, int from);

    public abstract void enpassant(final int to, int from);
}
