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

    private int total;

    private int hits;

    private int adds;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMaxTransposition(IThinker next) {
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(int[] board0, int bitmap0, int aggr, int alpha, int beta) {
        this.bitmap = bitmap0;
        this.board = board0;
        aggr += Bitmap.tacticValue(bitmap0);
        long ft1 = Bitmap.getFromTo(getParent().getBitmap());
        long ft2 = Bitmap.getFromTo(bitmap0);
        long ft2x = ft2 << 12;
        long commonkey = ft1 | ft2x;
        long commontrn = ft2x | (ft1 << 24);
//        String s1 = fromto((int) ft1);
//        String s12 = FEN.printMove(getParent().getBitmap(), board0);
//        String s2 = fromto((int) ft2);
//        String s22 = FEN.printMove(bitmap0, board0);
        int[] moves = NodeUtil.getAllBestFirst(board0, bitmap0);
        total += moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            int score = 0;
            long ft3 = Bitmap.getFromTo(bitmap);
//            String s3 = fromto((int) ft3);
//            String s32 = FEN.printMove(bitmap, Bitmap.apply(board0, bitmap));
            Long trans = ft3 | commontrn;
            if (tt.contains(trans)) {
                hits++;
                continue;
            }
            adds++;
            Long key = commonkey | (ft3 << 24);
            tt.add(key);
            score = -next.think(Bitmap.apply(board0, bitmap), bitmap, -aggr, -beta, -alpha);
            // if (score >= beta)
            // return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
    }

    public static String[] S1 = "1,2,3,4,5,6,7,8".split(",");

    public static String[] S2 = "A,B,C,D,E,F,G,H".split(",");

    public static String fromto(int p) {
        return (S2[p & 7]) + (S1[(p >> 3) & 7]) + (S2[(p >> 6) & 7]) + (S1[(p >> 9) & 7]);
    }

    @Override
    public int getBitmap() {
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
        System.out.println("Scanning:" + tt.size() + "/" + total + " (hits:" + hits + ",adds:" + adds + ")");
    }

}
