package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;


public class JustMoves extends AlphaBeta {

    public JustMoves(int[] board, int inherit) {
        super(board, inherit, 0);
    }

}