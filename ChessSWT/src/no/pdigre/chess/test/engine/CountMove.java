package no.pdigre.chess.test.engine;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;

public class CountMove extends RecursiveTask<int[]> {

    private static final long serialVersionUID = -3058548234963758664L;

    final protected int bitmap;

    final protected int[] counters;

    final protected int[] board;

    public CountMove(int bitmap, int depth, int[] board) {
        this.bitmap = bitmap;
        this.board = board;
        counters = new int[depth];
    }

    @Override
    protected int[] compute() {
        NodeGen pull = new NodeGen(board, bitmap);
        int bitmap = pull.nextSafe();
        while (bitmap != 0) {
            counters[0]++;
            if (counters.length > 1) {
                int[] board2 = Bitmap.apply(board, bitmap);
                Counter.total(counters, new CountMove(bitmap, counters.length - 1, board2).compute());
            }
            bitmap = pull.nextSafe();
        }
        return counters;
    }

}
