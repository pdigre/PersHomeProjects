package no.pdigre.chess.engine.eval;

import java.util.Arrays;
import java.util.Comparator;

import no.pdigre.chess.engine.fen.FEN;

public class EvalBase implements IThinker {

    final private int[] board;

    final private int bitmap;

    final StringBuilder sb = new StringBuilder();

    public Integer score;

    public int pass;

    @Override
    public String toString() {
        return FEN.printMove(bitmap, board) + " (" + sb.toString() + ")";
    }

    public EvalBase(int[] board, int bitmap) {
        this.board = board;
        this.bitmap = bitmap;
    }

    @Override
    public int think(int[] board, int inherit, int total, int alpha, int beta) {
        return 0;
    }

    @Override
    public int getBitmap() {
        return bitmap;
    }

    @Override
    public IThinker getParent() {
        return null;
    }

    @Override
    public void setParent(IThinker prev) {
        //;
    }

    public void run(NegaMax thinker) {
        score = thinker.think(board, bitmap, 0, IThinker.MIN, IThinker.MAX);
        if(sb.length()>0)
            sb.append(",");
        sb.append(score);
    }
    
    public static EvalBase[] sort(EvalBase[] all) {
        Arrays.sort(all, new Comparator<EvalBase>(){

            @Override
            public int compare(EvalBase e1, EvalBase e2) {
                return e2.score > e1.score?1:e1.score==e2.score?0:-1;
            }
            
        });
        return all;
    }

}
