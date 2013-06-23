package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;

public class Manual extends Player {

    public Manual(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        IPosition pos = game.position;
        System.out.println(FEN.getFen(pos));
        int[] board = pos.getBoard();
        int bitmap = pos.getBitmap();
        JustMoves eval = new JustMoves(board, bitmap);
        bitmaps = eval.getBitmaps();
        game.updateMarkers(board,bitmap,from);
    }

    @Override
    public int clickSquare(int i) {
        int[] bitmaps = getBitmaps();
        if(from>-1){
            int[] avail = NodeUtil.filterTo(NodeUtil.filterFrom(bitmaps, from), i);
            from=-1;
            if(avail.length>0)
                return avail[0];
        }
        if(from==-1){
            int[] avail = NodeUtil.filterFrom(bitmaps, i);
            if(avail.length>0)
                from=i;
        } 
        return -1;
    }

    @Override
    public ArrayList<Marking> getMarkers() {
        IPosition pos = game.position;
        int[] board = pos.getBoard();
        int bitmap = pos.getBitmap();
        if(from == -1)
            return GameData.getPiecesThatCanMove(board,bitmap);
        return GameData.getMovesForPiece(board,bitmap,from);
    }
}
