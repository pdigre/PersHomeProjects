package no.pdigre.chess.rules;


public class WhitePawn extends AbstractPawn {

	@Override
	public PieceType getType() {
		return PieceType.WHITE_PAWN;
	}

    @Override
    public void findMoves(IMoves moves, PieceType[] board, int from, int enpassant) {
        forward(moves, board,from, 8);
        beat(moves, board, from,enpassant,8, 7);
        beat(moves, board, from,enpassant,8, 9);
    }

	public boolean isHome(int from) {
		return from > 7 && from < 16;
	}
}
