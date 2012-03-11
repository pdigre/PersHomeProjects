package no.pdigre.chess.android;

import java.util.HashSet;
import java.util.List;

import no.pdigre.chess.evaluate.EvalMove;
import no.pdigre.chess.rules.AbstractPiece;
import no.pdigre.chess.rules.StartGame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Chess extends ChessGraphics {

	public EvalMove lasteval;
	public Integer from = -1;

	public static void main(String[] args) {
		new Chess().init();
	}

	public void startGame() {
		lasteval = new EvalMove(StartGame.newGame());
		lasteval.init();
		System.out.println(lasteval.move.getFen());
	}

	HashSet<Integer> markers = new HashSet<Integer>();

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
				int i = findSquare(canvas, e.x, e.y);
				if (e.button == 1) {
					if (markers.contains(i)) {
						lasteval = lasteval.move(from, i);
						System.out.println(lasteval.toString());
						System.out.println(lasteval.move.getFen());
						from=-1;
						markers.clear();
						canvas.redraw();
						canvas.update();
					} else {
						from = i;
						markers.clear();
						for (AbstractPiece piece : lasteval.pieces) {
							if (piece.pos == i) {
								List<Integer> moves = lasteval.getMoves(piece);
								;
								for (Integer to : moves)
									markers.add(to);
							}
						}
						canvas.redraw();
						canvas.update();
					}
				} else if (e.button == 3) {
					if (from == -1) {
						from = i;
						markers.add(from);
						canvas.redraw();
						canvas.update();
					} else {
						markers.remove(from);
						lasteval.move(from, i);
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
		for (int i = 0; i < 64; i++) {
			drawSquare(gc, i, 0);
			if (markers.contains(i))
				drawFrame(gc, i, SWT.COLOR_GREEN);
			if (i == from)
				drawFrame(gc, i, SWT.COLOR_RED);
		}
		for (AbstractPiece piece : lasteval.pieces)
			drawPiece(gc, piece.pos, piece.getType());
	}

}
