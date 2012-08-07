package no.pdigre.chess.eval;

import no.pdigre.chess.base.INode;

public final class Move implements INode {

    final private INode parent;

    final private int bitmap;

    protected Move(final INode parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return MoveBitmap.printMove(getBitmap(),getBoard());
    }

   @Override
    final public boolean whiteTurn() {
        return (getBitmap() & BLACK) != 0;
    }

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if ((getBitmap() & BLACK) != 0)
            i++;
        return i;
    }

    @Override
    final public int[] getBoard() {
        return MoveBitmap.apply(parent.getBoard(), getBitmap());
    }

    @Override
    public int getBitmap() {
        return bitmap;
    }

}
