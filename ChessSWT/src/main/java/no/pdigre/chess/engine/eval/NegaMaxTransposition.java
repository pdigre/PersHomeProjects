package no.pdigre.chess.engine.eval;

import java.util.concurrent.ConcurrentHashMap;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;

public class NegaMaxTransposition implements IThinker {

    public static long FROMTO_1 = 63 | (63 << 6);

    public static long FROMTO_2 = FROMTO_1 << 12;

    public static long FROMTO_3 = FROMTO_2 << 12;

    
    public ConcurrentHashMap<Long, Integer> tt = new ConcurrentHashMap<Long, Integer>();

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
        int[] moves = NodeUtil.getAllBestFirst(board0, bitmap0);
        counter+=moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            long key = Bitmap.getFromTo(bitmap) | (getKey(this) << 12);
            long t = getTransposition(key);
            int score = 0;
            Integer val=tt.get(t);
            if (val!=null) {
                score = val;
            } else {
                score = -next.think(Bitmap.apply(board0, bitmap), bitmap, -total, -beta, -alpha);
                tt.put(key, score);
            }
            if (score >= beta)
                return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
    }

    final private static long getTransposition(long key) {
        return key & FROMTO_3 >> 24 | (key & FROMTO_2) | key & FROMTO_1 << 24;
    }

    final private static long getKey(IThinker thinker) {
        long key = Bitmap.getFromTo(thinker.getCurrent());
        IThinker parent = thinker.getParent();
        if (parent != null)
            key += getKey(parent) << 12;
        return key;
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
