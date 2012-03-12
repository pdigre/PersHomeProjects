package no.pdigre.chess.rules;



public abstract class AbstractRook extends AbstractPiece { 

    @Override
    public void findMoves(IMoves moves, PieceType[] board, int from) {
        repeatMove(moves, board, from, 8);
        repeatMove(moves, board, from, 1);
        repeatMove(moves, board, from, -1);
        repeatMove(moves, board, from, -8);
    }
}
