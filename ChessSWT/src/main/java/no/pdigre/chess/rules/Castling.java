package no.pdigre.chess.rules;

public class Castling extends Move {

	public Castling(int from, int to, int type, AbstractMove parent) {
		super(from, to, type|AbstractMove.CASTLING, parent);
	}

	@Override
	public void apply(int[] board) {
		board[getFrom()] = 0;
		board[getTo()] = bitmap & PIECE;
	}

	@Override
	public Piece apply(Piece piece) {
		if(piece==null)
			return null;
		int pos=piece.pos;
		if(pos==getFrom())
			pos=getTo();
		return new Piece(bitmap & PIECE, pos, apply(piece.link));
	}

}
