package no.pdigre.chess.swt;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.NodeGen;
import no.pdigre.chess.eval.AlphaBeta;
import no.pdigre.chess.eval.MoveEval;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.IPosition;
import no.pdigre.chess.fen.Move;
import no.pdigre.chess.fen.StartGame;
import no.pdigre.chess.fen.StartingGames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;

public class Chess extends BoardHandler {

    public IPosition lastmove;

    AlphaBeta eval;

    public static void main(String[] args) {
        new Chess();
    }

    public Chess(){
        createDialog();
        setup(new StartGame(StartingGames.FEN_GAMES[0]));
        runDialog();
    }

    @Override
  public void setup(IPosition startGame) {
        lastmove = startGame;
        board = lastmove.getBoard();
        from = -1;
        updateBoard();
        analyzeMarkers();
    }

    public void analyzeMarkers() {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                eval = new AlphaBeta(lastmove.getBoard(), lastmove.getInherit(), 5);
                System.out.println(FEN.getFen(lastmove));
                draw_targets = new int[64];
                draw_score = new int[64];
                MoveEval[] moves = eval.moves;
                int best = moves[0].bitmap;
                best_from = Bitmap.getFrom(best);
                best_to = Bitmap.getTo(best);
                for (MoveEval move : moves) {
                    int from = Bitmap.getFrom(move.bitmap);
                    if (draw_score[from] == 0)
                        draw_score[from] = move.score;
                }
                updateMarkers();
            }
        }).run();
    }

    @Override
    public void leftClick(final Canvas canvas, MouseEvent e) {
        int i = findSquare(e.x, e.y);
        int[] bitmaps = eval.getBitmaps();
        if (draw_targets[i] != 0) {
            setup(new Move(lastmove, NodeGen.filterTo(NodeGen.filterFrom(bitmaps, from), i)[0]));
        } else {
            from = i;
            markToMoves(i, bitmaps);
        }
        updateAll();
    }

    public void markToMoves(int from, int[] bitmaps) {
        draw_targets = new int[64];
        draw_score = new int[64];
        int[] movesfrom = NodeGen.filterFrom(bitmaps, from);
        for (int bitmap : movesfrom) {
            int to = Bitmap.getTo(bitmap);
            draw_targets[to] = Bitmap.type(bitmap);
            System.out.println("\n==" + FEN.printMove(bitmap, board));
            draw_score[to] = eval.getMove(bitmap).score;
        }
    }

    @Override
    public void drawMarkers(GC gc) {
        MoveEval[] moves = eval.moves;
        if(from==-1){
            int best = Bitmap.getFrom(moves[0].bitmap);
            for (MoveEval move : moves) {
                int fr = Bitmap.getFrom(move.bitmap);
                drawFrame(gc, fr, fr==best?SWT.COLOR_YELLOW:SWT.COLOR_GREEN);
            }
        } else {
            drawFrame(gc, from, SWT.COLOR_RED);
            int color = SWT.COLOR_YELLOW;
            for (MoveEval move : moves) {
                if(Bitmap.getFrom(move.bitmap)==from){
                    int to = Bitmap.getTo(move.bitmap);
                    drawFrame(gc, to, color);
                    color=SWT.COLOR_GREEN;
                    drawScore(gc, to, move.score);
                }
            }
        }
    }


}
