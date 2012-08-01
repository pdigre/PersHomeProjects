package no.pdigre.chess.rules;

public class Castling extends Move {

    public Castling(int from, int to, int type, IMove parent) {
        super(from, to, type | IMove.CASTLING, parent);
    }

    @Override
    public int[] applyBoard(int[] in) {
        int[] board = in.clone();
        board[getFrom()] = 0;
        board[getTo()] = bitmap & PIECE;
        return board;
    }

    // @Override
    // public Piece apply(Piece piece) {
    // if(piece==null)
    // return null;
    // int pos=piece.pos;
    // if(pos==getFrom())
    // pos=getTo();
    // return new Piece(bitmap & PIECE, pos, apply(piece.link));
    // }

    @Override
    public int[] applyPieces(final int[] in) {
        int[] out = in.clone();
        final int current = bitmap & CURRENT;
        final int from = getFrom();
        boolean isRight = from > getTo();
        int castle = (from + (isRight ? 3 : -4)) << 12;
        for (int i = 0; i < out.length; i++) {
            int pos = out[i];
            int p = pos & CURRENT;
            if (p == current)
                out[i] = moved(pos, bitmap);
            else if (p == castle)
                out[i] = moved(pos, (from + (isRight ? 1 : -1)) << 12);
        }
        return out;
    }
}
