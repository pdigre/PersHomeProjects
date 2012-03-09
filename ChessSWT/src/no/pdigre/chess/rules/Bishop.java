package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public class Bishop extends Piece {

    public Bishop(int pos, PieceType type) {
        super(pos, type);
    }

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Move last, Collection<Piece> pieces) {
        repeatMove(board, moves, 7);
        repeatMove(board, moves, 9);
        repeatMove(board, moves, -7);
        repeatMove(board, moves, -9);
    }
}
