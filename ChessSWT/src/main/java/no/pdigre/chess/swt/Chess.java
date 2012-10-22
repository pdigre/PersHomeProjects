package no.pdigre.chess.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;


public class Chess {

    public static void main(String[] args) {
        new Chess();
    }

    public Chess(){
        Shell shell = new Shell(new Display());
    	ChessDialog dia = new ChessDialog(shell);
		dia.setup(new StartGame(StartingGames.FEN_GAMES[0]));
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        
        }
        display.dispose();
    }



}
