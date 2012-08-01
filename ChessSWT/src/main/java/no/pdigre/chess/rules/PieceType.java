package no.pdigre.chess.rules;

public enum PieceType {
	WHITE_PAWN(100, 'P', 1), WHITE_KNIGHT(300, 'N', 2), WHITE_BISHOP(300, 'B',
			3), WHITE_ROOK(500, 'R', 4), WHITE_QUEEN(900, 'Q', 5), WHITE_KING(
			10000, 'K', 6), BLACK_PAWN(-100, 'p', 9), BLACK_KNIGHT(-300, 'n',
			10), BLACK_BISHOP(-300, 'b', 11), BLACK_ROOK(-500, 'r', 12), BLACK_QUEEN(
			-900, 'q', 13), BLACK_KING(-10000, 'k', 14);

	final public int weight;
	final public char fen;
	final public int bitmap;
	final public static int LEFT = -1;
	final public static int RIGHT = 1;
	final public static int UP = 8;
	final public static int DOWN = -8;
	final public static PieceType[] types = new PieceType[] { null, WHITE_PAWN,
			WHITE_KNIGHT, WHITE_BISHOP, WHITE_ROOK, WHITE_QUEEN, WHITE_KING,
			null, null, BLACK_PAWN, BLACK_KNIGHT, BLACK_BISHOP, BLACK_ROOK,
			BLACK_QUEEN, BLACK_KING, null };

	<T extends Piece> PieceType(int weight, char fen, int bitmap) {
		this.weight = weight;
		this.fen = fen;
		this.bitmap = bitmap;
	}

	final static boolean white(int bitmap) {
		return (bitmap & AbstractMove.ISBLACK) == 0;
	}

	final private static int home(int bitmap) {
		return white(bitmap) ? 0 : 56;
	}

	final static int forward(int bitmap) {
		return white(bitmap) ? 8 : -8;
	}

	final static int pawnline(int bitmap) {
		return white(bitmap) ? 8 : 48;
	}

	final static int goalline(int bitmap) {
		return white(bitmap) ? 56 : 0;
	}

	final public static PieceType getPieceType(char fen) {
		for (PieceType type : PieceType.values()) {
			if (type.fen == fen)
				return type;
		}
		return null;
	}

	final public static void addAll(int bitmap, IMoves moves, int[] board,
			int from) {
		switch (bitmap & 7) {
		case AbstractMove.PAWN:
			int fwd = forward(bitmap);
			pawnForward(moves, board, from, fwd, bitmap);
			int enpassant = moves.getEnpassant();
			pawnBeat(moves, board, from, enpassant, fwd + LEFT, bitmap);
			pawnBeat(moves, board, from, enpassant, fwd + RIGHT, bitmap);
			break;
		case AbstractMove.KNIGHT:
			addSimple(moves, board, BaseMoves.KNIGHT_MOVES[from], bitmap);
			break;
		case AbstractMove.BISHOP:
			addSlider(moves, board, BaseMoves.BISHOP_MOVES[from], bitmap);
			break;
		case AbstractMove.ROOK:
			addSlider(moves, board, BaseMoves.ROOK_MOVES[from], bitmap);
			break;
		case AbstractMove.QUEEN:
			addSlider(moves, board, BaseMoves.QUEEN_MOVES[from], bitmap);
			break;
		case AbstractMove.KING:
			addSimple(moves, board, BaseMoves.KING_MOVES[from], bitmap);
			if(white(bitmap)){
				if ((moves.getState() & EvalMove.NOCASTLE_BLACKQUEEN) == 0)
					castlingQueen(moves, board, from, AbstractMove.BLACK_ROOK,bitmap);
				if ((moves.getState() & EvalMove.NOCASTLE_BLACKKING) == 0)
					castlingKing(moves, board, from, AbstractMove.BLACK_ROOK,bitmap);
			} else {
				if ((moves.getState() & EvalMove.NOCASTLE_WHITEQUEEN) == 0)
					castlingQueen(moves, board, from, AbstractMove.ROOK, bitmap);
				if ((moves.getState() & EvalMove.NOCASTLE_WHITEKING) == 0)
					castlingKing(moves, board, from, AbstractMove.ROOK, bitmap);
			}
			break;
		}
	}

	final private static void addSlider(IMoves imoves, int[] board,
			int[][] moves, int bitmap) {
		for (int[] slide : moves) {
			for (int i = 0; i < slide.length
					&& add(imoves, board, slide[i], bitmap); i++) {
				// not
			}
		}
	}

	final private static void addSimple(IMoves imoves, int[] board,
			int[] moves, int bitmap) {
		for (int to : moves)
			add(imoves, board, to, bitmap);
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
	final private static boolean add(IMoves moves, int[] board, int to,
			int bitmap) {
		int victim = board[to];
		if (victim == 0)
			moves.move(to);
		else if (((victim & AbstractMove.ISBLACK) == 0) != white(bitmap))
			moves.beat(to);
		else
			moves.support(to);
		return victim == 0;
	}

	/**
	 * is it inside the board = legal move
	 * 
	 * @param i
	 * @param from
	 * @return
	 */
	final private static boolean inside(int i, int from) {
		if (i < 0 || i > 63)
			return false;
		int x1 = i % 8;
		int x2 = from % 8;
		if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
			return false;
		return true;
	}

	final private static void pawnBeat(IMoves moves, int[] board, int from,
			int enpassant, int leftright, int bitmap) {
		int to = from + leftright;
		if (inside(to, from)) {
			int piece = board[to];
			if (piece != 0) {
				if (((piece & AbstractMove.ISBLACK) == 0) == white(bitmap))
					moves.support(to);
				else if (to >= goalline(bitmap) && to < goalline(bitmap) + 8)
					moves.beatTrade(to);
				else
					moves.beat(to);
			} else {
				if (enpassant == to)
					moves.enpassant(to);
			}
		}
	}

	final private static void pawnForward(IMoves moves, int[] board, int from,
			int mv, int bitmap) {
		int to1 = from + mv;
		if (inside(to1, from)) {
			if (board[to1] == 0) {
				if (to1 >= goalline(bitmap) && to1 < goalline(bitmap) + 8)
					moves.moveTrade(to1);
				else
					moves.move(to1);
				if (from >= pawnline(bitmap) && from < pawnline(bitmap) + 8) {
					int to2 = from + mv + mv;
					if (inside(to2, from)) {
						if (board[to2] == 0)
							moves.move(to2);
					}
				}
			}
		}
	}

	final private static void castlingKing(IMoves moves, int[] board, int from,
			int rook, int bitmap) {
		if (board[home(bitmap) + 5] == 0 && board[home(bitmap) + 6] == 0
				&& board[home(bitmap) + 7] == rook) {
			if (checkSafe(home(bitmap) + 4) && checkSafe(home(bitmap) + 5))
				add(moves, board, from, 2);
		}
	}

	final private static void castlingQueen(final IMoves moves,
			final int[] board, int from, int rook, int bitmap) {
		if (board[home(bitmap) + 3] == 0 && board[home(bitmap) + 2] == 0
				&& board[home(bitmap) + 1] == 0
				&& board[home(bitmap) + 0] == rook) {
			if (checkSafe(home(bitmap) + 3) && checkSafe(home(bitmap) + 4))
				add(moves, board, from, -2);
		}
	}

	final public static boolean checkSafe(int i) {
		return true;
	}

}