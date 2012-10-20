package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.PieceType;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public abstract class ChessCanvas extends Canvas {

	GameData game = new GameData();

	public boolean todo_board = false;
	public boolean todo_pieces = false;
	public boolean todo_markers = false;

	public ChessCanvas(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				updateBoard(e);
			}

		});
		addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseDown(MouseEvent e) {
				if (e.button == 1) {
					int i = findSquare(e.x, e.y);
					if (game.draw_targets[i] != 0) {
						makeMove(i);
					} else {
						markMoves(i);
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
		setLayoutData(new GridData(270, 270));
	}

	public abstract void markMoves(int i);

	public abstract void makeMove(int i);

	public void updateBoard(PaintEvent e) {
		if (todo_board) {
			todo_board = false;
			drawBoard(e.gc, (Canvas) e.widget);
		}
		if (todo_pieces) {
			todo_pieces = false;
			for (int i = 0; i < 64; i++)
				drawPiece(e.gc, i, game.board[i]);
		}
		if (todo_markers) {
			todo_markers = false;
			if (game.from == -1) {
				markPiecesThatCanMove(e.gc);
			} else {
				markMovesForPiece(e.gc);
			}
		}
	}

	public void updateAll() {
		todo_board = true;
		todo_pieces = true;
		todo_markers = true;
		updateCanvas();
	}

	public void updateBoard() {
		todo_board = true;
		todo_pieces = true;
		updateCanvas();
	}

	public void updateMarkers() {
		todo_board = true;
		todo_pieces = true;
		todo_markers = true;
		updateCanvas();
	}

	public void updateCanvas() {
		redraw();
		update();
	}

	public void drawPieces(GC gc) {
		for (int i = 0; i < 64; i++)
			drawPiece(gc, i, game.board[i]);
	}

	public static void drawBoard(GC gc, Canvas canvas) {
		Rectangle area = canvas.getClientArea();
		gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2,
				area.height - 2);
		for (int i = 0; i < 64; i++)
			drawSquare(gc, i, 0);
	}

	public static final int PIECE_HEIGHT = 32;

	public static final int PIECE_WIDTH = 32;

	public static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

	public static final int BOARD_MARGIN = PIECE_WIDTH - 24;

	public void drawPiece(GC gc, int i, int type) {
		if (type == 0)
			return;
		PieceType ptype = PieceType.types[type];
		int x = i % 8;
		int y = (i - x) / 8;
		String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w"
				+ ptype.fen + ".gif").toLowerCase();
		Image img = new Image(gc.getDevice(), new ImageData(getClass()
				.getClassLoader().getResourceAsStream(filename)));
		gc.drawImage(img, BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - y
				* PIECE_HEIGHT);
	}

	public static void drawSquare(GC gc, int i, int color) {
		gc.setBackground(getBGColor(gc, i, color));
		gc.fillRectangle(getRectangle(i));
	}

	public static void drawFrame(GC gc, int i, int color) {
		gc.setForeground(getBGColor(gc, i, color));
		gc.drawRectangle(getRectangle(i));
	}

	public static void drawScore(GC gc, int i, int score) {
		Rectangle r = getRectangle(i);
		gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		gc.drawText(Integer.toString(score), r.x, r.y);
	}

	public static Color getBGColor(GC gc, int i, int color) {
		if (color == 0)
			color = isBlack(i) ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY;
		return gc.getDevice().getSystemColor(color);
	}

	public static boolean isBlack(int i) {
		return (i % 8 + (i - i % 8) / 8) % 2 == 0;
	}

	public static Rectangle getRectangle(int i) {
		int x = i % 8;
		return new Rectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET
				- ((i - x) / 8) * PIECE_HEIGHT, PIECE_WIDTH - 1,
				PIECE_HEIGHT - 1);
	}

	public static int findSquare(int ex, int ey) {
		int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
		int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
		if (x < 0 || x > 7 || y < 0 || y > 7)
			return -1;
		return x + y * 8;
	}

	public void markPiecesThatCanMove(GC gc) {
		ArrayList<Marking> list = game.markPiecesThatCanMove();
		for (Marking mark : list) {
			drawFrame(gc, mark.pos,
					mark.type == MarkingType.BestMoveFrom ? SWT.COLOR_YELLOW
							: SWT.COLOR_GREEN);
		}
	}


	public void markMovesForPiece(GC gc) {
		ArrayList<Marking> list = game.markMovesForPiece(gc);
		for (Marking mark : list) {
			int color = SWT.COLOR_YELLOW;
			switch(mark.type){
			case MoveFrom:
				drawFrame(gc, mark.pos, SWT.COLOR_RED);
				break;
			case MoveTo:
				drawFrame(gc, mark.pos, color);
				color = SWT.COLOR_GREEN;
				drawScore(gc, mark.pos, mark.score);
				break;
			default:
				break;
			}
		}
	}


}
