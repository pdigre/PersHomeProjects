package no.pdigre.chess.rules;

public class CapturePromote extends Capture implements IPromotion{

	public CapturePromote(int from, int to, int type, IMove parent, int victim, int promotion) {
		super(from, to, type|(promotion<<7), parent, victim);
	}

	@Override
	public int[] applyBoard(int[] in) {
	    int[] out=in.clone();
		out[getFrom()] = 0;
		out[getTo()] = getPromotionType();
		return out;
	}

//	@Override
//	public Piece apply(Piece piece) {
//		if(piece==null)
//			return null;
//		int pos=piece.pos;
//		if(pos==getTo())
//			return apply(piece.link);
//		if(pos==getFrom())
//			pos=getTo();
//		return new Piece(getPromotionType(), pos, apply(piece.link));
//	}

    @Override
    public int[] applyPieces(final int[] in) {
        final int current = bitmap & CURRENT;
        final int to = bitmap & TO;
        int[] out=new int[in.length-1];
        for (int i = 0,j=0; i < in.length; i++) {
            int pos = in[i];
            int p = pos & CURRENT;
            if (p == current) {
                out[j] = MovePromote.promoted(moved(pos,bitmap),bitmap);
            } else 
                if (p != to) {
                    out[j]=pos;
                    j++;
                }
        }
        return out;
    }

	@Override
	public int getPromotionType() {
		return ((bitmap>>7)&7)|(bitmap&IMove.ISBLACK);
	}

}
