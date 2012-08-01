package no.pdigre.chess.rules;

public class CapturePromote extends Capture{

	public CapturePromote(int from, int to, int type, IMove parent, int victim, int promotion) {
		super(from, to, type|(promotion<<7), parent, victim);
	}

	@Override
	public int[] applyBoard(int[] in) {
	    int[] out=in.clone();
		out[getFrom()] = 0;
		out[getTo()] = MovePromote.promotion(bitmap);
		return out;
	}

    @Override
    public int[] applyPieces(final int[] in) {
        final int current = bitmap & CURRENT;
		final int to = (bitmap & TO)>>6;
        int[] out=new int[in.length-1];
        for (int i = 0,j=0; i < in.length; i++) {
            int pos = in[i];
            int p = pos & CURRENT;
            if (p == current) {
                out[j] = MovePromote.promoted(moved(pos,bitmap),bitmap);
                j++;
            } else 
                if (p != to) {
                    out[j]=pos;
                    j++;
                }
        }
        return out;
    }

}
