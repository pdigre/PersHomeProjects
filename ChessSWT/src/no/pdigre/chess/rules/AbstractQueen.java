package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public abstract class AbstractQueen extends AbstractPiece { 

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<AbstractPiece> pieces) {
        repeatMove(board, moves, 8);
        repeatMove(board, moves, 1);
        repeatMove(board, moves, -1);
        repeatMove(board, moves, -8);
        repeatMove(board, moves, 7);
        repeatMove(board, moves, 9);
        repeatMove(board, moves, -7);
        repeatMove(board, moves, -9);
    }
}
