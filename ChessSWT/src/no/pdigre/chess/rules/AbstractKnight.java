package no.pdigre.chess.rules;

public abstract class AbstractKnight extends AbstractPiece {

    @Override
    public void findMoves(IMoves moves, PieceType[] board, int from) {
        addMove(moves, board, from, 6);
        addMove(moves, board, from, 10);
        addMove(moves, board, from, 15);
        addMove(moves, board, from, 17);
        addMove(moves, board, from, -6);
        addMove(moves, board, from, -10);
        addMove(moves, board, from, -15);
        addMove(moves, board, from, -17);
    }
}
