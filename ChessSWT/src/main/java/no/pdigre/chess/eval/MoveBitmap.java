package no.pdigre.chess.eval;

import no.pdigre.chess.base.INode;

public class MoveBitmap implements INode {

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

    final public static int updateCastling(int bitmap, int inherit) {
        switch (bitmap & PIECE) {
            case KING:
                return inherit | NOCASTLE_WHITEKING | NOCASTLE_WHITEQUEEN;
            case ROOK:
                switch ((bitmap >> _FROM) & 63) {
                    case 0:
                        return inherit | NOCASTLE_WHITEQUEEN;
                    case 7:
                        return inherit | NOCASTLE_WHITEKING;
                    default:
                        return inherit;
                }
            case KING | BLACK:
                return inherit | NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN;
            case ROOK | BLACK:
                switch ((bitmap >> _FROM) & 63) {
                    case 56:
                        return inherit | NOCASTLE_BLACKQUEEN;
                    case 63:
                        return inherit | NOCASTLE_BLACKKING;
                    default:
                        return inherit;
                }
            default:
                return inherit;
        }
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
        return (bitmap & INode.BLACK) == 0;
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

    final public static int addHalf(int bitmap, int halmoves) {
        return (bitmap & 7) == PAWN ? bitmap : ((halmoves + 1) << _HALFMOVES) | bitmap;
    }

    final public static int mapMove(final int from, final int to, final int halmoves, int bitmap) {
        int bm = (bitmap & 7) == PAWN ? bitmap : ((halmoves + 1) << _HALFMOVES) | bitmap;
        return bm | (from << _FROM) | (to << _TO);
    }

    final public static int mapCastling(final int from, final int to, int bitmap) {
        return bitmap | (from << _FROM) | (to << _TO) | SPECIAL;
    }

    final public static int mapCreature(final int from, final int to, int bitmap, int victim) {
        return bitmap | (from << _FROM) | (to << _TO) | (victim << _CAPTURE);
    }

    final public static int mapEnpassant(final int from, final int to, int bitmap) {
        return bitmap | (from << _FROM) | (to << _TO) | (PAWN << _CAPTURE) | SPECIAL;
    }

    final public static int mapCapturePromote(final int from, final int to, int bitmap, int victim, int promotion) {
        return ((bitmap & BLACK) | promotion) | (from << _FROM) | (to << _TO) | (victim << _CAPTURE) | SPECIAL;
    }

    final public static int mapPromote(final int from, final int to, int bitmap, int promotion) {
        return ((bitmap & BLACK) | promotion) | (from << _FROM) | (to << _TO) | SPECIAL;
    }

    @Override
    public int getCastlingState() {
        return 0;
    }

    @Override
    public boolean whiteTurn() {
        return false;
    }

    @Override
    public int totalMoves() {
        return 0;
    }

    @Override
    public int halfMoves() {
        return 0;
    }

    @Override
    public int[] getBoard() {
        return null;
    }

    @Override
    public int getEnpassant() {
        return 0;
    }

    @Override
    public int getBitmap() {
        return 0;
    }

    final public static int type(final int bitmap) {
        return bitmap & 7;
    }

    final public static int halfMoves(final int bitmap) {
        return (bitmap >> _HALFMOVES) & 63;
    }

    public static int getEnpassant(final int bitmap) {
        switch (bitmap & PIECE) {
            case PAWN:
                if (MoveBitmap.getFrom(bitmap) - MoveBitmap.getTo(bitmap) == -16)
                    return MoveBitmap.getFrom(bitmap) + 8;
                return -1;
            case PAWN | BLACK:
                if (MoveBitmap.getFrom(bitmap) - MoveBitmap.getTo(bitmap) == 16)
                    return MoveBitmap.getFrom(bitmap) - 8;
                return -1;
            default:
                return -1;
        }
    }

}
