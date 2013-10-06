package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.profile.GraphicsCommon;
import no.pdigre.chess.profile.Marking;
import no.pdigre.chess.profile.Square;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class SwtChessCanvas extends Canvas {

    private static GraphicsCommon common = new GraphicsCommon();

    public GC gc;

    public SwtChessCanvas(Composite parent, int style, final SwtGameData game) {
        super(parent, style);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                if (e.button == 1) {
                    game.clickSquare(GraphicsCommon.findSquare(e.x, e.y));
                } else if (e.button == 3) {
                    // right click
                }
            }

        });
        setLayoutData(new GridData(270, 270));
    }

    public void drawBoard(int[] board, ArrayList<Marking> markers) {
        if (common.nobuffer) {
            Rectangle area = getClientArea();
            gc.drawRectangle(area.x + 1, area.y + 1, area.width - 2, area.height - 2);
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
            Square square = common.setup(i);
            int piece = board[i];
            int[] r = GraphicsCommon.getRectangleXYWH(i);
            if (square.piece != piece || square.score != score[i]) {
                square.piece = piece;
                gc.setBackground(getBGColor(gc.getDevice(), i, 0));
                gc.fillRectangle(r[0],r[1],r[2],r[3]);
                if (piece > 0) {
                    int[] xy = GraphicsCommon.toXY(i);
                    gc.drawImage(SwtGraphics.graphics.getImage(piece, gc.getDevice()),xy[0],xy[1] );
                }
            }
            if (!square.marker.equals(frame[i])) {
                square.marker = frame[i];
                gc.setForeground(getBGColor(gc.getDevice(), i, frame[i]));
                gc.drawRectangle(r[0],r[1],r[2],r[3]);
            }
            if (square.score != score[i]) {
                square.score = score[i];
                if (score[i] != 0) {
                    gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
                    gc.drawText(Integer.toString(score[i]), r[0], r[1]);
                }
            }
        }
    }

    private static Color getBGColor(Device device, int i, int color) {
        return device.getSystemColor(color == 0 ? GraphicsCommon.isBlack(i) ? SWT.COLOR_DARK_GRAY : SWT.COLOR_GRAY : color);
    }


    protected void drawCanvas() {
        final Image image = new Image(getDisplay(), getSize().x, getSize().y);
        gc = new GC(image);
        addPaintListener(new PaintListener() {

            @Override
            public void paintControl(PaintEvent e) {
                e.gc.drawImage(image, 0, 0);
            }

        });
    }
}
