package no.pdigre.chess.swt;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.NodeGen;
import no.pdigre.chess.eval.AlphaBeta;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.IPosition;
import no.pdigre.chess.fen.Move;
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

public class Chess extends ChessGraphics {

    public IPosition lastmove;

    public Integer from = -1;

    public int hintnum = -1;

    public int[] draw_targets = new int[64];

    public int[] draw_score = new int[64];

    public static void main(String[] args) {
        new Chess().init();
    }

    public void startGame() {
        lastmove = new StartGame(StartingGames.FEN_GAMES[0]);
        System.out.println(FEN.getFen(lastmove));
    }

    private void init() {
        startGame();
        Display display = new Display();
        Shell shell = new Shell(display);
        final Canvas canvas = new Canvas(shell, SWT.None);
        canvas.addPaintListener(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                drawBoard(e.gc, (Canvas) e.widget);
            }
        });
        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                int i = findSquare(e.x, e.y);
                if (e.button == 1) {
                    int[] board = lastmove.getBoard();
                    int[] legalmoves = NodeGen.getAllMoves(board, lastmove.getInherit());
                    if (draw_targets[i] != 0) {
                        int[] moves = NodeGen.filterTo(NodeGen.filterFrom(legalmoves, from), i);
                        lastmove = new Move(lastmove, moves[0]);
                        System.out.println(lastmove);
                        System.out.println(FEN.getFen(lastmove));
                        from = -1;
                        draw_targets = new int[64];
                        canvas.redraw();
                        canvas.update();
                    } else {
                        if (from == i)
                            hintnum++;
                        else
                            hintnum = -1;
                        from = i;
                        draw_targets = new int[64];
                        draw_score = new int[64];
                        int[] movesfrom = NodeGen.filterFrom(legalmoves, i);
                        for (int bitmap : movesfrom) {
                            int to = Bitmap.getTo(bitmap);
                            draw_targets[to] = Bitmap.type(bitmap);
                            if (hintnum >= 0){
                                System.out.println("\n=="+FEN.printMove(bitmap, board));
                                draw_score[to] = AlphaBeta.alphaBeta(hintnum, board, bitmap);
                            }
                        }
                        canvas.redraw();
                        canvas.update();
                    }
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
                startGame(canvas, cc.getText());
            }
        });
        cc.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                startGame(canvas, cc.getText());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // not
            }
        });
        shell.open();
        canvas.redraw();
        canvas.update();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();

        }
        display.dispose();
    }

    void drawBoard(GC gc, Canvas canvas) {
        Rectangle area = canvas.getClientArea();
        gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2, area.height - 2);
        for (int i = 0; i < 64; i++) {
            drawSquare(gc, i, 0);
            if (draw_targets[i] != 0)
                drawFrame(gc, i, SWT.COLOR_GREEN);
            if (i == from)
                drawFrame(gc, i, SWT.COLOR_RED);
        }
        int[] board = lastmove.getBoard();
        for (int i = 0; i < board.length; i++) {
            int type = board[i];
            if (type != 0) {
                drawPiece(gc, i, type);
            }
            if (hintnum>=0 && draw_targets[i] != 0)
                drawScore(gc, i, draw_score[i]);
        }
    }

    public void startGame(final Canvas canvas, String text) {
        lastmove = new StartGame(text);
        from = -1;
        draw_targets = new int[64];
        canvas.redraw();
        canvas.update();
    }

}
