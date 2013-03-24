package no.pdigre.chess.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class ChessGraphics {

    public static final int PIECE_HEIGHT = 32;

    public static final int PIECE_WIDTH = 32;

    public static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

    public static final int BOARD_MARGIN = PIECE_WIDTH - 24;

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

    private static Color getBGColor(GC gc, int i, int color) {
        if (color == 0)
            color = isBlack(i) ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY;
        return gc.getDevice().getSystemColor(color);
    }

    private static boolean isBlack(int i) {
        return (i % 8 + (i - i % 8) / 8) % 2 == 0;
    }

    private static Rectangle getRectangle(int i) {
        int x = i % 8;
        return new Rectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - ((i - x) / 8) * PIECE_HEIGHT,
            PIECE_WIDTH - 1, PIECE_HEIGHT - 1);
    }

    public static int findSquare(int ex, int ey) {
        int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
        int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return -1;
        return x + y * 8;
    }

}