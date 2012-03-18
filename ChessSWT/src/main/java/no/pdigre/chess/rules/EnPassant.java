package no.pdigre.chess.rules;

public class EnPassant extends Beat {
	public int enpassant;

	public EnPassant(int from, int to, PieceType type, AbstractMove parent, PieceType victim,int enpassant) {
		super(from, to, type,parent, victim);
		this.enpassant=enpassant;
	}

	@Override
	public String toString() {
		return super.toString() + " enpassant ";
	}

	public int halfMoves() {
		return 0;
	}

	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==enpassant-type.forward)
			return apply(piece.link);
		if(pos==from)
			pos=to;
		return new Piece(piece.type, pos, apply(piece.link));
	}

	public void apply(PieceType[] board) {
		board[from] = null;
		board[enpassant-type.forward]=null;
		board[to] = type;
	}

}
