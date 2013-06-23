package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;
import no.pdigre.chess.engine.fen.StartGame;

public abstract class GameData {

    public IPosition position;

    private Player white;

    private Player black;

    public void newGame(String fen) {
        white=new Manual(this);
        black=new Intermediate(this);
        setup(new StartGame(fen));
        run();
    }
    
    public void setupFEN(String fen) {
        setup(new StartGame(fen));
    }

    void setup(IPosition move) {
        position = move;
        updateBoard(position.getBoard());
    }

    public void run() {
        final Player player = getPlayer();
        new Thread(new Runnable() {

            @Override
            public void run() {
                player.run();
            }
        }).run();
    }

    private Player getPlayer() {
        return position.whiteTurn() ? white : black;
    }

    public void clickSquare(int i) {
        Player player = getPlayer();
        int move=player.clickSquare(i);
        if(move>-1)
            makeMove(move);
    }

    public void makeMove(int bitmap) {
        setup(new Move(position, bitmap));
        updateMarkers(position.getBoard(),position.getBitmap(),-1);
        run();
    }

    protected abstract void updateMarkers(final int[] board,final int bitmap,final Integer ifrom);

    protected abstract void updateBoard(final int[] board);

    public static ArrayList<Marking> getPiecesThatCanMove(int[] board, int bitmap) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        int best = Bitmap.getFrom(moves[0]);
        for (int move : moves) {
            int fr = Bitmap.getFrom(move);
            list.add(new Marking(fr == best ? MarkingType.BestMoveFrom : MarkingType.MoveFrom, fr));
        }
        return list;
    }

    public static ArrayList<Marking> getMovesForPiece(int[] board, int bitmap, int from) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        list.add(new Marking(MarkingType.MarkFrom, from));
        for (int move : moves) {
            if (Bitmap.getFrom(move) == from)
                list.add(new Marking(MarkingType.MoveTo, Bitmap.getTo(move), 0));
        }
        return list;
    }

    public ArrayList<Marking> getMarkers() {
        return getPlayer().getMarkers();
    }

}
