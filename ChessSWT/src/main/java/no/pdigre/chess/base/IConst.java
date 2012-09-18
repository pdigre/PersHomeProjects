package no.pdigre.chess.base;


public interface IConst {
    public final static int PIECETYPE = 7 << 0;

    public final static int BLACK = 1 << 3;

    public final static int PIECE = 15 << 0;

    public final static int _CAPTURE = 4;

    public final static int CAPTURE = 7 << _CAPTURE;

    public final static int SPECIAL = 1 << 7;

    public final static int _FROM = 8;

    public final static int FROM = 63 << _FROM;

    public final static int _TO = 14;

    public final static int TO = 63 << _TO;

    // Game state
    public final static int _CASTLING = 20;

    public final static int CASTLING_STATE = 15 << _CASTLING;

    public final static int NOCASTLE_WHITEQUEEN = 1 << (_CASTLING);

    public final static int NOCASTLE_WHITEKING = 1 << (_CASTLING + 1);

    public final static int NOCASTLE_BLACKQUEEN = 1 << (_CASTLING + 2);

    public final static int NOCASTLE_BLACKKING = 1 << (_CASTLING + 3);

    public final static int _HALFMOVES = 24;

    public final static int HALFMOVES = 63 << _HALFMOVES;

    // piecetype
    public final static int NONE = 0;

    public final static int PAWN = 1;

    public final static int KNIGHT = 2;

    public final static int BISHOP = 3;

    public final static int ROOK = 4;

    public final static int QUEEN = 5;

    public final static int KING = 6;

    public final static int BLACK_PAWN = PAWN | BLACK;

    public final static int BLACK_KNIGHT = KNIGHT | BLACK;

    public final static int BLACK_BISHOP = BISHOP | BLACK;

    public final static int BLACK_ROOK = ROOK | BLACK;

    public final static int BLACK_QUEEN = QUEEN | BLACK;

    public final static int BLACK_KING = KING | BLACK;

}
