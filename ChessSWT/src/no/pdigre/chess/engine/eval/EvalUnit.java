package no.pdigre.chess.engine.eval;

import java.util.HashSet;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;


public class EvalUnit{

    private final EvalBase[] evals;
    private HashSet<Long> tt = new HashSet<Long>();

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
    
    public void runFirstPass(){
        IThinker tail = new NegaMaxCutoff(new NegaMaxEnd());
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(tail,tt);
        NegaMax series = new NegaMax(nm);
        for (EvalBase eval : evals){
            eval.pass=1;
            eval.run(series);
        }
        EvalBase.sort(evals);
    }

    public void runSecondPass(int cut){
        IThinker tail = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd()));
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt);
        NegaMax series = new NegaMax(nm);
        int part=evals.length*cut/100;
        for (EvalBase eval : evals){
            eval.pass=2;
            eval.run(series);
            if(part--==0)
                break;
        }
        EvalBase.sort(evals);
    }

    public void runSplit(int cut){
        IThinker tail = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd()));
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt);
        NegaMax series = new NegaMax(nm);
        int part=evals.length*cut/100;
        for (EvalBase eval : evals){
            eval.pass=3;
            eval.run(series);
            if(part--==0)
                break;
        }
        EvalBase.sort(evals);
        nm.printHitrate();
    }

    public void printScore() {
        for (EvalBase eval : evals)
            System.out.println(eval.toString());
    }
    

}
