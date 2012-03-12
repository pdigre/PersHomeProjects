package no.pdigre.chess.rules;

public abstract class AbstractKing extends AbstractPiece {

	public abstract void findMoves(IMoves moves, PieceType[] board, int from,
			boolean castleKing, boolean castleQueen);

}
