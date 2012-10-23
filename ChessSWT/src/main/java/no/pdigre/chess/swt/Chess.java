package no.pdigre.chess.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Chess {

    public static void main(String[] args) {
        new Chess();
    }

    public Chess(){
        Shell shell = new Shell(new Display());
    	new ChessDialog(shell);
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        
        }
        display.dispose();
    }



}
