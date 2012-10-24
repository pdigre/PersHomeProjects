package no.pdigre.chess.swt;

import no.pdigre.chess.engine.eval.AlphaBeta;


public class JustMoves extends AlphaBeta {

    public JustMoves(int[] board, int inherit) {
        super(board, inherit, 0);
    }

}
