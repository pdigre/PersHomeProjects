package no.pdigre.chess.rules;

import static no.pdigre.chess.rules.IMoves.*;

public abstract class AbstractBishop extends AbstractPiece {

    @Override
    public void findMoves(IMoves moves, PieceType[] board, int from) {
        repeatMove(moves, board, from, UP+LEFT);
        repeatMove(moves, board, from, UP+RIGHT);
        repeatMove(moves, board, from, DOWN+LEFT);
        repeatMove(moves, board, from, DOWN+RIGHT);
    }
}
