package no.pdigre.chess.moves;

import no.pdigre.chess.base.INode;

public final class Move implements INode {

    private final INode parent;

    public int bitmap;

    final public static boolean isBlack(final int type) {
        return (type & ISBLACK) != 0;
    }

    final public static int moved(int pos, int bitmap) {
        return (pos & ~CURRENT) | ((bitmap >> 6) & CURRENT);
    }

    final public static int promoted(int moved, int bitmap) {
        return (moved & ~PIECE) | promotion(bitmap);
    }

    final public static int promotion(int bitmap) {
        return ((bitmap >> 7) & 7) | (bitmap & ISBLACK);
    }

    public static Move createMove(final int from, final int to, final INode parent, int bitmap) {
        return new Move(parent, bitmap | (from << 12) | (to << 18));
    }

    public static Move createCastling(final int from, final int to, final INode parent, int bitmap) {
        return new Move(parent, bitmap | (from << 12) | (to << 18) | CASTLING);
    }

    public static Move createCapture(final int from, final int to, final INode parent, int bitmap, int victim) {
        return new Move(parent, bitmap | (from << 12) | (to << 18) | (victim << 4));
    }

    public static Move createEnPassant(final int from, final int to, final INode parent, int bitmap, int victim) {
        return new Move(parent, bitmap | (from << 12) | (to << 18) | (victim << 4) | INode.ENPASSANT);
    }

    public static Move createCapturePromote(final int from, final int to, final INode parent, int bitmap,
        int victim, int promotion) {
        return new Move(parent, bitmap | (from << 12) | (to << 18) | (victim << 4) | (promotion << 7));
    }

    public static Move createMovePromote(final int from, final int to, final INode parent, int bitmap,
        int promotion) {
        return new Move(parent, bitmap | (from << 12) | (to << 18) | (promotion << 7));
    }

    protected Move(final INode parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap | updateCastling(bitmap, parent.getCastlingState());
    }

    public int[] apply(int[] in) {
        int[] out = in.clone();
        out[getFrom()] = 0;
        int promotion = bitmap & PROMOTE;
        int to = getTo();
        out[to] = promotion == 0 ? bitmap & PIECE : (promotion >> 7) | (bitmap & ISBLACK);
        if ((bitmap & CASTLING) != 0) {
            // TODO
        } else if ((bitmap & ENPASSANT) != 0) {
            out[to + (to > getFrom() ? -8 : 8)] = 0;
        }
        return out;
    }

    public int[] undo(int[] in) {
        int[] out = in.clone();
        out[getFrom()] = 0;
        int promotion = bitmap & PROMOTE;
        int to = getTo();
        out[to] = promotion == 0 ? bitmap & PIECE : (promotion >> 7) | (bitmap & ISBLACK);
        if ((bitmap & CASTLING) != 0) {
            // TODO
        } else if ((bitmap & ENPASSANT) != 0) {
            out[to + (to > getFrom() ? -8 : 8)] = 0;
        }
        return out;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(getFrom()) + " to " + FEN.pos2string(getTo()));
        int capture = ((bitmap >> 4) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & ISBLACK) ^ ISBLACK)]);
        if ((bitmap & ENPASSANT) != 0)
            sb.append(" enpassant");
        return sb.toString();
    }

    @Override
    final public boolean whiteTurn() {
        return (bitmap & ISBLACK) != 0;
    }

    final private static int updateCastling(int bitmap, int inherit) {
        switch (bitmap & PIECE) {
            case KING:
                return inherit | NOCASTLE_WHITEKING | NOCASTLE_WHITEQUEEN;
            case ROOK:
                switch ((bitmap >> 12) & 63) {
                    case 0:
                        return inherit | NOCASTLE_WHITEQUEEN;
                    case 7:
                        return inherit | NOCASTLE_WHITEKING;
                    default:
                        return inherit;
                }
            case KING | ISBLACK:
                return inherit | NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN;
            case ROOK | ISBLACK:
                switch ((bitmap >> 12) & 63) {
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

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if (whiteTurn())
            i++;
        return i;
    }

    @Override
    final public int halfMoves() {
        if ((bitmap & PIECETYPE) == PAWN || ((bitmap >> 4) & 7) != 0 || (bitmap & CASTLING) != 0)
            return 0;
        return parent.halfMoves() + 1;
    }

    @Override
    final public int getEnpassant() {
        switch (bitmap & PIECE) {
            case PAWN:
                if (getFrom() - getTo() == -16)
                    return getFrom() + 8;
                return -1;
            case PAWN | ISBLACK:
                if (getFrom() - getTo() == 16)
                    return getFrom() - 8;
                return -1;
            default:
                return -1;
        }
    }

    @Override
    final public int[] getBoard() {
        return apply(parent.getBoard());
    }

    @Override
    final public int getCastlingState() {
        return bitmap & CASTLING_STATE;
    }

    final public int getFrom() {
        return (bitmap >> 12) & 63;
    }

    final public static int getPos(int pos) {
        return (pos >> 12) & 63;
    }

    final public static int getType(int pos) {
        return pos & 15;
    }

    final public int getTo() {
        return (bitmap >> 18) & 63;
    }

    public boolean isCastling() {
        return (bitmap & CASTLING) != 0;
    }

    public boolean isEnpassant() {
        return (bitmap & ENPASSANT) != 0;
    }

    public boolean isCapture() {
        return (bitmap & CAPTURE) != 0;
    }

}
