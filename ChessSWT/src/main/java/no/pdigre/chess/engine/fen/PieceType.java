package no.pdigre.chess.engine.fen;


public enum PieceType {
    WHITE_PAWN(100, 'P', 1),
    WHITE_KNIGHT(300, 'N', 2),
    WHITE_BISHOP(300, 'B', 3),
    WHITE_ROOK(500, 'R', 4),
    WHITE_QUEEN(900, 'Q', 5),
    WHITE_KING(10000, 'K', 6),
    BLACK_PAWN(-100, 'p', 9),
    BLACK_KNIGHT(-300, 'n', 10),
    BLACK_BISHOP(-300, 'b', 11),
    BLACK_ROOK(-500, 'r', 12),
    BLACK_QUEEN(-900, 'q', 13),
    BLACK_KING(-10000, 'k', 14);

    final public int weight;

    final public char fen;

    final public int bitmap;


    final public static PieceType[] types = new PieceType[] { null, WHITE_PAWN, WHITE_KNIGHT, WHITE_BISHOP,
        WHITE_ROOK, WHITE_QUEEN, WHITE_KING, null, null, BLACK_PAWN, BLACK_KNIGHT, BLACK_BISHOP, BLACK_ROOK,
        BLACK_QUEEN, BLACK_KING, null };

    PieceType(int weight, char fen, int bitmap) {
        this.weight = weight;
        this.fen = fen;
        this.bitmap = bitmap;
    }

    final public static PieceType lookup(char fen) {
        for (PieceType type : PieceType.values()) {
            if (type.fen == fen)
                return type;
        }
        return null;
    }


}