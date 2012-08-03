package no.pdigre.chess.moves;

import no.pdigre.chess.base.INode;
import no.pdigre.chess.eval.FindMoves;

public final class Move implements INode {

    final private INode parent;

    final private int bitmap;

    final public static boolean isBlack(final int type) {
        return (type & BLACK) != 0;
    }

    public static Move createMove(final int from, final int to, final INode parent, int bitmap) {
        return new Move(parent, addHalf(bitmap, parent) | (from << _FROM) | (to << _TO));
    }

    private static int addHalf(int bitmap, INode parent) {
        return (bitmap & 7) == PAWN ? bitmap : ((parent.halfMoves() + 1) << _HALFMOVES) | bitmap;
    }

    public static Move createCastling(final int from, final int to, final INode parent, int bitmap) {
        return new Move(parent, bitmap | (from << _FROM) | (to << _TO) | SPECIAL);
    }

    public static Move createCapture(final int from, final int to, final INode parent, int bitmap, int victim) {
        return new Move(parent, bitmap | (from << _FROM) | (to << _TO) | (victim << _CAPTURE));
    }

    public static Move createEnPassant(final int from, final int to, final INode parent, int bitmap) {
        return new Move(parent, bitmap | (from << _FROM) | (to << _TO) | (PAWN << _CAPTURE) | SPECIAL);
    }

    public static Move createCapturePromote(final int from, final int to, final INode parent, int bitmap,
        int victim, int promotion) {
        return new Move(parent, ((bitmap & BLACK) | promotion) | (from << _FROM) | (to << _TO)
            | (victim << _CAPTURE) | SPECIAL);
    }

    public static Move createMovePromote(final int from, final int to, final INode parent, int bitmap,
        int promotion) {
        return new Move(parent, ((bitmap & BLACK) | promotion) | (from << _FROM) | (to << _TO) | SPECIAL);
    }

    protected Move(final INode parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap | updateCastling(bitmap, parent.getCastlingState());
    }

    final public int[] apply(int[] in) {
        int[] out = in.clone();
        int from = getFrom();
        out[from] = 0;
        int to = getTo();
        out[to] = bitmap & PIECE;
        if (isCastling()) {
            if (from > to) {
                out[from - 4] = 0;
                out[from - 1] = in[from - 4];
            } else {
                out[from + 3] = 0;
                out[from + 1] = in[from + 3];
            }
        } else if (isEnpassant()) {
            out[to + (to > from ? -8 : 8)] = 0;
        }
        return out;
    }

    final public int[] undo(int[] in) {
        int[] out = in.clone();
        out[getFrom()] = 0;
        int to = getTo();
        out[to] = bitmap & PIECE;
        return out;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(getFrom()) + " to " + FEN.pos2string(getTo()));
        int capture = ((bitmap >> _CAPTURE) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
        if (isEnpassant())
            sb.append(" enpassant");
        if (isCastling())
            sb.append(" castling");
        int[] board = getBoard();
        if (FindMoves.isCheck(this, board)) {
            sb.append(" check");
            if (FindMoves.isMate(this, board))
                sb.append("mate");
        }
        return sb.toString();
    }

    @Override
    final public boolean whiteTurn() {
        return (bitmap & BLACK) != 0;
    }

    final private static int updateCastling(int bitmap, int inherit) {
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

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if (whiteTurn())
            i++;
        return i;
    }

    @Override
    final public int halfMoves() {
        return (bitmap >> _HALFMOVES) & 63;
    }

    @Override
    final public int getEnpassant() {
        switch (bitmap & PIECE) {
            case PAWN:
                if (getFrom() - getTo() == -16)
                    return getFrom() + 8;
                return -1;
            case PAWN | BLACK:
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
        return (bitmap >> _FROM) & 63;
    }

    final public int getTo() {
        return (bitmap >> _TO) & 63;
    }

    final public boolean isCapture() {
        return (bitmap & CAPTURE) != 0;
    }

    final public boolean isCastling() {
        return (bitmap & (PIECETYPE | SPECIAL)) == (KING | SPECIAL);
    }

    final public boolean isEnpassant() {
        return (bitmap & (PIECETYPE | SPECIAL)) == (PAWN | SPECIAL);
    }

    final public boolean isPromotion() {
        return ((bitmap & SPECIAL) != 0) && (bitmap & PIECETYPE) != KING && (bitmap & PIECETYPE) != PAWN;
    }

}
