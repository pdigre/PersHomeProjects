package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;

public abstract class AbstractKnight extends AbstractPiece {

    @Override
    public void findMoves(PieceType[] board, List<Integer> moves, Collection<AbstractPiece> pieces) {
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
