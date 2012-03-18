package no.pdigre.chess.rules;

public class Beat2Knight extends Beat {

	public Beat2Knight(int from, int to, PieceType type, AbstractMove parent, PieceType victim) {
		super(from, to, type, parent, victim);
	}

	public void apply(PieceType[] board) {
		final PieceType type2 = type==PieceType.WHITE_PAWN?PieceType.WHITE_KNIGHT:PieceType.BLACK_KNIGHT;
		board[from] = null;
		board[to] = type2;
	}

	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==to)
			return apply(piece.link);
		if(pos==from)
			pos=to;
		final PieceType type2 = type==PieceType.WHITE_PAWN?PieceType.WHITE_KNIGHT:PieceType.BLACK_KNIGHT;
		return new Piece(type2, pos, apply(piece.link));
	}

}
