package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.ICallBack;
import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.NodeGenerator;

public final class FindMoves implements IAdder {

    public static Collection<Move> getMoves(final int[] board, final ICallBack node) {
        FindMoves adder = new FindMoves(node);
        NodeGenerator.loopLegalMoves(adder, board, node.getInherit());
        return adder.next;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (Bitmap.getFrom(mv.getInherit()) == from)
                list.add(mv);
        }
        return list;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from, int to) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (Bitmap.getFrom(mv.getInherit()) == from && Bitmap.getTo(mv.getInherit()) == to)
                list.add(mv);
        }
        return list;
    }

    public static Collection<Move> getLegalMoves(final ICallBack parent) {
        return getMoves(parent.getBoard(), parent);
    }

    public static boolean isMate(ICallBack move, int[] board) {
        return !NodeGenerator.hasLegalMoves(board, move.getInherit());
    }

    private final ArrayList<Move> next = new ArrayList<Move>();

    private final ICallBack parent;

    private FindMoves(ICallBack parent) {
        this.parent = parent;
    }

    private boolean add(int bitmap) {
        return next.add(new Move(parent, bitmap));
    }

    @Override
    public void move(int bitmap) {
        add(bitmap);
    }

    @Override
    public void movePromote(int bitmap) {
        add(bitmap);
    }

    @Override
    public void capture(int bitmap) {
        add(bitmap);
    }

    @Override
    public void capturePromote(int bitmap) {
        add(bitmap);
    }

    @Override
    public void enpassant(int bitmap) {
        add(bitmap);
    }

    @Override
    public void castling(int bitmap) {
        add(bitmap);
    }

    @Override
    public String toString() {
        return parent.toString();
    }

}