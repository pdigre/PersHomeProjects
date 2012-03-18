package no.pdigre.chess.rules;

public class Move2Queen extends Move {

	public Move2Queen(int from, int to, PieceType type, AbstractMove parent) {
		super(from, to, type, parent);
	}
	public void apply(PieceType[] board) {
		final PieceType type2 = type==PieceType.WHITE_PAWN?PieceType.WHITE_QUEEN:PieceType.BLACK_QUEEN;
		board[from] = null;
		board[to] = type2;
	}

	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==from)
			pos=to;
		final PieceType type2 = type==PieceType.WHITE_PAWN?PieceType.WHITE_QUEEN:PieceType.BLACK_QUEEN;
		return new Piece(type2, pos, apply(piece.link));
	}

}
