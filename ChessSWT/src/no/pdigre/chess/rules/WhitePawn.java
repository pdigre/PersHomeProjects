package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;


public class WhitePawn extends Pawn {

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, int enpassant, Collection<Piece> pieces) {
        forward(board, moves,8);
        beat(board, moves, enpassant,8,7);
        beat(board, moves, enpassant,8,9);
    }

	public boolean isHome() {
		return pos > 7 && pos < 16;
	}
}
