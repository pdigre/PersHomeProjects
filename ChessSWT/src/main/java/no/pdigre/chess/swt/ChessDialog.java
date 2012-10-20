package no.pdigre.chess.swt;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ChessDialog {
    public ChessCanvas canvas;
    
    public ChessDialog(){
    	Shell shell = new Shell(new Display());
        canvas = new ChessCanvas(shell, SWT.None){
        	public void markMoves(int i) {
        		game.markToMoves(i);
        		updateAll();
        	}

        	public void makeMove(int i) {
        		game.makeMove(i);
        		updateAll();
        	}
        };
        shell.setLayout(new GridLayout(2, false));
        shell.setSize(500, 350);
        Composite contoller = new Composite(shell, SWT.NONE);
        contoller.setLayoutData(new GridData());
        final CCombo cc = new CCombo(shell, SWT.BORDER);
        cc.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
        cc.setItems(StartingGames.FEN_GAMES);
        cc.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
            	setup(new StartGame(cc.getText()));
            }

        });
        cc.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                setup(new StartGame(cc.getText()));
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // not
            }
        });
    	shell.open();
    }

    public void setup(IPosition startGame) {
    	canvas.game.setup(startGame);
    	canvas.updateBoard();

		new Thread(new Runnable() {

			@Override
			public void run() {
				canvas.game.analyzeMarkers();
				canvas.updateMarkers();
			}
		}).run();
    }

	public void run() {
        Shell shell = canvas.getShell();
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();

        }
        display.dispose();
    }

}
