package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public class Bishop extends Piece {

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces) {
        repeatMove(board, moves, 7);
        repeatMove(board, moves, 9);
        repeatMove(board, moves, -7);
        repeatMove(board, moves, -9);
    }
}
