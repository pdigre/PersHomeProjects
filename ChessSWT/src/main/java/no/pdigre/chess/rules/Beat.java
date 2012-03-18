package no.pdigre.chess.rules;

public class Beat extends Move {
	public PieceType beat;

	public Beat(int from, int to, PieceType type, AbstractMove parent, PieceType victim) {
		super(from, to, type, parent);
		this.beat = victim;
	}

	@Override
	public String toString() {
		return super.toString() + " beats " + beat;
	}

	public int halfMoves() {
		return 0;
	}

	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==to)
			return apply(piece.link);
		if(pos==from)
			pos=to;
		return new Piece(piece.type, pos, apply(piece.link));
	}


}
