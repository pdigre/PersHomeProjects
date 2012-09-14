package no.pdigre.chess.eval;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodeGen;

public class AlphaBeta {

    public final static int alphaBeta(int depthleft, int[] board0, int bitmap0) {
        if (Bitmap.white(bitmap0))
            return blackMove(-1000000, +1000000, depthleft, board0, bitmap0, 0);
        return whiteMove(-1000000, +1000000, depthleft, board0, bitmap0, 0);
    }

    public final static int whiteMove(int whiteBest, int blackBest, int depthleft, int[] board0, int bitmap0,
        int score0) {
        int score1 = evalWhite(bitmap0, board0, score0);
        if (depthleft == 0)
            return score1;
        int[] board = Bitmap.apply(board0, bitmap0);
        NodeGen pull = new NodeGen(board, bitmap0);
        while(true){
            int bitmap = pull.nextUnsafe();
            if(bitmap==0)
                break;
            int score = blackMove(whiteBest, blackBest, depthleft - 1, board, bitmap, score1);
            if (score >= blackBest)
                return blackBest; // fail hard beta-cutoff
            if (score > whiteBest)
                whiteBest = score; // alpha acts like max in MiniMax
        }
        return whiteBest;
    }

    public final static int blackMove(int whiteBest, int blackBest, int depthleft, int[] board0, int bitmap0,
        int score0) {
        int score1 = evalBlack(bitmap0, board0, score0);
        if (depthleft == 0)
            return score1;
        int[] board = Bitmap.apply(board0, bitmap0);
        NodeGen pull = new NodeGen(board, bitmap0);
        while(true){
            int bitmap = pull.nextUnsafe();
            if(bitmap==0)
                break;
            int score = whiteMove(whiteBest, blackBest, depthleft - 1, board, bitmap, score1);
            if (score <= whiteBest)
                return whiteBest; // fail hard alpha-cutoff
            if (score < blackBest)
                blackBest = score; // beta acts like min in MiniMax
        }
        return blackBest;
    }

    /**
     * @param board  
     */
    public final static int evalWhite(int bitmap, int[] board, int score) {
        return score - capturedValue(bitmap);
    }

    /**
     * @param board  
     */
    public final static int evalBlack(int bitmap, int[] board, int score) {
        return score + capturedValue(bitmap);
    }

    public final static int capturedValue(int bitmap) {
        return Bitmap.value((bitmap & IConst.CAPTURE) >>> IConst._CAPTURE);
    }

}
