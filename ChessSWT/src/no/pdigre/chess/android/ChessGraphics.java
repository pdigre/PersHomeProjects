package no.pdigre.chess.android;

import no.pdigre.chess.rules.PieceType;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;

public class ChessGraphics {
    public static final int PIECE_HEIGHT = 32; 

    public static final int PIECE_WIDTH = 32;

    public static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

    public static final int BOARD_MARGIN = PIECE_WIDTH - 24;


    public ChessGraphics() {
        super();
    }

    public void drawPiece(GC gc, int i, PieceType type) {
        int x = i % 8;
        int y = (i - x) / 8;
        String filename=(type.fen>'Z'?"b"+type.fen+".gif":"w"+type.fen+".gif").toLowerCase();
        Image img = new Image(gc.getDevice(), new ImageData(getClass().getClassLoader().getResourceAsStream(
            filename)));
        gc.drawImage(img, BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - y * PIECE_HEIGHT);
    }

    public void drawSquare(GC gc, int i, int color) {
        int x = i % 8;
        int y = (i - x) / 8;
        if (color == 0)
            color = (x + y) % 2 == 0 ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY;
        gc.setBackground(gc.getDevice().getSystemColor(color));
        gc.fillRectangle(BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - y * PIECE_HEIGHT, PIECE_WIDTH,
            PIECE_HEIGHT);
    }

    public int findSquare(Canvas canvas, int ex, int ey) {
        int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
        int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return -1;
        return x + y * 8;
    }


}