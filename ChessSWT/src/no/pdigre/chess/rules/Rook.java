package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public class Rook extends Piece { 

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces) {
        repeatMove(board, moves, 8);
        repeatMove(board, moves, 1);
        repeatMove(board, moves, -1);
        repeatMove(board, moves, -8);
    }
}
