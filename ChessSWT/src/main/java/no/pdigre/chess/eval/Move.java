package no.pdigre.chess.eval;

import no.pdigre.chess.base.INode;

public final class Move implements INode {

    final private INode parent;

    final private int bitmap;

    protected Move(final INode parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    final public int[] apply(int[] in) {
        return MoveBitmap.apply(in, getBitmap());
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
        if (whiteTurn())
            i++;
        return i;
    }

    @Override
    final public int halfMoves() {
        return MoveBitmap.halfMoves(getBitmap());
    }

    @Override
    final public int getEnpassant() {
        return MoveBitmap.getEnpassant(getBitmap());
    }


    @Override
    final public int[] getBoard() {
        return apply(parent.getBoard());
    }

    @Override
    final public int getCastlingState() {
        return MoveBitmap.getCastlingState(getBitmap());
    }

    @Override
    public int getBitmap() {
        return bitmap;
    }

    final public int getFrom() {
        return MoveBitmap.getFrom(getBitmap());
    }

    final public int getTo() {
        return MoveBitmap.getTo(getBitmap());
    }

    final public boolean isCapture() {
        return MoveBitmap.isCapture(getBitmap());
    }

    final public boolean isCastling() {
        return MoveBitmap.isCastling(getBitmap());
    }

    final public boolean isEnpassant() {
        return MoveBitmap.isEnpassant(getBitmap());
    }

    final public boolean isPromotion() {
        return MoveBitmap.isPromotion(getBitmap());
    }

}
