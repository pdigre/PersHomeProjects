package no.pdigre.chess.swt;

import java.lang.Thread.State;
import java.util.ArrayList;

import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.IPlayer.Players;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ChessDialog {

	public ChessCanvas canvas;

	public Image image;

	public GC gc;

	public PaintListener painter = new PaintListener() {

		@Override
		public void paintControl(PaintEvent e) {
			e.gc.drawImage(image, 0, 0);
		}

	};

	public GameData game = new GameData() {

		@Override
		public void updateBoard() {
			canvas.getDisplay().syncExec(new Runnable() {
				
				@Override
				public void run() {
					ChessCanvas.drawBoard(gc, canvas, position.getBoard(),
							game.getMarkers());
					canvas.redraw();
					canvas.update();
				}
			});
		}

	};

	public ChessDialog(Shell shell) {
		shell.setLayout(new GridLayout(2, false));
		shell.setSize(500, 370);
		Composite comp = new Composite(shell, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		comp.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false,
				false));
		canvas = new ChessCanvas(comp, SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE) {

			@Override
			protected void selectSquareEvent(int i) {
				game.clickSquare(i);
			}

		};
		GridData gd1 = new GridData(270, 270);
		gd1.horizontalAlignment = SWT.BEGINNING;
		gd1.verticalAlignment = SWT.BEGINNING;
		canvas.setLayoutData(gd1);
		Composite panel = new Composite(comp, SWT.NONE);
		GridData gd2 = new GridData(SWT.END, SWT.BEGINNING, true, true);
		panel.setLayoutData(gd2);
		panel.setLayout(new GridLayout());

		ArrayList<String> list = new ArrayList<String>();
		for (Players player : Players.values()) {
			list.add(player.name());
		}
		String[] array = list.toArray(new String[list.size()]);

		new Label(panel, SWT.NONE).setText("Black:");
		;
		final CCombo black = new CCombo(panel, SWT.BORDER);
		black.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		black.setItems(array);
		black.select(2);

		new Label(panel, SWT.NONE).setText("White:");
		;
		final CCombo white = new CCombo(panel, SWT.BORDER);
		white.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		white.setItems(array);
		white.select(0);

		final Button button = new Button(panel, SWT.PUSH);
		button.setText("Start");
		GridData gd = new GridData(SWT.END, SWT.BEGINNING, true, true);
		gd.heightHint = 20;
		gd.widthHint = 80;
		button.setLayoutData(gd);

		final CCombo cc = new CCombo(comp, SWT.BORDER);
		cc.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		cc.setItems(StartingGames.FEN_GAMES);
		cc.select(0);

		button.addSelectionListener(new SelectionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void widgetSelected(SelectionEvent e) {
				Thread thread = game.thread;
				if(thread.isAlive()){
					State state = thread.getState();
					if(state==State.RUNNABLE){
							thread.suspend();
					} else{
						thread.resume();
					}
				} else
				start(black, white, cc);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		shell.open();
		image = new Image(canvas.getDisplay(), canvas.getSize().x,
				canvas.getSize().y);
		gc = new GC(image);
		canvas.addPaintListener(painter);
		start(black, white, cc);
	}

	protected void start(final CCombo black, final CCombo white, final CCombo cc) {
		game.setPlayer(Players.values()[black.getSelectionIndex()], false);
		game.setPlayer(Players.values()[white.getSelectionIndex()], true);
		game.setupFEN(cc.getText());
		game.run();
	}

}
