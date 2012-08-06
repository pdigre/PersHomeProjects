package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.INode;
import no.pdigre.chess.base.NodeGenerator;

public final class FindMoves implements IAdder {

    public static Collection<Move> getMoves(final int[] board, final INode node) {
        FindMoves adder = new FindMoves(node);
        NodeGenerator.loopLegalMoves(adder, board, node.getBitmap());
        return adder.next;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (MoveBitmap.getFrom(mv.getBitmap()) == from)
                list.add(mv);
        }
        return list;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from, int to) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (MoveBitmap.getFrom(mv.getBitmap()) == from && MoveBitmap.getTo(mv.getBitmap()) == to)
                list.add(mv);
        }
        return list;
    }

    public static Collection<Move> getLegalMoves(final INode parent) {
        return getMoves(parent.getBoard(), parent);
    }

    public static boolean isMate(INode move, int[] board) {
        return !NodeGenerator.hasLegalMoves(board, move.getBitmap());
    }

    private final ArrayList<Move> next = new ArrayList<Move>();

    private final INode parent;

    private FindMoves(INode parent) {
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