package no.pdigre.droidchess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Chess {
	private static final int PIECE_HEIGHT = 32;
	private static final int PIECE_WIDTH = 32;
	private static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;
	private static final int BOARD_MARGIN = PIECE_WIDTH - 24;

	public static void main(String[] args) {
		new Chess().init();
	}

	HashSet<Piece> pieces;
	HashSet<Integer> markers = new HashSet<Integer>();

	private void init() {
		pieces = Piece.startNewBoard();

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

			Integer from = -1;

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent e) {
				int i = findSquare(canvas, e.x, e.y);
				if(e.button==1){
					markers.clear();
					List<Integer> moves = new ArrayList<Integer>();
					for (Piece piece : pieces) {
						if (piece.pos == i) {
							piece.findMoves(pieces,moves);
							markers.addAll(moves);
						}
					}
					canvas.redraw();
					canvas.update();
				}
				if(e.button==3){
					if (from == -1) {
						from = i;
						markers.add(from);
						canvas.redraw();
						canvas.update();
					} else {
						markers.remove(from);
						move(from, i, canvas);
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

	public int findSquare(Canvas canvas, int ex, int ey) {
		int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
		int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
		if (x < 0 || x > 7 || y < 0 || y > 7)
			return -1;
		return x + y * 8;
	}

	private void drawBoard(GC gc, Canvas canvas) {
		Rectangle area = canvas.getClientArea();
		gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2,
				area.height - 2);
		for (int i = 0; i < 64; i++) {
			int x = i % 8;
			int y = (i - x) / 8;
			int color = (x + y) % 2 == 0 ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY;
			if (markers.contains(i))
				color = SWT.COLOR_GREEN;
			gc.setBackground(gc.getDevice().getSystemColor(color));
			gc.fillRectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - y
					* PIECE_HEIGHT, PIECE_WIDTH, PIECE_HEIGHT);
		}
		for (Piece piece : pieces) {
			int x = piece.pos % 8;
			int y = (piece.pos - x) / 8;
			try {
				FileInputStream in = new FileInputStream(piece.type.filename);
				Image img = new Image(gc.getDevice(), new ImageData(in));
				gc.drawImage(img, BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET
						- y * PIECE_HEIGHT);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void move(int from, int to, Canvas canvas) {
		System.out.println("from " + from + " to " + to);
		for (Piece piece : pieces) {
			if (piece.pos == from)
				piece.pos = to;
		}
		canvas.redraw();
		canvas.update();
	}

}
