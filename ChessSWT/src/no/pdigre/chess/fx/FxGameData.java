package no.pdigre.chess.fx;

import java.util.ArrayList;

import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Marking;


public class FxGameData extends GameData{
    FxChessCanvas canvas;
    
    public void setCanvas(FxChessCanvas canvas){
        this.canvas=canvas;
    }
    
    @Override
    public void updateBoard() {
        ArrayList<Marking> markers = getMarkers();
        int[] board = position.getBoard();
        canvas.drawBoard(board, markers);
//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//                ArrayList<Marking> markers = getMarkers();
//                int[] board = position.getBoard();
//                canvas.drawBoard(board, markers);
//                canvas.redraw();
//                canvas.update();
//            }
//
//        };
//        canvas.getDisplay().syncExec(runnable);
    }


}
