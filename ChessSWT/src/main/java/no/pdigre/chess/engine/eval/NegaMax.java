package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;

public class NegaMax implements IThinker{

    @Override
    public int run(int[] board, int inherit, int depth) {
        return negaMax(board, inherit, depth,0);
    }
    
    public int negaMax(int[] board, int inherit, int depth,int total) {
        total+=Bitmap.tacticValue(inherit);
        if (depth == 0)
            return total;
        int max = -9999;
        for (int bitmap : NodeUtil.getAllBestFirst(board, inherit)) {
            int score = -negaMax(Bitmap.apply(board, bitmap), bitmap, depth - 1,-total);
            if (score > max)
                max = score;
        }
        return max;
    }
}
