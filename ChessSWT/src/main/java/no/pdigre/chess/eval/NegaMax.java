package no.pdigre.chess.eval;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodePull;
import no.pdigre.chess.fen.FEN;

public class NegaMax {

    public final static int negaMax(int depth, int[] board0, int bitmap0) {
        int score = evaluate(bitmap0, board0);
        if (depth == 0)
            return score;
        int board[]=Bitmap.apply(board0, bitmap0);
        int max = 0;
        for (int bitmap : NodePull.getAllMoves(board, bitmap0)) {
            int val = negaMax(depth - 1, board, bitmap);
            if (val > max)
                max = val;
        }
        return score - max;
    }

    public final static int alphaBeta(int alpha, int beta, int depthleft, int[] board0, int move0) {
        int score1 = evaluate(move0, board0);
        if (depthleft == 0)
            return score1;
        for (int move : NodePull.getAllMoves(board0, move0)) {
            int score = -alphaBeta(-beta, -alpha, depthleft - 1, Bitmap.apply(board0, move0), move);
            if (score >= beta)
                return beta; // fail hard beta-cutoff
            if (score > alpha)
                alpha = score; // alpha acts like max in MiniMax
        }
        return alpha;
    }

    public final static int alphaBetaMax(int alpha, int beta, int depthleft, int[] board0, int move0, int score0) {
        if (depthleft == 0)
            return evaluate(move0, board0);
        for (int move : NodePull.getAllMoves(board0, move0)) {
            int score = alphaBetaMin(alpha, beta, depthleft - 1, Bitmap.apply(board0, move0), move, score0);
            if (score >= beta)
                return beta; // fail hard beta-cutoff
            if (score > alpha)
                alpha = score; // alpha acts like max in MiniMax
        }
        return alpha;
    }

    public final static int alphaBetaMin(int alpha, int beta, int depthleft, int[] board, int move, int score0) {
        if (depthleft == 0)
            return -evaluate(move, board);
        for (int bitmap : NodePull.getAllMoves(board, move)) {
            int score = alphaBetaMax(alpha, beta, depthleft - 1, Bitmap.apply(board, bitmap), bitmap, score0);
            if (score <= alpha)
                return alpha; // fail hard alpha-cutoff
            if (score < beta)
                beta = score; // beta acts like min in MiniMax
        }
        return beta;
    }

    private final static int evaluate(int bitmap, int[] board) {
        int value = Bitmap.value((bitmap & IConst.CAPTURE) >>> IConst._CAPTURE);
        if (value > 0)
            System.out.println(value + " " + FEN.printMove(bitmap, board));
        return value;
    }

    // int alphaBetaMax( int alpha, int beta, int depthleft ) {
    // if ( depthleft == 0 ) return evaluate();
    // for ( all moves) {
    // score = alphaBetaMin( alpha, beta, depthleft - 1 );
    // if( score >= beta )
    // return beta; // fail hard beta-cutoff
    // if( score > alpha )
    // alpha = score; // alpha acts like max in MiniMax
    // }
    // return alpha;
    // }
    //
    // int alphaBetaMin( int alpha, int beta, int depthleft ) {
    // if ( depthleft == 0 ) return -evaluate();
    // for ( all moves) {
    // score = alphaBetaMax( alpha, beta, depthleft - 1 );
    // if( score <= alpha )
    // return alpha; // fail hard alpha-cutoff
    // if( score < beta )
    // beta = score; // beta acts like min in MiniMax
    // }
    // return beta;
    // }
}
