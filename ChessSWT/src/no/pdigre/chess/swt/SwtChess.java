package no.pdigre.chess.swt;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class SwtChess {

	public Shell shell;
	public SwtChessDialog dialog;

	@Test
	public static void main(String[] args) {
		SwtChess chess = new SwtChess();
		chess.dialog.game.run();
		chess.runDisplay();
	}

	public SwtChess() {
		shell = new Shell(new Display());
        shell.setLayout(new GridLayout(2, false));
        shell.setSize(500, 370);
		dialog = new SwtChessDialog(shell);
	}

	public void runDisplay() {
		Display display = shell.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	public void setup(String fen) {
		dialog.game.setupFEN(fen);
	}

}
