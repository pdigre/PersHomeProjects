package no.pdigre.chess.rules;

public class Move extends AbstractMove {

	public final static int PIECETYPE = 7 << 0;
	public final static int ISBLACK = 1 << 3;
	public final static int PIECE = 15 << 0;
	public final static int CAPTURE = 7 << 4;
	public final static int PROMOTE = 7 << 7;
	public final static int ENPASSANT = 1 << 10;
	public final static int CASTLING = 1 << 11;
	public final static int FROM = 63 << 12;
	public final static int CURRENT = 63 << 12;
	public final static int TO = 63 << 18;

	// piecetype
	public final static int NONE = 0;
	public final static int PAWN = 1;
	public final static int KNIGHT = 2;
	public final static int BISHOP = 3;
	public final static int ROOK = 4;
	public final static int QUEEN = 5;
	public final static int KING = 6;

	private final AbstractMove parent;
	public int bitmap;

	public Move(final int from, final int to, final int type,
			final AbstractMove parent) {
		super();
		this.bitmap = type | (from << 12) | (to << 18);
		this.parent = parent;
	}

	public void apply(int[] board) {
		board[getFrom()] = 0;
		board[getTo()] = bitmap & PIECE;
	}

	public Piece apply(Piece piece) {
		if (piece == null)
			return null;
		int pos = piece.pos;
		if (pos == getFrom())
			pos = getTo();
		return new Piece(piece.type, pos, apply(piece.link));
	}

	@Override
	public String toString() {
		return PieceType.types[bitmap & PIECE] + " from "
				+ pos2string(getFrom()) + " to " + pos2string(getTo());
	}

	final public static String pos2string(int pos) {
		int h = pos % 8;
		StringBuilder sb = new StringBuilder();
		sb.append("abcdefgh".charAt((pos - h) / 8));
		sb.append("12345678".charAt(h));
		return sb.toString();
	}

	@Override
	final public boolean whiteTurn() {
		return (bitmap & ISBLACK) != 0;
	}

	final public int breakCastle(int state) {
		switch (bitmap & PIECE) {
		case KING:
			return state | EvalMove.NOCASTLE_WHITEKING
					| EvalMove.NOCASTLE_WHITEQUEEN;
		case ROOK:
			switch (getFrom()) {
			case 0:
				return state | EvalMove.NOCASTLE_WHITEQUEEN;
			case 7:
				return state | EvalMove.NOCASTLE_WHITEKING;
			default:
				return state;
			}
		case KING | ISBLACK:
			return state | EvalMove.NOCASTLE_BLACKKING
					| EvalMove.NOCASTLE_BLACKQUEEN;
		case ROOK | ISBLACK:
			switch (getFrom()) {
			case 56:
				return state | EvalMove.NOCASTLE_BLACKQUEEN;
			case 63:
				return state | EvalMove.NOCASTLE_BLACKKING;
			default:
				return state;
			}
		default:
			return state;
		}
	}

	@Override
	final public int totalMoves() {
		int i = parent.totalMoves();
		if (whiteTurn())
			i++;
		return i;
	}

	@Override
	public int halfMoves() {
		if ((bitmap & PIECETYPE) == PAWN)
			return 0;
		return parent.halfMoves() + 1;
	}

	@Override
	final public int getEnpassant() {
		switch (bitmap & PIECE) {
		case PAWN:
			if (getFrom() - getTo() == -16)
				return getFrom() + 8;
			return -1;
		case PAWN | ISBLACK:
			if (getFrom() - getTo() == 16)
				return getFrom() - 8;
			return -1;
		default:
			return -1;
		}
	}

	@Override
	final public Piece getPieces() {
		return apply(parent.getPieces());
	}

	@Override
	public int[] getArray() {
		return applyArray(parent.getArray());
	}

	public int[] applyArray(int[] array) {
		final int current = bitmap & CURRENT;
		for (int i = 0; i < array.length; i++) {
			int pos = array[i];
			if ((pos & CURRENT) == current) {
				array[i] = (pos | ~CURRENT) | ((bitmap >> 6) & CURRENT);
			}
		}
		return null;
	}

	@Override
	final public int[] getBoard() {
		int[] board = parent.getBoard();
		apply(board);
		return board;
	}

	@Override
	final public int getState() {
		return breakCastle(parent.getState());
	}

	final public int getBType() {
		return bitmap & PIECE;
	}

	final public int getFrom() {
		return (bitmap >> 12) & 63;
	}

	final public int getTo() {
		return (bitmap >> 18) & 63;
	}

	final public static boolean isBlack(final int type) {
		return (type & ISBLACK) != 0;
	}

}
