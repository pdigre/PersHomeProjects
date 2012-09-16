package no.pdigre.chess.swt;

import no.pdigre.chess.fen.IPosition;
import no.pdigre.chess.fen.StartGame;
import no.pdigre.chess.fen.StartingGames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class BoardHandler extends ChessGraphics {

    public int[] draw_targets = new int[64];

    public int[] draw_score = new int[64];
    
    public int best_from;
    public int best_to;

    public int[] board;

    public Integer from = -1;

    public boolean todo_board = false;

    public boolean todo_pieces = false;

    public boolean todo_markers = false;

    public Canvas canvas;

    public void updateBoard(PaintEvent e) {
        if (todo_board) {
            todo_board = false;
            drawBoard(e.gc, (Canvas) e.widget);
        }
        if (todo_pieces) {
            todo_pieces = false;
            drawPieces(e.gc);
        }
        if (todo_markers) {
            todo_markers = false;
            drawMarkers(e.gc);
        }
    }

    public void updateAll() {
        todo_board = true;
        todo_pieces = true;
        todo_markers = true;
        update();
    }

    public void updateBoard() {
        todo_board = true;
        todo_pieces = true;
        update();
    }

    public void updateMarkers() {
        todo_board = true;
        todo_pieces = true;
        todo_markers = true;
        update();
    }

    public void update() {
        canvas.redraw();
        canvas.update();
    }

    public void createDialog() {
        Display display = new Display();
        Shell shell = new Shell(display);
        canvas = new Canvas(shell, SWT.None);
        canvas.addPaintListener(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                updateBoard(e);
            }

        });
        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                if (e.button == 1) {
                    leftClick(canvas, e);
                } else if (e.button == 3) {
                    // right click
                }
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });
        shell.setLayout(new GridLayout(2, false));
        canvas.setLayoutData(new GridData(270, 270));
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

    public void runDialog() {
        Shell shell = canvas.getShell();
        Display display = shell.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();

        }
        display.dispose();
    }

    public abstract void leftClick(Canvas canvas, MouseEvent e);

    public abstract void drawMarkers(GC gc);

    public void drawPieces(GC gc) {
        for (int i = 0; i < 64; i++) {
            int type = board[i];
            drawPiece(gc, i, type);
        }
    }

    public static void drawBoard(GC gc, Canvas canvas) {
        Rectangle area = canvas.getClientArea();
        gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2, area.height - 2);
        for (int i = 0; i < 64; i++) {
            drawSquare(gc, i, 0);
        }
    }

    public abstract void setup(IPosition startGame);
}
