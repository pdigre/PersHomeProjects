package no.pdigre.chess.rules;

import java.util.Collection;

public interface IAdder {

    public abstract void move(final int to);

    public abstract void moveTrade(final int to);

    public abstract void beat(final int to);

    public abstract void beatTrade(final int to);

    public abstract void support(final int to);

    public abstract void castling(final int to);

    public abstract void enpassant(final int to);

    public abstract int getEnpassant();

    public abstract int getCastlingState();

    public abstract Collection<Move> getMoves();
}
