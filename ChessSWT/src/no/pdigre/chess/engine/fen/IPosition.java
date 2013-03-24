package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;

public abstract interface IPosition extends IConst{


    public abstract boolean whiteTurn();

    public abstract int totalMoves();

    public abstract int[] getBoard();

    /**
     * Returns the castling and halfmoves state
     * @return
     */
    public abstract int getBitmap();

}
