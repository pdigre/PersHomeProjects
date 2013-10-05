package no.pdigre.chess.swt;

import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.IPlayer.Players;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class SwtChess {

    @Test
    public static void main(String[] args) {
        new SwtChess();
    }

    public SwtChess() {
        Shell shell = new Shell(new Display());
        shell.setLayout(new GridLayout(2, false));
        shell.setSize(500, 370);
        SwtGameData game = new SwtGameData();
        new SwtChessDialog(shell,game);
        game.start(StartingGames.FEN_GAMES[0], Players.MANUAL, Players.NOVICE);
        runDisplay(shell);
    }

    public static void runDisplay(Shell shell) {
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();

        }
        display.dispose();
    }

}
