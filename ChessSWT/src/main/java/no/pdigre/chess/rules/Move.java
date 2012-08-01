package no.pdigre.chess.rules;

public class Move implements IMove{


    private final IMove parent;

    public int bitmap;

    public Move(final int from, final int to, final int type, final IMove parent) {
        super();
        this.bitmap = type | (from << 12) | (to << 18);
        this.parent = parent;
    }

    public int[] applyBoard(int[] in) {
        int[] out = in.clone();
        out[getFrom()] = 0;
        int i = bitmap & PIECE;
        out[getTo()] = i;
        return out;
    }

    public int[] applyPieces(final int[] in) {
        final int[] out=in.clone();
        final int current = bitmap & CURRENT;
        for (int i = 0; i < out.length; i++) {
            int pos = out[i];
            if ((pos & CURRENT) == current)
                out[i] =  moved(pos,bitmap);
        }
        return out;
    }

    @Override
    public String toString() {
        return PieceType.types[bitmap & PIECE] + " from " + pos2string(getFrom()) + " to " + pos2string(getTo());
    }

    final public static String pos2string(int pos) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefgh".charAt(pos&7));
        sb.append("12345678".charAt(pos >>3));
        return sb.toString();
    }

    @Override
    final public boolean whiteTurn() {
        return (bitmap & ISBLACK) != 0;
    }

    final public int breakCastle(int state) {
        switch (bitmap & PIECE) {
            case KING:
                return state | NOCASTLE_WHITEKING | NOCASTLE_WHITEQUEEN;
            case ROOK:
                switch (getFrom()) {
                    case 0:
                        return state | NOCASTLE_WHITEQUEEN;
                    case 7:
                        return state | NOCASTLE_WHITEKING;
                    default:
                        return state;
                }
            case KING | ISBLACK:
                return state | NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN;
            case ROOK | ISBLACK:
                switch (getFrom()) {
                    case 56:
                        return state | NOCASTLE_BLACKQUEEN;
                    case 63:
                        return state | NOCASTLE_BLACKKING;
                    default:
                        return state;
                }
            default:
                return state;
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
    public int halfMoves() {
        if ((bitmap & PIECETYPE) == PAWN)
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
    public int[] getPieces() {
        return applyPieces(parent.getPieces());
    }

    @Override
    final public int[] getBoard() {
        return applyBoard(parent.getBoard());
    }

    @Override
    final public int getCastlingState() {
        return breakCastle(parent.getCastlingState());
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

    final public static boolean isBlack(final int type) {
        return (type & ISBLACK) != 0;
    }

    public static int moved(int pos,int bitmap) {
        return (pos & ~CURRENT) | ((bitmap >> 6) & CURRENT);
    }

}
