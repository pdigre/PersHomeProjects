package no.pdigre.chess.rules;

public class WhiteKing extends AbstractKing {

	@Override
	public PieceType getType() {
		return PieceType.WHITE_KING;
	}

	@Override
	public void findMoves(IMoves moves, PieceType[] board, int from, boolean castleKing, boolean castleQueen) {
		boolean right = addMove(moves, board, from, 1);
		boolean left = addMove(moves, board, from, -1);
		addMove(moves, board, from, 8);
		addMove(moves, board, from, -8);
		addMove(moves, board, from, 7);
		addMove(moves, board, from, 9);
		addMove(moves, board, from, -7);
		addMove(moves, board, from, -9);
		if (castleKing && right && board[6] == null && board[7] == PieceType.WHITE_ROOK)
			addMove(moves, board, from, 2);
		if (castleQueen && left && board[2] == null && board[1] == null && board[0] == PieceType.WHITE_ROOK)
			addMove(moves, board, from, -2);
	}

}
