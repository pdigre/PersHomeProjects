package no.pdigre.chess.rules;



public abstract class AbstractQueen extends AbstractPiece { 

    @Override
    public void findMoves(IMoves moves, PieceType[] board, int from) {
        repeatMove(moves, board, from, 8);
        repeatMove(moves, board, from, 1);
        repeatMove(moves, board, from, -1);
        repeatMove(moves, board, from, -8);
        repeatMove(moves, board, from, 7);
        repeatMove(moves, board, from, 9);
        repeatMove(moves, board, from, -7);
        repeatMove(moves, board, from, -9);
    }
}
