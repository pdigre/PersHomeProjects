package no.pdigre.chess.eval;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodePull;


public class AlphaBeta {
    
    public final static int negamax( int alpha, int beta, int depthleft, int[] board0, int move0, int score0 ) {
        int score1=evaluate(move0, score0);
        if( depthleft == 0 ) return score1;
        for (int move : NodePull.getAllMoves(board0, move0))  {
           int score = -negamax( -beta, -alpha, depthleft - 1,Bitmap.apply(board0, move0),move, score1 );
           if( score >= beta )
              return beta;   //  fail hard beta-cutoff
           if( score > alpha )
              alpha = score; // alpha acts like max in MiniMax
        }
        return alpha;
     }
    
    public final static int alphaBetaMax( int alpha, int beta, int depthleft, int[] board0, int move0, int score0 ) {
        if ( depthleft == 0 ) return evaluate(move0, score0);
        for (int move : NodePull.getAllMoves(board0, move0)) {
           int score = alphaBetaMin( alpha, beta, depthleft - 1,Bitmap.apply(board0, move0),move, score0 );
           if( score >= beta )
              return beta;   // fail hard beta-cutoff
           if( score > alpha )
              alpha = score; // alpha acts like max in MiniMax
        }
        return alpha;
     }
      
    public final static int alphaBetaMin( int alpha, int beta, int depthleft, int[] board0, int move0, int score0  ) {
        if ( depthleft == 0 ) return -evaluate(move0, score0);
        for (int move : NodePull.getAllMoves(board0, move0)) {
           int score = alphaBetaMax( alpha, beta, depthleft - 1,Bitmap.apply(board0, move0),move, score0 );
           if( score <= alpha )
              return alpha; // fail hard alpha-cutoff
           if( score < beta )
              beta = score; // beta acts like min in MiniMax
        }
        return beta;
     }

    private final static int evaluate(int move0, int score0) {
        return score0+Bitmap.value((move0&IConst.CAPTURE)>>>IConst._CAPTURE);
    }
    
    
//    int alphaBetaMax( int alpha, int beta, int depthleft ) {
//        if ( depthleft == 0 ) return evaluate();
//        for ( all moves) {
//           score = alphaBetaMin( alpha, beta, depthleft - 1 );
//           if( score >= beta )
//              return beta;   // fail hard beta-cutoff
//           if( score > alpha )
//              alpha = score; // alpha acts like max in MiniMax
//        }
//        return alpha;
//     }
//      
//     int alphaBetaMin( int alpha, int beta, int depthleft ) {
//        if ( depthleft == 0 ) return -evaluate();
//        for ( all moves) {
//           score = alphaBetaMax( alpha, beta, depthleft - 1 );
//           if( score <= alpha )
//              return alpha; // fail hard alpha-cutoff
//           if( score < beta )
//              beta = score; // beta acts like min in MiniMax
//        }
//        return beta;
//     }    
}
