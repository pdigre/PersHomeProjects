package no.pdigre.chess.rules;


public class Move extends AbstractMove {
	public final PieceType type;
	public final int from;
	public final int to;
	public final AbstractMove parent;

	public Move(int from, int to, PieceType type, AbstractMove parent) {
		super();
		this.type = type;
		this.from = from;
		this.to = to;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return type + " from " + pos2string(from) + " to " + pos2string(to);
	}

	public String pos2string(int pos) {
		int h = pos % 8;
		StringBuilder sb = new StringBuilder();
		sb.append("abcdefgh".charAt((pos - h) / 8));
		sb.append("12345678".charAt(h));
		return sb.toString();
	}

	public static Move create(int from, int to, PieceType type, PieceType victim, AbstractMove parent) {
		if (victim != null)
			return new Beat(from, to, type, parent, victim);
		return new Move(from, to, type, parent);
	}

	public static Move create(int from, Piece piece, Piece victim, AbstractMove last) {
		return create(from, piece.pos, piece.getType(), victim == null ? null : victim.getType(), last);
	}

	public boolean whiteTurn() {
		return type.weight < 0;
	}

	public boolean canCastle(PieceType castling) {
		if (breakCastle(castling))
			return false;
		return parent.canCastle(castling);
	}

	public boolean breakCastle(PieceType castling) {
		switch (castling) {
		case WHITE_KING:
			return type == PieceType.WHITE_KING || (type == PieceType.WHITE_ROOK && from == 7);
		case WHITE_QUEEN:
			return type == PieceType.WHITE_KING || (type == PieceType.WHITE_ROOK && from == 0);
		case BLACK_KING:
			return type == PieceType.BLACK_KING || (type == PieceType.BLACK_ROOK && from == 63);
		case BLACK_QUEEN:
			return type == PieceType.BLACK_KING || (type == PieceType.BLACK_ROOK && from == 56);
		}
		return true;
	}

	public int totalMoves() {
		int i = parent.totalMoves();
		if (whiteTurn())
			i++;
		return i;
	}

	public int halfMoves() {
		if (type == PieceType.WHITE_PAWN || type == PieceType.BLACK_PAWN)
			return 0;
		return parent.halfMoves() + 1;
	}

	public String getFenEnpassant() {
		return pos2text(getEnpassant());
	}

	public int getEnpassant() {
		if (type == PieceType.WHITE_PAWN && from - to == -16)
			return from + 8;
		if (type == PieceType.BLACK_PAWN && from - to == 16)
			return from - 8;
		return -1;
	}

	@Override
	public Piece getPieces() {
		return apply(parent.getPieces());
	}

	@Override
	public PieceType[] getBoard() {
		PieceType[] board = parent.getBoard();
		apply(board);
		return board;
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
		return new Piece(piece.type, pos, apply(piece.link));
	}

}
