package no.pdigre.chess.swt;

import java.lang.Thread.State;
import java.util.ArrayList;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.IPlayer.Players;
import no.pdigre.chess.profile.Marking;

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

public class SwtChessDialog extends Composite{

    public void updateBoard(final IPosition position) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                SwtChessDialog.this.updateBoard(canvas,gc_canvas, game, position);
            }

        };
        canvas.getDisplay().syncExec(runnable);
    }

    public SwtChessCanvas canvas;

    public GC gc_canvas;


    public SwtGameData game = new SwtGameData(this);

    CCombo black;

    CCombo white;

    CCombo fen_combo;

    public void updateBoard(SwtChessCanvas canvas,GC gc2, GameData game2, IPosition pos) {
        ArrayList<Marking> markers = game2.getMarkers();
        int[] board = pos.getBoard();
        canvas.drawBoard(gc2, board, markers);
        canvas.redraw();
        canvas.update();
    }

    public SwtChessDialog(Shell shell) {
        super(shell, SWT.NONE);
        setLayout(new GridLayout(2, false));
        setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
        createCanvas();
        createPanel();
        shell.open();
        drawCanvas();
        game.start(fen_combo.getText(), Players.MANUAL, Players.NOVICE);
    }

    protected void drawCanvas() {
        final Image image = new Image(canvas.getDisplay(), canvas.getSize().x, canvas.getSize().y);
        gc_canvas = new GC(image);
        canvas.addPaintListener(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                e.gc.drawImage(image, 0, 0);
            }

        });
    }

    protected void createCanvas() {
        canvas = new SwtChessCanvas(this, SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE) {

            @Override
            protected void selectSquareEvent(int i) {
                game.clickSquare(i);
            }

        };
        GridData gd = new GridData(270, 270);
        gd.horizontalAlignment = SWT.BEGINNING;
        gd.verticalAlignment = SWT.BEGINNING;
        canvas.setLayoutData(gd);
    }

    protected void createPanel() {
        Composite panel = new Composite(this, SWT.NONE);
        GridData gd2 = new GridData(SWT.END, SWT.BEGINNING, true, true);
        panel.setLayoutData(gd2);
        panel.setLayout(new GridLayout());

        ArrayList<String> list = new ArrayList<String>();
        for (Players player : Players.values())
            list.add(player.name());
        String[] array = list.toArray(new String[list.size()]);

        new Label(panel, SWT.NONE).setText("Black:");
        black = new CCombo(panel, SWT.BORDER);
        black.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        black.setItems(array);
        black.select(2);

        new Label(panel, SWT.NONE).setText("White:");
        white = new CCombo(panel, SWT.BORDER);
        white.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        white.setItems(array);
        white.select(0);

        final Button button = new Button(panel, SWT.PUSH);
        button.setText("Start");
        GridData gd = new GridData(SWT.END, SWT.BEGINNING, true, true);
        gd.heightHint = 20;
        gd.widthHint = 80;
        button.setLayoutData(gd);

        fen_combo = new CCombo(this, SWT.BORDER);
        fen_combo.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
        fen_combo.setItems(StartingGames.FEN_GAMES);
        fen_combo.select(0);

        button.addSelectionListener(new SelectionListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void widgetSelected(SelectionEvent e) {
                Thread thread = game.thread;
                if (thread.isAlive()) {
                    State state = thread.getState();
                    if (state == State.RUNNABLE) {
                        thread.suspend();
                    } else {
                        thread.resume();
                    }
                } else {
                    game.start(fen_combo.getText(), Players.values()[white.getSelectionIndex()], Players.values()[black.getSelectionIndex()]);
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                //
            }
        });
    }
}
