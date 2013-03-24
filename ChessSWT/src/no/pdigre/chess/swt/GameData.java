package no.pdigre.chess.swt;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.eval.MoveEval;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;

public abstract class GameData {

    int[] draw_targets = new int[64];

    private int[] draw_score = new int[64];

    public int[] board;

    Integer from = -1;

    public IPosition position;

    AlphaBeta eval;

    Player white = new Manual(this);

    Player black = new Novice(this);
    
    public void setup(IPosition move) {
        position = move;
        board = position.getBoard();
        from = -1;
        updateBoard();
    }

    public void computeMarkers() {
        (position.whiteTurn()?white:black).run();
    }

    public void manual() {
        System.out.println(FEN.getFen(position));
        eval= new JustMoves(position.getBoard(), position.getBitmap());
    }

    public void manualWithHelp() {
        System.out.println(FEN.getFen(position));
        eval = new AlphaBeta(position.getBoard(), position.getBitmap(), 5);
        draw_targets = new int[64];
        draw_score = new int[64];
        MoveEval[] moves = eval.moves;
        for (MoveEval move : moves) {
            int from = Bitmap.getFrom(move.bitmap);
            if (draw_score[from] == 0)
                draw_score[from] = move.score;
        }
    }

    public void noviceMove() {
        System.out.println(FEN.getFen(position));
        eval = new AlphaBeta(position.getBoard(), position.getBitmap(), 5);
        setup(new Move(position, eval.getBitmaps()[0]));
    }

    private void markToMoves(int i) {
        int[] bitmaps = eval.getBitmaps();
        from = i;
        draw_targets = new int[64];
        draw_score = new int[64];
        int[] movesfrom = NodeUtil.filterFrom(bitmaps, i);
        for (int bitmap : movesfrom) {
            int to = Bitmap.getTo(bitmap);
            draw_targets[to] = Bitmap.type(bitmap);
            System.out.println("\n==" + FEN.printMove(bitmap, board));
            draw_score[to] = eval.getMove(bitmap).score;
        }
    }

    private Move makeMove(int i) {
        return new Move(position, NodeUtil.filterTo(NodeUtil.filterFrom(eval.getBitmaps(), from), i)[0]);
    }

    protected void clickSquare(int i) {
        if (draw_targets[i] != 0) {
            setup(makeMove(i));
        } else {
            markToMoves(i);
        }
    }

    protected abstract void updateMarkers();

    protected abstract void updateBoard();

}
