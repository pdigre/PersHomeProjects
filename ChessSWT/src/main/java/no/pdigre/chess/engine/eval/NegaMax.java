package no.pdigre.chess.engine.eval;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;

public class NegaMax implements IThinker {

    private IThinker next;

    private int bitmap;

    private IThinker parent;

    private int counter;

    private int[] board;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMax(IThinker next) {
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(int[] board0, int bitmap0, int total, int alpha, int beta) {
        this.bitmap = bitmap0;
        this.board = board0;
        total += Bitmap.tacticValue(bitmap0);
        int max = alpha;
        int[] moves = NodeUtil.getAllBestFirst(board0, bitmap0);
        counter+=moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap1 = moves[i];
            int score = -next.think(Bitmap.apply(board0, bitmap1), bitmap1, -total, -beta, -alpha);
            if (score > max)
                max = score;
        }
        return max;
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
        System.out.println("Hitrate:" + counter + "/" + counter);
    }


}
