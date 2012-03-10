package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class King extends Piece {

	public boolean addKingMove(PieceType[] board, List<Integer> moves, int offset, Collection<Piece> pieces) {
		int i = pos + offset;
		if (!onBoard(i, pos))
			return false;
		PieceType type2 = board[i];
		if (type2 != null) {
			if (!sameColor(type2) && checkKing(board, pieces, i))
				moves.add(i);
			return false;
		}
		if (checkKing(board, pieces, i)) {
			moves.add(i);
			return true;
		}
		return false;
	}

	public boolean checkKing(PieceType[] board, Collection<Piece> pieces, int i) {
		for (Piece piece : pieces) {
			if (!sameColor(piece.type) && piece.type != PieceType.BlackKing && piece.type != PieceType.WhiteKing) {
				ArrayList<Integer> other = new ArrayList<Integer>();
				piece.findMoves(board, other, pieces);
				for (int move : other) {
					if (move == i)
						return false;
				}
			}
		}
		return true;
	}

	public abstract void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces, boolean castleKing, boolean castleQueen);

}
