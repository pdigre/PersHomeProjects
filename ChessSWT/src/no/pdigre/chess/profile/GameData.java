package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;
import no.pdigre.chess.engine.fen.StartGame;

public abstract class GameData {

    int[] draw_targets = new int[64];

    int[] draw_score = new int[64];

    public int[] board;

    public Integer from = -1;

    public IPosition position;

    AlphaBeta eval;

    private Player white = new Manual(this);

    private Player black = new Novice(this);
    
    public void setupFEN(String fen) {
        setup(new StartGame(fen));
    }

    void setup(IPosition move) {
        position = move;
        board = position.getBoard();
        from = -1;
        updateBoard();
    }

    public void computeMarkers() {
        (position.whiteTurn()?white:black).run();
    }

    public void clickSquare(int i) {
        if (draw_targets[i] != 0) {
            int[] moves = NodeUtil.filterTo(NodeUtil.filterFrom(eval.getBitmaps(), from), i);
            setup(new Move(position, moves[0]));
        } else {
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
    }

    protected abstract void updateMarkers();

    protected abstract void updateBoard();

    public static ArrayList<Marking> getPiecesThatCanMove(int[] board,int bitmap) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        int best = Bitmap.getFrom(moves[0]);
        for (int move : moves) {
            int fr = Bitmap.getFrom(move);
            list.add(new Marking(fr == best ? MarkingType.BestMoveFrom : MarkingType.MoveFrom, fr));
        }
        return list;
    }

    public static ArrayList<Marking> getMovesForPiece(int[] board,int bitmap, int from) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        list.add(new Marking(MarkingType.MarkFrom, from));
        for (int move : moves) {
            if (Bitmap.getFrom(move) == from)
                list.add(new Marking(MarkingType.MoveTo, Bitmap.getTo(move), 0));
        }
        return list;
    }



}
