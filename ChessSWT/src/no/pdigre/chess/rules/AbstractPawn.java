package no.pdigre.chess.rules;


public abstract class AbstractPawn extends AbstractPiece {

	public abstract void findMoves(IMoves moves, PieceType[] board, int from, int enpassant);

	@Override
	public void findMoves(IMoves moves, PieceType[] board, int from) {
		findMoves(moves, board, from, -1);
	}
	
	public void beat(IMoves moves, PieceType[] board, int from, int enpassant,
			int updown, int leftright) {
		int beat = from + leftright;
		if (onBoard(beat, from)) {
			PieceType piece = board[beat];
			if (piece != null) {
				if (!sameColor(piece))
					moves.addMove(from,beat);
			} else {
				if (enpassant==beat)
					moves.addMove(from,beat);
			}
		}
	}

	public void forward(IMoves moves, PieceType[] board, int from, int mv) {
		int forward = from + mv;
		if (onBoard(forward, from)) {
			if (board[forward] == null) {
				moves.addMove(from,forward);
				if (isHome(from)) {
					int forward2 = from + mv + mv;
					if (onBoard(forward2, from)) {
						if (board[forward2] == null)
							moves.addMove(from,forward2);
					}
				}
			}
		}
	}
	
	public abstract boolean isHome(int from);
}
