package no.pdigre.chess.rules;

public class Castling extends Move {

	public Castling(int from, int to, PieceType type, AbstractMove parent) {
		super(from, to, type, parent);
	}

	public void apply(PieceType[] board) {
		board[from] = null;
		board[to] = type;
	}

	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==from)
			pos=to;
		return new Piece(type, pos, apply(piece.link));
	}

}
