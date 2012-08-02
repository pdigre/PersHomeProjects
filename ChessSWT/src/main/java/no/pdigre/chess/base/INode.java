package no.pdigre.chess.base;

public abstract interface INode {

    public final static int PIECETYPE = 7 << 0;

    public final static int ISBLACK = 1 << 3;

    public final static int PIECE = 15 << 0;

    public final static int CAPTURE = 7 << 4;

    public final static int PROMOTE = 7 << 7;

    public final static int ENPASSANT = 1 << 10;

    public final static int CASTLING = 1 << 11;

    public final static int CURRENT = 63 << 12;

    public final static int FROM = 63 << 12;

    public final static int TO = 63 << 18;

    // Game state
    public final static int CASTLING_STATE = 15 << 24;

    public final static int NOCASTLE_WHITEKING = 1 << 24;

    public final static int NOCASTLE_WHITEQUEEN = 1 << 25;

    public final static int NOCASTLE_BLACKKING = 1 << 26;

    public final static int NOCASTLE_BLACKQUEEN = 1 << 27;

    public final static int CHECK = 1 << 28;

    public final static int MATE = 1 << 29;

    // piecetype
    public final static int NONE = 0;

    public final static int PAWN = 1;

    public final static int KNIGHT = 2;

    public final static int BISHOP = 3;

    public final static int ROOK = 4;

    public final static int QUEEN = 5;

    public final static int KING = 6;

    public final static int BLACK_PAWN = PAWN | ISBLACK;

    public final static int BLACK_KNIGHT = KNIGHT | ISBLACK;

    public final static int BLACK_BISHOP = BISHOP | ISBLACK;

    public final static int BLACK_ROOK = ROOK | ISBLACK;

    public final static int BLACK_QUEEN = QUEEN | ISBLACK;

    public final static int BLACK_KING = KING | ISBLACK;

    public abstract int getCastlingState();

    public abstract boolean whiteTurn();

    public abstract int totalMoves();

    public abstract int halfMoves();

    public abstract int[] getBoard();

    public abstract int getEnpassant();

    
}
