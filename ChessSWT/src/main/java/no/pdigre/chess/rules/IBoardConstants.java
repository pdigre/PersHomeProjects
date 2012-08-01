package no.pdigre.chess.rules;


public interface IBoardConstants {
    public final static int PIECETYPE = 7 << 0;

    public final static int ISBLACK = 1 << 3;

    public final static int PIECE = 15 << 0;

    public final static int CAPTURE = 7 << 4;

    public final static int PROMOTE = 7 << 7;

    public final static int ENPASSANT = 1 << 10;

    public final static int CASTLING = 1 << 11;

    public final static int FROM = 63 << 12;

    public final static int CURRENT = 63 << 12;

    public final static int TO = 63 << 18;

    // piecetype
    public final static int NONE = 0;

    public final static int PAWN = 1;

    public final static int KNIGHT = 2;

    public final static int BISHOP = 3;

    public final static int ROOK = 4;

    public final static int QUEEN = 5;

    public final static int KING = 6;

}
