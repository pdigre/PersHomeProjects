package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;

public class NegaMaxCutoff implements IThinker {

    private IThinker parent;

    public NegaMaxCutoff(IThinker parent) {
        this.parent = parent;
    }

    @Override
    public int think(int[] board, int inherit, int total, int alpha, int beta) {
        total += Bitmap.tacticValue(inherit);
        for (int bitmap : NodeUtil.getAllBestFirst(board, inherit)) {
            int score = -parent.think(Bitmap.apply(board, bitmap), bitmap, -total, -beta, -alpha);
            if (score >= beta)
                return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
    }

    // int alphaBeta( int alpha, int beta, int depthleft ) {
    // if( depthleft == 0 ) return quiesce( alpha, beta );
    // for ( all moves) {
    // score = -alphaBeta( -beta, -alpha, depthleft - 1 );
    // if( score >= beta )
    // return beta; // fail hard beta-cutoff
    // if( score > alpha )
    // alpha = score; // alpha acts like max in MiniMax
    // }
    // return alpha;
    // }
}
