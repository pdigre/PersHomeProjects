package no.pdigre.chess.swt;

import java.util.ArrayList;
import java.util.EnumMap;

import no.pdigre.chess.engine.fen.PieceType;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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

    public static EnumMap<PieceType, ImageData> imgdatas = new EnumMap<PieceType, ImageData>(PieceType.class);

    public static EnumMap<PieceType, Image> images = new EnumMap<PieceType, Image>(PieceType.class);

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
        });
        setLayoutData(new GridData(270, 270));
    }

    protected abstract void selectSquareEvent(int i);

    public void updateCanvas(PaintListener painter) {
        addPaintListener(painter);
        redraw();
        update();
        removePaintListener(painter);
    }


    public static void updateMarkers(PaintEvent e, ArrayList<Marking> markings) {
        int color = SWT.COLOR_YELLOW;
        for (Marking mark : markings) {
            switch (mark.type) {
                case BestMoveFrom:
                    drawFrame(e.gc, mark.pos, SWT.COLOR_YELLOW);
                    break;
                case MoveFrom:
                    drawFrame(e.gc, mark.pos, SWT.COLOR_GREEN);
                    break;
                case MarkFrom:
                    drawFrame(e.gc, mark.pos, SWT.COLOR_RED);
                    break;
                case MoveTo:
                    drawFrame(e.gc, mark.pos, color);
                    color = SWT.COLOR_GREEN;
                    drawScore(e.gc, mark.pos, mark.score);
                    break;
                default:
                    break;
            }
        }
    }

    public static void clearBoard(PaintEvent e) {
        GC gc = e.gc;
        Rectangle area = ((Canvas) e.widget).getClientArea();
        gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2, area.height - 2);
        for (int i = 0; i < 64; i++)
            drawSquare(gc, i, 0);
    }

    public static void updatePieces(PaintEvent e, int[] board) {
        for (int i = 0; i < 64; i++) {
            if (images.isEmpty()) {
                for (PieceType pt : PieceType.values())
                    images.put(pt, new Image(e.gc.getDevice(), imgdatas.get(pt)));
            }
            int x = i % 8;
            int y = (i - x) / 8;
            int piece = board[i];
            if (piece > 0) {
                Image img = images.get(PieceType.types[piece]);
                e.gc.drawImage(img, BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET
                    - y * PIECE_HEIGHT);
            }
        }
    }

    private static final int PIECE_HEIGHT = 32;

    private static final int PIECE_WIDTH = 32;

    private static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

    private static final int BOARD_MARGIN = PIECE_WIDTH - 24;

    private static void loadImages(Class<?> clz) {
        for (PieceType ptype : PieceType.values()) {
            String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w" + ptype.fen + ".gif")
                .toLowerCase();
            imgdatas.put(ptype, new ImageData(clz.getClassLoader().getResourceAsStream(filename)));
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
        return new Rectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - ((i - x) / 8) * PIECE_HEIGHT,
            PIECE_WIDTH - 1, PIECE_HEIGHT - 1);
    }

    final static int findSquare(int ex, int ey) {
        int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
        int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return -1;
        return x + y * 8;
    }

}
