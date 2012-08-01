package no.pdigre.chess.rules;

public class MovePromote extends Move implements IPromotion{

	public MovePromote(int from, int to, int type, AbstractMove parent,int promotion) {
		super(from, to, type|(promotion<<7), parent);
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
		if(pos==getFrom())
			pos=getTo();
		return new Piece(getPromotionType(), pos, apply(piece.link));
	}

	@Override
	public int getPromotionType() {
		return ((bitmap>>7)&7)|(bitmap&AbstractMove.ISBLACK);
	}

}
