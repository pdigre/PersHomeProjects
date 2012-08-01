package no.pdigre.chess.rules;

public class CapturePromote extends Capture implements IPromotion{

	public CapturePromote(int from, int to, int type, AbstractMove parent, int victim, int promotion) {
		super(from, to, type|(promotion<<7), parent, victim);
	}

	@Override
	public void apply(int[] board) {
		board[getFrom()] = 0;
		board[getTo()] = getPromotionType();
	}

	@Override
	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==getTo())
			return apply(piece.link);
		if(pos==getFrom())
			pos=getTo();
		return new Piece(getPromotionType(), pos, apply(piece.link));
	}

	@Override
	public int getPromotionType() {
		return ((bitmap>>7)&7)|(bitmap&AbstractMove.ISBLACK);
	}

}
