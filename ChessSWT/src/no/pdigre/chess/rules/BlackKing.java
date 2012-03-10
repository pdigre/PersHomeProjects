package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;

public class BlackKing extends King {

	@Override
	public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces, boolean castleKing,
			boolean castleQueen) {
		boolean right = addKingMove(board, moves, 1, pieces);
		boolean left = addKingMove(board, moves, -1, pieces);
		addKingMove(board, moves, 8, pieces);
		addKingMove(board, moves, -8, pieces);
		addKingMove(board, moves, 7, pieces);
		addKingMove(board, moves, 9, pieces);
		addKingMove(board, moves, -7, pieces);
		addKingMove(board, moves, -9, pieces);
		if (castleKing && right && board[62] == null && board[63] == PieceType.BlackRook)
			addKingMove(board, moves, 2, pieces);
		if (castleQueen && left && board[58] == null && board[57] == null && board[56] == PieceType.BlackRook)
			addKingMove(board, moves, -2, pieces);
	}
}
