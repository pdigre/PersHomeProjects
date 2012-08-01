package no.pdigre.chess.rules;

public class MovePromote extends Move implements IPromotion {

    public MovePromote(int from, int to, int type, IMove parent, int promotion) {
        super(from, to, type | (promotion << 7), parent);
    }

    @Override
    public int[] applyBoard(int[] in) {
        int[] board = in.clone();
        board[getFrom()] = 0;
        board[getTo()] = getPromotionType();
        return board;
    }

    // @Override
    // public Piece apply(Piece piece) {
    // if(piece==null)
    // return null;
    // int pos=piece.pos;
    // if(pos==getFrom())
    // pos=getTo();
    // return new Piece(getPromotionType(), pos, apply(piece.link));
    // }

    @Override
    public int[] applyPieces(final int[] in) {
        final int[] out = in.clone();
        final int current = bitmap & CURRENT;
        for (int i = 0; i < out.length; i++) {
            int pos = out[i];
            if ((pos & CURRENT) == current)
                out[i] = promoted(moved(pos, bitmap), bitmap);
        }
        return out;
    }

    public static int promoted(int moved, int bitmap) {
        return (moved & ~PIECE) | (bitmap >> 7) & 7;
    }

    @Override
    public int getPromotionType() {
        return (bitmap >> 7) & 7;
    }

}
