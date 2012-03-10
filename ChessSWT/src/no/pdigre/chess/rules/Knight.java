package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public class Knight extends Piece {

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces) {
        addMove(board, moves, 6);
        addMove(board, moves, 10);
        addMove(board, moves, 15);
        addMove(board, moves, 17);
        addMove(board, moves, -6);
        addMove(board, moves, -10);
        addMove(board, moves, -15);
        addMove(board, moves, -17);
    }
}
