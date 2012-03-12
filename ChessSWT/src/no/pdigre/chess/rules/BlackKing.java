package no.pdigre.chess.rules;

public class BlackKing extends AbstractKing {

	@Override
	public PieceType getType() {
		return PieceType.BLACK_KING;
	}

	@Override
	public void findMoves(IMoves moves, PieceType[] board, int from, boolean castleKing,
			boolean castleQueen) {
		boolean right = addMove(moves, board, from, 1);
		boolean left = addMove(moves, board, from, -1);
		addMove(moves, board, from, 8);
		addMove(moves, board, from, -8);
		addMove(moves, board, from, 7);
		addMove(moves, board, from, 9);
		addMove(moves, board, from, -7);
		addMove(moves, board, from, -9);
		if (castleKing && right && board[62] == null && board[63] == PieceType.BLACK_ROOK)
			addMove(moves, board, from, 2);
		if (castleQueen && left && board[58] == null && board[57] == null && board[56] == PieceType.BLACK_ROOK)
			addMove(moves, board, from, -2);
	}
}
