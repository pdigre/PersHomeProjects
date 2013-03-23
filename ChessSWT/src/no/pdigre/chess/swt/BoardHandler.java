package no.pdigre.chess.swt;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class BoardHandler extends ChessGraphics {

    public Canvas canvas;

    public int[] draw_targets = new int[64];

    public int[] draw_score = new int[64];

    public int best_from;

    public int best_to;

    public int[] board;

    public Integer from = -1;

    public void updateAll2() {
        ((ChessCanvas) canvas).updateCanvas(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                ((ChessCanvas) canvas).clearBoard(e);
                ((ChessCanvas) canvas).updatePieces(e);
                ((ChessCanvas) canvas).updateMarkers(e);
            }

        });
    }

    public void updateBoard2() {
        ((ChessCanvas) canvas).updateCanvas(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                ((ChessCanvas) canvas).clearBoard(e);
                ((ChessCanvas) canvas).updatePieces(e);
            }

        });
    }

    public void updateMarkers() {
        ((ChessCanvas) canvas).updateCanvas(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                ((ChessCanvas) canvas).clearBoard(e);
                ((ChessCanvas) canvas).updatePieces(e);
                ((ChessCanvas) canvas).updateMarkers(e);
            }

        });
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

}
