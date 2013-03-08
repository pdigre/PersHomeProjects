package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;

public class NegaMax implements IThinker {

    private IThinker parent;

    public NegaMax(IThinker parent) {
        this.parent = parent;
    }

    @Override
    public int think(int[] board, int inherit, int total, int alpha, int beta) {
        total += Bitmap.tacticValue(inherit);
        int max = alpha;
        for (int bitmap : NodeUtil.getAllBestFirst(board, inherit)) {
            int score = -parent.think(Bitmap.apply(board, bitmap), bitmap, -total, -beta, -alpha);
            if (score > max)
                max = score;
        }
        return max;
    }
}
