package no.pdigre.chess.engine.eval;

import java.util.HashSet;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;

public class NegaMaxTransposition implements IThinker {

    public static long FROMTO_1 = 63 | (63 << 6);

    public static long FROMTO_2 = FROMTO_1 << 12;

    public static long FROMTO_3 = FROMTO_2 << 12;

    public HashSet<Long> tt = new HashSet<Long>();

    private IThinker next;

    private int bitmap;

    private IThinker parent;

    private int[] board;

    private int counter;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMaxTransposition(IThinker next) {
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(int[] board0, int bitmap0, int total, int alpha, int beta) {
        this.bitmap = bitmap0;
        this.board = board0;
        total += Bitmap.tacticValue(bitmap0);
        int ft1 = Bitmap.getFromTo(getParent().getCurrent());
        int ft2x = Bitmap.getFromTo(bitmap0) << 12;
        long commonkey = ft1 | ft2x;
        long commontrn = ft2x | (ft1 << 24);
        int[] moves = NodeUtil.getAllBestFirst(board0, bitmap0);
        counter += moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            int score = 0;
            long ft3 = Bitmap.getFromTo(bitmap);
            if (tt.contains(ft3 | commontrn))
                continue;
            tt.add(commonkey | (ft3 << 24));
            score = -next.think(Bitmap.apply(board0, bitmap), bitmap, -total, -beta, -alpha);
//            if (score >= beta)
//                return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
    }

    @Override
    public int getCurrent() {
        return bitmap;
    }

    @Override
    public IThinker getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return FEN.board2String(board) + "\n" + FEN.printMove(bitmap, board);
    }

    public void printHitrate() {
        System.out.println("Scanning:" + tt.size() + "/" + counter);
    }

}
