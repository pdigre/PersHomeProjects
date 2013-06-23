package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;

public class Marking {

	public enum MarkingType {
	    MarkFrom,
	    MoveTo,
	    MoveFrom,
	    BestMoveFrom;
	}

	public MarkingType type;
	public int pos;
	public int score;

	public Marking(MarkingType type, int pos) {
		super();
		this.type = type;
		this.pos = pos;
	}

	public Marking(MarkingType type, int pos, int score) {
		super();
		this.type = type;
		this.pos = pos;
		this.score=score;
	}

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


}
