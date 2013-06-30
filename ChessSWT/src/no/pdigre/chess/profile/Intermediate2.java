package no.pdigre.chess.profile;

import java.util.HashSet;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.Evaluator;
import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.eval.NegaMax;
import no.pdigre.chess.engine.eval.NegaMaxCutoff;
import no.pdigre.chess.engine.eval.NegaMaxEnd;
import no.pdigre.chess.engine.eval.NegaMaxTransposition;

public class Intermediate2 extends Player {

    @Override
    public void run() {
		checkPolyglot();
		if (bitmaps.length > 0) {
			makeMove(bitmaps[0]);
			return;
		}
        IThinker first = new NegaMaxCutoff(new NegaMaxEnd());
        HashSet<Long> tt=new HashSet<Long>();
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(first,tt);
        IThinker second = new NegaMax(nm);
        int[] board = getBoard();
        int bitmap = getBitmap();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        Evaluator[] evals = new Evaluator[moves.length];
        for (int i = 0; i < moves.length; i++)
            evals[i] = new Evaluator(board, moves[i]);
        for (Evaluator eval : evals)
            eval.sync(second);
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
        nm.printHitrate();
        
        makeMove(evals[0].getBitmap());
    }


}
