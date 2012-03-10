package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;

public abstract class Pawn extends Piece {

	public abstract void findMoves(PieceType[] board, List<Integer> moves, int enpassant, Collection<Piece> pieces);

	@Override
	public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces) {
		findMoves(board, moves, -1,pieces);
	}
	
	public void beat(PieceType[] board, List<Integer> moves, int enpassant, int fw,
			int mv) {
		int beat = pos + mv;
		if (onBoard(beat)) {
			PieceType piece = board[beat];
			if (piece != null) {
				if (!sameColor(piece))
					moves.add(beat);
			} else {
				if (enpassant==beat)
					moves.add(beat);
			}
		}
	}

	public void forward(PieceType[] board, List<Integer> moves, int mv) {
		int forward = pos + mv;
		if (onBoard(forward)) {
			if (board[forward] == null) {
				moves.add(forward);
				if (isHome()) {
					int forward2 = pos + mv + mv;
					if (onBoard(forward2)) {
						if (board[forward2] == null)
							moves.add(forward2);
					}
				}
			}
		}
	}
	
	public abstract boolean isHome();
}
