package no.pdigre.chess.rules;

public abstract class AbstractPiece implements Cloneable {

	public int from;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return getType().create(from);
	}

	public void findMoves(IMoves moves, PieceType[] board, int from) {
	}

	public void repeatMove(IMoves moves, PieceType[] board, int from, int offset) {
		for (int i = from; addMove(moves, board, i, offset); i += offset);
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
	public boolean addMove(IMoves moves, PieceType[] board, int from, int offset) {
		int i = from + offset;
		if (!onBoard(i, from))
			return false;
		PieceType type2 = board[i];
		if (type2 == null || !sameColor(type2))
			moves.addMove(from, i);
		return type2 == null;
	}

	public boolean sameColor(PieceType type2) {
		return type2.white == getType().white;
	}

	public static boolean onBoard(int i, int from) {
		if (i < 0 || i > 63)
			return false;
		int x1 = i % 8;
		int x2 = from % 8;
		if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
			return false;
		return true;
	}

	public void move(int to) {
		from = to;
	}

	public abstract PieceType getType();

}