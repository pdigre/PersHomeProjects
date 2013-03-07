package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;

public class NegaMaxEnd implements IThinker {

    public NegaMaxEnd() {
    }

    @Override
    public int think(int[] board, int inherit, int total, int alpha, int beta) {
        return total+ Bitmap.tacticValue(inherit);
    }
}
