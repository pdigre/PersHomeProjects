package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Marking;


public class SwtGameData extends GameData {

    SwtChessCanvas canvas;
    
    public void setCanvas(SwtChessCanvas canvas){
        this.canvas=canvas;
    }
    
    @Override
    public void updateBoard() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                ArrayList<Marking> markers = getMarkers();
                int[] board = position.getBoard();
                canvas.drawBoard(board, markers);
                canvas.redraw();
                canvas.update();
            }

        };
        canvas.getDisplay().syncExec(runnable);
    }
}
