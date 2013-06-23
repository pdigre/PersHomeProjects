package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.AlphaBeta;

public class Manual extends Player {

    @Override
    public void run() { 
    	printFEN();
        bitmaps = new AlphaBeta(getBoard(), getBitmap(),0).getBitmaps();
		game.updateBoard();
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
        if(from == -1)
            return Marking.getPiecesThatCanMove(getBoard(),getBitmap());
        return Marking.getMovesForPiece(getBoard(),getBitmap(),from);
    }
}
