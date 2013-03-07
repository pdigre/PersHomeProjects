package no.pdigre.chess.test.engine;

import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.eval.IThinker;
import no.pdigre.chess.engine.fen.FEN;

public class Evaluator {

    public static ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    final private int[] board;

    final private int bitmap;

    final StringBuilder sb = new StringBuilder();

    private ThinkTask task;

    private Integer score;

    public Evaluator(int[] board, int bitmap) {
        this.board = board;
        this.bitmap = bitmap;
    }

    public void think(IThinker thinker) {
        task = new ThinkTask(thinker, board, bitmap);
        pool.execute(task);
    }

    public void join() {
        if (task != null) {
            if (sb.length() > 0)
                sb.append(",");
            score = task.join();
            sb.append(score);
            task = null;
        }
    }

    @Override
    public String toString() {
        return FEN.printMove(bitmap, board) + " (" + sb.toString() + ")";
    }
    
    public static Evaluator[] sort(Evaluator[] all) {
        if(all.length<2)
            return all;
        int cutoff = -9000;
        int next = 0;
        int p2 = all.length - 1;
        Evaluator b2 = all[p2];
        int v2 = b2.score;
        while (next > cutoff) {
            int p1 = 0;
            Evaluator b1 = all[p1];
            int v1 = b1.score;
            cutoff=next;
            next = 9000;
            while (p1 < p2) {
                if (v1 > cutoff) {
                    if (next > v1)
                        next = v1;
                    p1++;
                    b1 = all[p1];
                    v1 = b1.score;
                    continue;
                }
                if (v2 <= cutoff) {
                    p2--;
                    b2 = all[p2];
                    v2 = b2.score;
                    continue;
                }
                {
                    // Swap
                    all[p1] = b2;
                    all[p2] = b1;
                    Evaluator t1 = b1;
                    b1 = b2;
                    b2 = t1;
                    int t2 = v1;
                    v1 = v2;
                    v2 = t2;
                }
            }
        }
        return all;
    }

}
