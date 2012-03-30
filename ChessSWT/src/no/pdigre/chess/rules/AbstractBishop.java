package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;



public abstract class AbstractBishop extends AbstractPiece {

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<AbstractPiece> pieces) {
        repeatMove(board, moves, 7);
        repeatMove(board, moves, 9);
        repeatMove(board, moves, -7);
        repeatMove(board, moves, -9);
    }
}
