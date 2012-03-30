package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;

public class WhiteKing extends AbstractKing {

	@Override
	public PieceType getType() {
		return PieceType.WHITE_KING;
	}

	@Override
	public void findMoves(PieceType[] board, List<Integer> moves, Collection<AbstractPiece> pieces, boolean castleKing, boolean castleQueen) {
		boolean right = addKingMove(board, moves, 1, pieces);
		boolean left = addKingMove(board, moves, -1, pieces);
		addKingMove(board, moves, 8, pieces);
		addKingMove(board, moves, -8, pieces);
		addKingMove(board, moves, 7, pieces);
		addKingMove(board, moves, 9, pieces);
		addKingMove(board, moves, -7, pieces);
		addKingMove(board, moves, -9, pieces);
		if (castleKing && right && board[6] == null && board[7] == PieceType.WHITE_ROOK)
			addKingMove(board, moves, 2, pieces);
		if (castleQueen && left && board[2] == null && board[1] == null && board[0] == PieceType.WHITE_ROOK)
			addKingMove(board, moves, -2, pieces);
	}

}
