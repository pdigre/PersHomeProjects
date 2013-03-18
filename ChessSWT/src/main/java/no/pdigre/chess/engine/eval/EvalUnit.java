package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;


public class EvalUnit{

    private final EvalBase[] evals;
    private NegaMaxTransposition tt;

    public EvalUnit(final int[] board, final int bitmap) {
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        evals = new EvalBase[moves.length];
        for (int i = 0; i < moves.length; i++){
            evals[i] = new EvalBase(Bitmap.apply(board, moves[i]), moves[i]);
        }
    }
    
    public void calculateStrategic(){
        //
    }
    
    public void firstPass(){
        IThinker tail = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd()));
        tt = new NegaMaxTransposition(tail);
        NegaMax series = new NegaMax(tt);
        for (EvalBase eval : evals)
            eval.firstPass(series);
        EvalBase.sort(evals);
    }

    public void printScore() {
        tt.printHitrate();
        for (EvalBase eval : evals)
            System.out.println(eval.toString());
    }
    

}
