package no.pdigre.chess.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class Chess {

    public Shell shell;
    public ChessDialog dialog;

    @Test
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.dialog.game.computeMarkers();
        chess.runDisplay();
    }

    public Chess(){
        shell = new Shell(new Display());
    	dialog = new ChessDialog(shell);
    }

    public void runDisplay() {
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        
        }
        display.dispose();
    }

    public void setup(String fen){
        dialog.game.setupFEN(fen);
    }



}
