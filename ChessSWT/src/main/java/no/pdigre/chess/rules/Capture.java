package no.pdigre.chess.rules;

public class Capture extends Move {

	public Capture(int from, int to, int type, IMove parent, int victim) {
		super(from, to, type | (victim << 4), parent);
	}

	@Override
	public String toString() {
		int blk = (bitmap & ISBLACK) ;
		int t = ((bitmap >> 4) & 7) | (blk ^ ISBLACK)  ;
		PieceType victim = PieceType.types[t];
		return super.toString() + " beats "
				+ victim;
	}

	@Override
	public int halfMoves() {
		return 0;
	}

	@Override
	public int[] applyPieces(final int[] in) {
		final int current = bitmap & CURRENT;
		final int to = (bitmap & TO)>>6;
		int[] out = new int[in.length - 1];
		for (int i = 0, j = 0; i < in.length; i++) {
			int pos = in[i];
			int p = pos & CURRENT;
			if (p == current) {
				out[j] = moved(pos, bitmap);
				j++;
			} else if (p != to) {
				out[j] = pos;
				j++;
			}
		}
		return out;
	}
}
