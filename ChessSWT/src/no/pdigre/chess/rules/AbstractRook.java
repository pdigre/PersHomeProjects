package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public abstract class AbstractRook extends AbstractPiece { 

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<AbstractPiece> pieces) {
        repeatMove(board, moves, 8);
        repeatMove(board, moves, 1);
        repeatMove(board, moves, -1);
        repeatMove(board, moves, -8);
    }
}
