package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.eval.MoveEval;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;

public abstract class GameData {

    int[] draw_targets = new int[64];

    private int[] draw_score = new int[64];

    int[] board;

    private Integer from = -1;

    private IPosition lastmove;

    private AlphaBeta eval;

    Player white = new Manual(this);

    Player black = new Novice(this);
    
    Player player;

    public void setup(IPosition move) {
        lastmove = move;
        board = lastmove.getBoard();
        from = -1;
        updateBoard();
        player=lastmove.whiteTurn()?white:black;
        player.run();
    }

    public void analyzeMarkers() {
        eval = new AlphaBeta(lastmove.getBoard(), lastmove.getInherit(), 5);
        System.out.println(FEN.getFen(lastmove));
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
        System.out.println(FEN.getFen(lastmove));
        eval = new AlphaBeta(lastmove.getBoard(), lastmove.getInherit(), 5);
        setup(new Move(lastmove, eval.getBitmaps()[0]));
    }

    private void markToMoves(int i) {
        int[] bitmaps = eval.getBitmaps();
        from = i;
        draw_targets = new int[64];
        draw_score = new int[64];
        int[] movesfrom = NodeGen.filterFrom(bitmaps, i);
        for (int bitmap : movesfrom) {
            int to = Bitmap.getTo(bitmap);
            draw_targets[to] = Bitmap.type(bitmap);
            System.out.println("\n==" + FEN.printMove(bitmap, board));
            draw_score[to] = eval.getMove(bitmap).score;
        }
    }

    private Move makeMove(int i) {
        return new Move(lastmove, NodeGen.filterTo(NodeGen.filterFrom(eval.getBitmaps(), from), i)[0]);
    }

    private ArrayList<Marking> getPiecesThatCanMove() {
        ArrayList<Marking> list = new ArrayList<Marking>();
        MoveEval[] moves = eval.moves;
        int best = Bitmap.getFrom(moves[0].bitmap);
        for (MoveEval move : moves) {
            int fr = Bitmap.getFrom(move.bitmap);
            list.add(new Marking(fr == best ? MarkingType.BestMoveFrom : MarkingType.MoveFrom, fr));
        }
        return list;
    }

    private ArrayList<Marking> getMovesForPiece() {
        ArrayList<Marking> list = new ArrayList<Marking>();
        MoveEval[] moves = eval.moves;
        list.add(new Marking(MarkingType.MarkFrom, from));
        for (MoveEval move : moves) {
            if (Bitmap.getFrom(move.bitmap) == from) {
                int to = Bitmap.getTo(move.bitmap);
                list.add(new Marking(MarkingType.MoveTo, to, move.score));
            }
        }
        return list;
    }

    public ArrayList<Marking> getMarkings() {
        return from == -1 ? getPiecesThatCanMove() : getMovesForPiece();
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
