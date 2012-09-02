package no.pdigre.chess.base;

import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.PieceType;

public class Bitmap implements IConst {

    final static public int[] apply(final int[] in, final int bitmap) {
        int[] out = in.clone();
        int from = getFrom(bitmap);
        out[from] = 0;
        int to = getTo(bitmap);
        out[to] = bitmap & PIECE;
        if (isCastling(bitmap)) {
            if (from > to) {
                out[from - 4] = 0;
                out[from - 1] = in[from - 4];
            } else {
                out[from + 3] = 0;
                out[from + 1] = in[from + 3];
            }
        } else if (isEnpassant(bitmap)) {
            out[to + (to > from ? -8 : 8)] = 0;
        }
        return out;
    }

    final public static int[] undo(int[] in, int bitmap) {
        int[] out = in.clone();
        out[getFrom(bitmap)] = 0;
        int to = getTo(bitmap);
        out[to] = bitmap & PIECE;
        return out;
    }

    final public static int getCastlingState(final int bitmap) {
        return bitmap & CASTLING_STATE;
    }

    final static public int getFrom(final int bitmap) {
        return (bitmap >> _FROM) & 63;
    }

    final static public int getTo(final int bitmap) {
        return (bitmap >> _TO) & 63;
    }

    final public static boolean isCapture(final int bitmap) {
        return (bitmap & CAPTURE) != 0;
    }

    final static public boolean white(final int bitmap) {
        return (bitmap & IConst.BLACK) == 0;
    }

    final static public boolean isCastling(final int bitmap) {
        return (bitmap & (PIECETYPE | SPECIAL)) == (KING | SPECIAL);
    }

    final static public boolean isEnpassant(final int bitmap) {
        return (bitmap & (PIECETYPE | SPECIAL)) == (PAWN | SPECIAL);
    }

    final public static boolean isPromotion(final int bitmap) {
        return ((bitmap & SPECIAL) != 0) && (bitmap & PIECETYPE) != KING && (bitmap & PIECETYPE) != PAWN;
    }

    final private static int setFromTo(int bitmap, final int from, final int to) {
        return bitmap | (from << _FROM) | (to << _TO);
    }

    final public static int mapMove(final int from, final int to, final int halmoves, int bitmap) {
        return setFromTo(((bitmap & 7) == PAWN ? bitmap : ((halmoves + 1) << _HALFMOVES) | bitmap), from, to);
    }

    final public static int mapCastling(final int from, final int to, int bitmap) {
        return setFromTo(bitmap, from, to) | SPECIAL;
    }

    final public static int mapCapture(final int from, final int to, int bitmap, int victim) {
        return setFromTo(bitmap, from, to) | (victim << _CAPTURE);
    }

    final public static int mapEnpassant(final int from, final int to, int bitmap) {
        return setFromTo(bitmap, from, to) | (PAWN << _CAPTURE) | SPECIAL;
    }

    final public static int mapCapturePromote(final int from, final int to, int bitmap, int victim, int promotion) {
        return setFromTo(promote(bitmap, promotion), from, to) | SPECIAL | (victim << _CAPTURE);
    }

    final public static int mapPromote(final int from, final int to, int bitmap, int promotion) {
        return setFromTo(promote(bitmap, promotion), from, to) | SPECIAL;
    }

    final private static int promote(int bitmap, int promotion) {
        return (bitmap & BLACK) | promotion;
    }

    final public static int bitPawnEnpassant(int[] board, int from, int inherit, int to) {
        return castling(mapEnpassant(from, to, board[from]) | (inherit & CASTLING_STATE));
    }

    final public static int bitPawnCapture(int[] board, int from, int inherit, int to) {
        return castling(mapCapture(from, to, board[from], board[to] & 7) | (inherit & CASTLING_STATE));
    }

    final public static int bitPawnCapturePromote(int[] board, int from, int inherit, int to) {
        return castling(mapCapturePromote(from, to, board[from], board[to] & 7, 0) | (inherit & CASTLING_STATE));
    }

    final public static int bitPawnPromote(int[] board, int from, int inherit, int to) {
        return castling(mapPromote(from, to, board[from], 0) | (inherit & CASTLING_STATE));
    }

    final public static int bitMove(int from, int inherit, int to, int bitmap) {
        return castling(mapMove(from, to, Bitmap.halfMoves(inherit), bitmap) | (inherit & CASTLING_STATE));
    }

    final public static int bitCastling(final int[] board, int from, int inherit, int to) {
        return castling(mapCastling(from, to, board[from]) | (inherit & CASTLING_STATE));
    }

    private static int castling(int bitmap) {
        switch (bitmap & PIECE) {
            case KING:
                return bitmap | NOCASTLE_WHITEKING | NOCASTLE_WHITEQUEEN;
            case ROOK:
                switch ((bitmap >> _FROM) & 63) {
                    case 0:
                        return bitmap | NOCASTLE_WHITEQUEEN;
                    case 7:
                        return bitmap | NOCASTLE_WHITEKING;
                    default:
                        return bitmap;
                }
            case KING | BLACK:
                return bitmap | NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN;
            case ROOK | BLACK:
                switch ((bitmap >> _FROM) & 63) {
                    case 56:
                        return bitmap | NOCASTLE_BLACKQUEEN;
                    case 63:
                        return bitmap | NOCASTLE_BLACKKING;
                    default:
                        return bitmap;
                }
            default:
                return bitmap;
        }
    }

    final public static int type(final int bitmap) {
        return bitmap & 7;
    }

    final public static int halfMoves(final int bitmap) {
        return (bitmap >> _HALFMOVES) & 63;
    }

    public static int getEnpassant(final int bitmap) {
        int from2 = Bitmap.getFrom(bitmap);
        int to2 = Bitmap.getTo(bitmap);
        switch (bitmap & PIECE) {
            case PAWN:
                if (from2 - to2 == -16)
                    return from2 + 8;
                return -1;
            case PAWN | BLACK:
                if (from2 - to2 == 16)
                    return from2 - 8;
                return -1;
            default:
                return -1;
        }
    }

    public static String printMove(int bitmap, int[] board) {
        StringBuilder sb = new StringBuilder();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(Bitmap.getFrom(bitmap)) + " to "
            + FEN.pos2string(Bitmap.getTo(bitmap)));
        int capture = ((bitmap >> _CAPTURE) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
        if (Bitmap.isEnpassant(bitmap))
            sb.append(" enpassant");
        if (Bitmap.isCastling(bitmap))
            sb.append(" castling");
        boolean white = Bitmap.white(bitmap);
        if (!NodeGenerator.checkSafe(board, NodeGenerator.getKingPos(board, white), white)) {
            sb.append(" check");
            if (!NodeGenerator.hasLegalMoves(board, bitmap))
                sb.append("mate");
        }
        return sb.toString();
    }

    public static int value(final int type) {
        switch (type) {
            case PAWN:
                return 100;
            case KNIGHT:
                return 300;
            case BISHOP:
                return 325;
            case ROOK:
                return 500;
            case QUEEN:
                return 900;
            case KING:
                return 100000;
            case BLACK_PAWN:
                return -100;
            case BLACK_KNIGHT:
                return -300;
            case BLACK_BISHOP:
                return -325;
            case BLACK_ROOK:
                return -500;
            case BLACK_QUEEN:
                return -900;
            case BLACK_KING:
                return -100000;
            default:
                return 0;
        }
    }
}
