package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.polyglot.BookMove;
import no.pdigre.chess.engine.polyglot.Polyglot;
import no.pdigre.chess.engine.polyglot.ZobristKey;

public abstract class Player implements IPlayer {

    public Integer from = -1;

    protected int[] bitmaps;

    protected int[] scores;

    protected GameData game;

    public Player(GameData game) {
        this.game = game;
    }

    @Override
    public int[] getBitmaps() {
        return bitmaps;
    }

    @Override
    public int getScore(int bitmap) {
        if (scores != null && scores.length == bitmaps.length)
            for (int i = 0; i < bitmaps.length; i++)
                if (bitmap == bitmaps[i])
                    return scores[i];
        return 0;
    }

    @Override
    public ArrayList<Marking> getMarkers() {
        return new ArrayList<Marking>();
    }

    @Override
    public int clickSquare(int i) {
        return -1;
    }
    
    public void checkPolyglot() {
        IPosition pos = game.position;
        ArrayList<BookMove> list = Polyglot.get(ZobristKey.getKey(pos));
        int[] moves = NodeUtil.getAllMoves(pos.getBoard(), pos.getBitmap());
        bitmaps=new int[list.size()];
        scores=new int[list.size()];
        for (int i = 0; i < bitmaps.length; i++){
            int move = list.get(i).move;
            int f1=Polyglot.getFrom(move);
            int t1=Polyglot.getTo(move);
            for (int bitmap : moves) {
                if(Bitmap.getFrom(bitmap)==f1 && Bitmap.getTo(bitmap)==t1)
                    bitmaps[i]=bitmap;
            }
            scores[i]=list.get(i).weight;
        }
    }

}
