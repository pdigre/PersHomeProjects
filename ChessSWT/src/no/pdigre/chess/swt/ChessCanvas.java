package no.pdigre.chess.swt;

import java.util.ArrayList;
import java.util.EnumMap;

import no.pdigre.chess.engine.fen.PieceType;
import no.pdigre.chess.profile.Marking;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
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

	public static class Square {
		int piece = 99;
		int marker = -1;
		int score = -1000;
	}

	public static Square[] squares = new Square[64];

	private static EnumMap<PieceType, ImageData> imgdatas = new EnumMap<PieceType, ImageData>(
			PieceType.class);

	private static EnumMap<PieceType, Image> images = new EnumMap<PieceType, Image>(
			PieceType.class);
	
	static boolean nobuffer = false;

	public static void updateBoard(PaintEvent event, int[] board,
			ArrayList<Marking> markers) {
        Canvas canvas = (Canvas) event.widget;
        Image image = new Image(event.display, canvas.getBounds());
        GC gcImage = new GC(image);
		drawBoard(gcImage, canvas, board, markers);
        event.gc.drawImage(image, 0, 0);
        image.dispose();
        gcImage.dispose();
	}

	public static void drawBoard(GC gc, Canvas canvas, int[] board,
			ArrayList<Marking> markers) {
		if (nobuffer) {
			Rectangle area = canvas.getClientArea();
			gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2,
					area.height - 2);
		}

		int[] frame = new int[64];
		int[] score = new int[64];

		int color = SWT.COLOR_YELLOW;
		for (Marking mark : markers) {
			int i = mark.pos;
			switch (mark.type) {
			case BestMoveFrom:
				frame[i] = SWT.COLOR_YELLOW;
				break;
			case MoveFrom:
				frame[i] = SWT.COLOR_GREEN;
				break;
			case MarkFrom:
				frame[i] = SWT.COLOR_RED;
				break;
			case MoveTo:
				frame[i] = color;
				score[i] = mark.score;
				break;
			default:
				break;
			}
		}

		for (int i = 0; i < 64; i++) {
			Square square = squares[i];
			if (square == null) {
				square = new Square();
				if (!nobuffer)
					squares[i] = square;
			}
			int piece = board[i];
			if (square.piece != piece || square.score != score[i]) {
				square.piece = piece;
				drawSquare(gc, i, 0);
				if (piece > 0) {
					if (images.isEmpty()) {
						for (PieceType pt : PieceType.values())
							images.put(
									pt,
									new Image(gc.getDevice(), imgdatas
											.get(pt)));
					}
					int x = i % 8;
					int y = (i - x) / 8;
					Image img = images.get(PieceType.types[piece]);
					gc.drawImage(img, BOARD_MARGIN + x * PIECE_WIDTH,
							BOARD_OFFSET - y * PIECE_HEIGHT);
				}
			}
			if (square.marker != frame[i]) {
				square.marker = frame[i];
				drawFrame(gc, i, frame[i]);
			}
			if (square.score != score[i]) {
				square.score = score[i];
				if (score[i] != 0)
					drawScore(gc, i, score[i]);
			}
		}
	}

	private static final int PIECE_HEIGHT = 32;

	private static final int PIECE_WIDTH = 32;

	private static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

	private static final int BOARD_MARGIN = PIECE_WIDTH - 24;

	private static void loadImages(Class<?> clz) {
		for (PieceType ptype : PieceType.values()) {
			String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w"
					+ ptype.fen + ".gif").toLowerCase();
			imgdatas.put(ptype, new ImageData(clz.getClassLoader()
					.getResourceAsStream(filename)));
		}
	}

	private static void drawSquare(GC gc, int i, int color) {
		gc.setBackground(getBGColor(gc, i, color));
		gc.fillRectangle(getRectangle(i));
	}

	private static void drawFrame(GC gc, int i, int color) {
		gc.setForeground(getBGColor(gc, i, color));
		gc.drawRectangle(getRectangle(i));
	}

	private static void drawScore(GC gc, int i, int score) {
		Rectangle r = getRectangle(i);
		gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		gc.drawText(Integer.toString(score), r.x, r.y);
	}

	private static Color getBGColor(GC gc, int i, int color) {
		if (color == 0)
			color = isBlack(i) ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY;
		return gc.getDevice().getSystemColor(color);
	}

	private final static boolean isBlack(int i) {
		return (i % 8 + (i - i % 8) / 8) % 2 == 0;
	}

	private final static Rectangle getRectangle(int i) {
		int x = i % 8;
		return new Rectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET
				- ((i - x) / 8) * PIECE_HEIGHT, PIECE_WIDTH - 1,
				PIECE_HEIGHT - 1);
	}

	public ChessCanvas(Composite parent, int style) {
		super(parent, style);
		loadImages(getClass());
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				if (e.button == 1) {
					selectSquareEvent(findSquare(e.x, e.y));
				} else if (e.button == 3) {
					// right click
				}
			}

			private int findSquare(int ex, int ey) {
				int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
				int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
				if (x < 0 || x > 7 || y < 0 || y > 7)
					return -1;
				return x + y * 8;
			}
		});
		setLayoutData(new GridData(270, 270));
	}

	protected abstract void selectSquareEvent(int i);

}
