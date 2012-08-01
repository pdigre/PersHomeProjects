package no.pdigre.chess.rules;

public class MovePromote extends Move {

    public MovePromote(int from, int to, int type, IMove parent, int promotion) {
        super(from, to, type | (promotion << 7), parent);
    }

    @Override
    public int[] applyBoard(int[] in) {
        int[] board = in.clone();
        board[getFrom()] = 0;
        board[getTo()] = promotion(bitmap);
        return board;
    }

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
        return (moved & ~PIECE) | promotion(bitmap);
    }

	public static int promotion(int bitmap) {
		return ((bitmap >> 7) & 7) | (bitmap & ISBLACK);
	}


}
