package no.pdigre.chess.rules;

public class EnPassant extends Capture {

	public EnPassant(int from, int to, int type, AbstractMove parent, int victim) {
		super(from, to, type|AbstractMove.ENPASSANT,parent, victim);
	}

	@Override
	public String toString() {
		return super.toString() + " enpassant ";
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
		if(pos==getFrom()-PieceType.forward(bitmap))
			return apply(piece.link);
		if(pos==getFrom())
			pos=getTo();
		return new Piece(piece.type, pos, apply(piece.link));
	}

	@Override
	public void apply(int[] board) {
		board[getFrom()] = 0;
		board[getFrom()-PieceType.forward(bitmap)]=0;
		board[getTo()] = bitmap & PIECE;
	}
}
