package no.pdigre.chess.rules;

public enum PieceType {
	WHITE_PAWN(100, 'P'),
	WHITE_KNIGHT(300, 'N'),
	WHITE_BISHOP(300, 'B'),
	WHITE_ROOK(500, 'R'),
	WHITE_QUEEN(900, 'Q'),
	WHITE_KING(10000, 'K'),
	BLACK_PAWN(-100, 'p'),
	BLACK_KNIGHT(-300, 'n'),
	BLACK_BISHOP(-300, 'b'),
	BLACK_ROOK(-500, 'r'),
	BLACK_QUEEN(-900, 'q'),
	BLACK_KING(-10000, 'k');

	final public int weight;
	final public char fen;
	final public boolean white;
	final public int home;
	final public int forward;
	final public int pawnline;
	final public int goalline;
	final public static int LEFT = -1;
	final public static int RIGHT = 1;
	final public static int UP = 8;
	final public static int DOWN = -8;

	<T extends Piece> PieceType(int weight, char fen) {
		this.weight = weight;
		this.fen = fen;
		this.white = weight > 0;
		this.home = weight > 0 ? 0 : 56;
		this.forward = weight > 0 ? 8 : -8;
		this.pawnline = weight > 0 ? 8 : 48;
		this.goalline = weight > 0 ? 56 : 0;
	}

	public static PieceType getPieceType(char fen) {
		for (PieceType type : PieceType.values()) {
			if (type.fen == fen)
				return type;
		}
		return null;
	}

	public boolean white() {
		return white;
	}

	public void addAll(IMoves moves, PieceType[] board, int from) {
		switch (this) {
		case BLACK_PAWN:
		case WHITE_PAWN: {
			pawnForward(moves, board, from, forward);
			int enpassant = moves.getEnpassant();
			pawnBeat(moves, board, from, enpassant, forward, forward + LEFT);
			pawnBeat(moves, board, from, enpassant, forward, forward + RIGHT);
		}
			break;
		case BLACK_KNIGHT:
		case WHITE_KNIGHT: {
			add(moves, board, from, UP + LEFT + LEFT);
			add(moves, board, from, UP + UP + LEFT);
			add(moves, board, from, UP + RIGHT + RIGHT);
			add(moves, board, from, UP + UP + RIGHT);
			add(moves, board, from, DOWN + LEFT + LEFT);
			add(moves, board, from, DOWN + DOWN + LEFT);
			add(moves, board, from, DOWN + RIGHT + RIGHT);
			add(moves, board, from, DOWN + DOWN + RIGHT);
		}
			break;
		case BLACK_BISHOP:
		case WHITE_BISHOP: {
			slide(moves, board, from, UP + LEFT);
			slide(moves, board, from, UP + RIGHT);
			slide(moves, board, from, DOWN + LEFT);
			slide(moves, board, from, DOWN + RIGHT);
		}
			break;
		case BLACK_ROOK:
		case WHITE_ROOK: {
			slide(moves, board, from, UP);
			slide(moves, board, from, DOWN);
			slide(moves, board, from, LEFT);
			slide(moves, board, from, RIGHT);
		}
			break;
		case BLACK_QUEEN:
		case WHITE_QUEEN: {
			slide(moves, board, from, UP);
			slide(moves, board, from, DOWN);
			slide(moves, board, from, LEFT);
			slide(moves, board, from, RIGHT);
			slide(moves, board, from, UP + LEFT);
			slide(moves, board, from, UP + RIGHT);
			slide(moves, board, from, DOWN + LEFT);
			slide(moves, board, from, DOWN + RIGHT);
		}
			break;
		case BLACK_KING:
			add(moves, board, from, UP);
			add(moves, board, from, DOWN);
			add(moves, board, from, UP + LEFT);
			add(moves, board, from, UP + RIGHT);
			add(moves, board, from, DOWN + LEFT);
			add(moves, board, from, DOWN + RIGHT);
			if (add(moves, board, from, RIGHT) && moves.getCastling(BLACK_QUEEN))
				castlingQueen(moves, board, from, BLACK_ROOK);
			if (add(moves, board, from, LEFT) && moves.getCastling(BLACK_KING))
				castlingKing(moves, board, from, BLACK_ROOK);
		case WHITE_KING: {
			add(moves, board, from, UP);
			add(moves, board, from, DOWN);
			add(moves, board, from, UP + LEFT);
			add(moves, board, from, UP + RIGHT);
			add(moves, board, from, DOWN + LEFT);
			add(moves, board, from, DOWN + RIGHT);
			if (add(moves, board, from, RIGHT) && moves.getCastling(WHITE_QUEEN))
				castlingQueen(moves, board, from, WHITE_ROOK);
			if (add(moves, board, from, LEFT) && moves.getCastling(WHITE_KING))
				castlingKing(moves, board, from, WHITE_ROOK);
		}
			break;

		}
	}

	/**
	 * Repeated moves like rook and queen
	 * 
	 * @param moves
	 * @param board
	 * @param from
	 * @param offset
	 */
	private void slide(IMoves moves, PieceType[] board, int from, int offset) {
		for (int i = from; add(moves, board, i, offset); i += offset)
			;
	}

	/**
	 * Calculate is move is within borders return true if can continue like
	 * queen
	 * 
	 * @param moves
	 * @param offset
	 * @param pieces
	 * 
	 * @return
	 */
	private boolean add(IMoves moves, PieceType[] board, int from, int offset) {
		int i = from + offset;
		if (!inside(i, from))
			return false;
		PieceType victim = board[i];
		if (victim == null)
			moves.move(i);
		else if (victim.white != white)
			moves.beat(i);
		else
			moves.support(i);
		return victim == null;
	}

	/**
	 * is it inside the board = legal move
	 * 
	 * @param i
	 * @param from
	 * @return
	 */
	private boolean inside(int i, int from) {
		if (i < 0 || i > 63)
			return false;
		int x1 = i % 8;
		int x2 = from % 8;
		if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
			return false;
		return true;
	}

	private void pawnBeat(IMoves moves, PieceType[] board, int from, int enpassant, int updown, int leftright) {
		int to = from + leftright;
		if (inside(to, from)) {
			PieceType piece = board[to];
			if (piece != null) {
				if (piece.white == white)
					moves.support(to);
				else if (to >= goalline && to < goalline + 8)
					moves.beatTrade(to);
				else
					moves.beat(to);
			} else {
				if (enpassant == to)
					moves.enpassant(to);
			}
		}
	}

	private void pawnForward(IMoves moves, PieceType[] board, int from, int mv) {
		int to1 = from + mv;
		if (inside(to1, from)) {
			if (board[to1] == null) {
				if (to1 >= goalline && to1 < goalline + 8)
					moves.moveTrade(to1);
				else
					moves.move(to1);
				if (from >= pawnline && from < pawnline + 8) {
					int to2 = from + mv + mv;
					if (inside(to2, from)) {
						if (board[to2] == null)
							moves.move(to2);
					}
				}
			}
		}
	}

	private void castlingKing(IMoves moves, PieceType[] board, int from, PieceType rook) {
		if (board[home + 6] == null && board[home + 7] == rook)
			add(moves, board, from, 2);
	}

	private void castlingQueen(final IMoves moves, final PieceType[] board, int from, PieceType rook) {
		if (board[home + 2] == null && board[home + 1] == null && board[home + 0] == rook)
			add(moves, board, from, -2);
	}

}