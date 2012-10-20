package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;

public final class Move implements IPosition {

    final private IPosition parent;

    final private int bitmap;

    public Move(final IPosition parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return FEN.printMove(getInherit(),getBoard());
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
