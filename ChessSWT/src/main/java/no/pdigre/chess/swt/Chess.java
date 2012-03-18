package no.pdigre.chess.swt;

import java.util.HashSet;
import java.util.List;

import no.pdigre.chess.evaluate.EvalMove;
import no.pdigre.chess.rules.Piece;
import no.pdigre.chess.rules.StartGame;

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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Chess extends ChessGraphics {

	public EvalMove lasteval;
	public Integer from = -1;

	public static void main(String[] args) {
		new Chess().init();
	}

	public void startGame() {
		lasteval = new EvalMove(new StartGame(StartingGames.FEN_GAMES[0]));
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
						Piece piece = lasteval.pieces;
						while (piece != null) {
							if (piece.pos == i) {
								List<Integer> moves = lasteval.getLegalMoves(piece);
								;
								for (Integer to : moves)
									markers.add(to);
							}
							piece=piece.link;
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
		shell.setLayout(new GridLayout(2, false));
		canvas.setLayoutData(new GridData(270,270));
		shell.setSize(500, 350);
		Composite contoller = new Composite(shell,SWT.NONE);
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
				if(i<0)
					return;
				startGame(canvas, cc.getText());
			}

			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
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
		Piece piece = lasteval.pieces;
		while (piece != null) {
			drawPiece(gc, piece.pos, piece.getType());
			piece=piece.link;
		}
	}

	public void startGame(final Canvas canvas, String text) {
		lasteval=new EvalMove(new StartGame(text));
		from=-1;
		markers.clear();
		canvas.redraw();
		canvas.update();
	}

}
