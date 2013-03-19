package no.pdigre.chess.test.engine;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;

public class CountMoveParallel extends CountMove {

    private static final long serialVersionUID = -3158348904963758664L;

    public CountMoveParallel(int bitmap, int depth, int[] board) {
        super(bitmap, depth, board);
    }

    @Override
    protected int[] compute() {
        NodeGen pull = new NodeGen(board, bitmap);
        int processors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(processors);
        ArrayList<CountMove> tasks = new ArrayList<CountMove>();
        int bitmap = pull.nextSafe();
        while (bitmap != 0) {
            counters[0]++;
            if (counters.length > 1) {
                final int[] board2 = Bitmap.apply(board, bitmap);
                CountMove task = new CountMove(bitmap, counters.length - 1, board2);
                tasks.add(task);
                pool.execute(task);
            }
            bitmap = pull.nextSafe();
        }
        for (CountMove task : tasks)
            Counter.total(counters, task.join());
        return counters;
    }

}
