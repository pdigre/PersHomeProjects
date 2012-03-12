package no.pdigre.chess.rules;

public class BlackPawn extends AbstractPawn {

	@Override
	public PieceType getType() {
		return PieceType.BLACK_PAWN;
	}

	@Override
	public void findMoves(IMoves moves, PieceType[] board, int from, int enpassant) {
		forward(moves, board, from, -8);
		beat(moves, board, from, enpassant, -8, -7);
		beat(moves, board, from, enpassant, -8, -9);
	}

	public boolean isHome(int from) {
		return from > 47 && from < 56;
	}

}
