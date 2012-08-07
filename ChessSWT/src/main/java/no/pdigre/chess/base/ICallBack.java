package no.pdigre.chess.base;

public abstract interface ICallBack extends IConst{


    public abstract boolean whiteTurn();

    public abstract int totalMoves();

    public abstract int[] getBoard();

    /**
     * Returns the castling and halfmoves state
     * @return
     */
    public abstract int getInherit();

}
