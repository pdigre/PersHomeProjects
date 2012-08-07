package no.pdigre.chess.eval;

import no.pdigre.chess.base.ICallBack;
import no.pdigre.chess.base.Bitmap;

public final class Move implements ICallBack {

    final private ICallBack parent;

    final private int bitmap;

    protected Move(final ICallBack parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return Bitmap.printMove(getInherit(),getBoard());
    }

   @Override
    final public boolean whiteTurn() {
        return (getInherit() & BLACK) != 0;
    }

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if ((getInherit() & BLACK) != 0)
            i++;
        return i;
    }

    @Override
    final public int[] getBoard() {
        return Bitmap.apply(parent.getBoard(), getInherit());
    }

    @Override
    public int getInherit() {
        return bitmap;
    }

}
