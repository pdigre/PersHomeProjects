package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class WhiteKing extends King {

	public boolean castling = true;

	@Override
	public void move(int to) {
		super.move(to);
		castling = false;
	}
 
	@Override
	public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces, boolean castleKing, boolean castleQueen) {
		boolean right = addKingMove(board, moves, 1, pieces);
		boolean left = addKingMove(board, moves, -1, pieces);
		addKingMove(board, moves, 8, pieces);
		addKingMove(board, moves, -8, pieces);
		addKingMove(board, moves, 7, pieces);
		addKingMove(board, moves, 9, pieces);
		addKingMove(board, moves, -7, pieces);
		addKingMove(board, moves, -9, pieces);
		if (castleKing && right && board[6] == null && board[7] == PieceType.WhiteRook)
			addKingMove(board, moves, 2, pieces);
		if (castleQueen && left && board[2] == null && board[1] == null && board[0] == PieceType.WhiteRook)
			addKingMove(board, moves, -2, pieces);
	}

}
