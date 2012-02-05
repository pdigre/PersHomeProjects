package no.pdigre.droidchess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.swt.SWT; 
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Chess extends ChessGraphics {

    public static void main(String[] args) {
        new Chess().init();
    }

    HashSet<Integer> markers = new HashSet<Integer>();
    public Game game=new Game();

    private void init() {

    	PrinterData data=new PrinterData();
//		Printer printer=new Printer(data);
//    	Point dpi = printer.getDPI();
//    	FontData[] fontList = printer.getFontList("Arial", true);
//    	GC gc = new GC(printer);
//    	FontData fd = fontList[0];
//    	int height = fd.getHeight();
//    	fd.setHeight(10);
//		gc.setFont(new Font(printer, fd));
//    	Point p1 = gc.stringExtent("Per");
    	
        Display display = new Display();
//        GC gc2 = new GC(display);
//		gc2.setFont(new Font(display, fd));
//    	Point p2 = gc2.stringExtent("Per");
//    	Point dpi2 = display.getDPI();
        Shell shell = new Shell(display);
        final Canvas canvas = new Canvas(shell, SWT.None);
        canvas.addPaintListener(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                drawBoard(e.gc, (Canvas) e.widget);
            }
        });
        canvas.addMouseListener(new MouseListener() {

            Integer from = -1;

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                int i = findSquare(canvas, e.x, e.y);
                if (e.button == 1) {
                    markers.clear();
                    List<int[]> moves = new ArrayList<int[]>();
                    for (Piece piece : game.pieces) {
                        if (piece.pos == i) {
                            piece.findMoves(game.getCurrentBoard(), moves, game.log.isEmpty()?null:game.log.peek(), game.pieces);
                            for (int[] move : moves) {
                                if(move[0]==i)
                                markers.add(move[1]);
                            } 
                        }
                    }
                    canvas.redraw();
                    canvas.update();
                } else if (e.button == 3) {
                    if (from == -1) {
                        from = i;
                        markers.add(from);
                        canvas.redraw();
                        canvas.update();
                    } else {
                        markers.remove(from);
                        game.move(from, i);
                        canvas.redraw();
                        canvas.update();
                        from = -1;
                    }
                }
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        shell.setLayout(new FillLayout());
        shell.setSize(400, 300);
        shell.open();
        canvas.redraw();
        canvas.update();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();

        }
        display.dispose();
    }

    private void drawBoard(GC gc, Canvas canvas) {
        Rectangle area = canvas.getClientArea();
        gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2, area.height - 2);
        for (int i = 0; i < 64; i++)
            drawSquare(gc, i, markers.contains(i) ? SWT.COLOR_GREEN : 0);
        for (Piece piece : game.pieces)
            drawPiece(gc, piece.pos, piece.type);
    }

}
