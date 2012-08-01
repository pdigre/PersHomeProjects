package no.pdigre.chess.rules;

public class Capture extends Move {

	public Capture(int from, int to, int type, AbstractMove parent, int victim) {
		super(from,to,type|(victim << 4),parent);
	}

	@Override
	public String toString() {
		return super.toString() + " beats " + ((bitmap>>4)&7);
	}

	@Override
	public int halfMoves() {
		return 0;
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
		return new Piece(piece.type, pos, apply(piece.link));
	}


}
