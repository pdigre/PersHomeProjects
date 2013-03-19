package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;

public class NegaMaxCutoff implements IThinker {

    private IThinker next;

    private IThinker parent;

    private int bitmap;

    private int[] board;

    private int counter;

    private int countertot;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMaxCutoff(IThinker next) {
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(int[] board0, int bitmap0, int total, int alpha, int beta) {
        this.bitmap = bitmap0;
        this.board = board0;
        total += Bitmap.tacticValue(bitmap0);
        int[] moves = NodeUtil.getAllBestFirst(board0, bitmap0);
        countertot+=moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            counter++;
            int score = -next.think(Bitmap.apply(board0, bitmap), bitmap, -total, -beta, -alpha);
            if (score >= beta)
                return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
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
        System.out.println("Scanning:" + counter + "/" + countertot);
    }

}
