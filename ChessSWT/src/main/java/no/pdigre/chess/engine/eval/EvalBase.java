package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.fen.FEN;

public class EvalBase implements IThinker {

    final private int[] board;

    final private int bitmap;

    final StringBuilder sb = new StringBuilder();

    public Integer score;

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

    public void firstPass(NegaMax thinker) {
        score = thinker.think(board, bitmap, 0, IThinker.MIN, IThinker.MAX);
        sb.append(score);
    }

    public static EvalBase[] sort(EvalBase[] all) {
        if (all.length < 2)
            return all;
        int cutoff = -9000;
        int next = 0;
        int p2 = all.length - 1;
        EvalBase b2 = all[p2];
        int v2 = b2.score;
        while (next > cutoff) {
            int p1 = 0;
            EvalBase b1 = all[p1];
            int v1 = b1.score;
            cutoff = next;
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
                    EvalBase t1 = b1;
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
