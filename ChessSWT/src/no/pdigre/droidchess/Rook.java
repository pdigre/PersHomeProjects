package no.pdigre.droidchess;

import java.util.Collection;
import java.util.List;


public class Rook extends Piece {

    Rook(int pos, PieceType type) {
        super(pos, type);
    }

    @Override
    public void findMoves(PieceType[] board, List<int[]> moves, Move last, Collection<Piece> pieces) {
        repeatMove(board, moves, 8);
        repeatMove(board, moves, 1);
        repeatMove(board, moves, -1);
        repeatMove(board, moves, -8);
    }
}