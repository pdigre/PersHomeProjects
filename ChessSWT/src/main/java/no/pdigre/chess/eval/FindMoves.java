package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.pdigre.chess.base.NodeGenerator;
import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.INode;

public final class FindMoves implements IAdder {

    /**
     * Fetch all moves as Move objects
     * 
     * @param board
     * @param node
     * @return
     */
    public static Collection<Move> getMoves(final int[] board, final INode node) {
        final int enpassant = node.getEnpassant();
        final int castling = node.getCastlingState();
        FindMoves adder = new FindMoves(board, node);
        for (int i = 0; i < 64; i++) {
            int type = board[i];
            boolean white = MoveBitmap.white(type);
            if (type != 0 && white == adder.whiteTurn) {
                adder.type = type;
                adder.from = i;
                NodeGenerator.addMovesForPiece(adder, board, i, type & 7, white, enpassant, castling);
            }
        }
        return adder.next;
    }

    public static Collection<Move> getMoves2(final int[] board, final INode node) {
        FindMoves adder = new FindMoves(board, node);
        NodeGenerator.loopLegalMoves(adder, board, node.getBitmap());
        return adder.next;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (mv.getFrom() == from)
                list.add(mv);
        }
        return list;
    }

    public static List<Move> filterPieces(Collection<Move> moves, int from, int to) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (mv.getFrom() == from && mv.getTo() == to)
                list.add(mv);
        }
        return list;
    }

    public static ArrayList<Move> getLegalMoves(final INode parent) {
        return getLegalMoves(moves(parent), parent);
    }

    private static int[] moves(final INode parent) {
        return parent.getBoard();
    }

    public static ArrayList<Move> getLegalMoves(int[] board, final INode parent) {
        Collection<Move> moves = getMoves(board, parent);
        return getLegalMoves(moves, board, parent);
    }

    public static ArrayList<Move> getLegalMoves(Collection<Move> moves, int[] board, final INode parent) {
        boolean white = parent.whiteTurn();
        int kingtype = white ? INode.KING : INode.BLACK_KING;
        int kingpos = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == kingtype) {
                kingpos = i;
                break;
            }
        }
        ArrayList<Move> lmoves = new ArrayList<Move>();
        for (Move mv : moves) {
            int pos = mv.getFrom() == kingpos ? mv.getTo() : kingpos;
            if (NodeGenerator.checkSafe(mv.apply(board), pos, white))
                lmoves.add(mv);
        }
        return lmoves;
    }

    public static boolean isMate(INode move, int[] board) {
        Collection<Move> moves = FindMoves.getMoves(board, move);
        return FindMoves.getLegalMoves(moves, board, move).isEmpty();
    }

    private final ArrayList<Move> next = new ArrayList<Move>();

    private final int[] board;

    private final boolean whiteTurn;

    private final INode parent;

    private int from;

    private int type;

    private FindMoves(int[] board, INode parent) {
        this.board = board;
        this.whiteTurn = parent.whiteTurn();
        this.parent = parent;
    }

    @Override
    public void move(int to, int from) {
        add(MoveBitmap.mapMove(from, to, parent.halfMoves(),
            type | MoveBitmap.updateCastling(type, parent.getCastlingState())));
    }

    private boolean add(int bitmap) {
        return next.add(new Move(parent, bitmap));
    }

    @Override
    public void movePromote(int to, int from) {
        add(movepromo(to, INode.QUEEN));
        add(movepromo(to, INode.KNIGHT));
        add(movepromo(to, INode.ROOK));
        add(movepromo(to, INode.BISHOP));
    }

    public int movepromo(int to, int promo) {
        return MoveBitmap.mapPromote(from, to, type | MoveBitmap.updateCastling(type, parent.getCastlingState()),
            promo);
    }

    @Override
    public void capture(int to, int from) {
        int bm = MoveBitmap.mapCreature(from, to,
            type | MoveBitmap.updateCastling(type, parent.getCastlingState()), board[to] & 7);
        add(bm);
    }

    @Override
    public void capturePromote(int to, int from) {
        add(capturepromo(to, INode.QUEEN));
        add(capturepromo(to, INode.KNIGHT));
        add(capturepromo(to, INode.ROOK));
        add(capturepromo(to, INode.BISHOP));
    }

    private int capturepromo(int to, int promo) {
        return MoveBitmap.mapCapturePromote(from, to,
            type | MoveBitmap.updateCastling(type, parent.getCastlingState()), board[to] & 7, promo);
    }

    @Override
    public void enpassant(int to, int from) {
        add(MoveBitmap.mapEnpassant(from, to, type | MoveBitmap.updateCastling(type, parent.getCastlingState())));
    }

    @Override
    public void castling(int to, int from) {
        add(MoveBitmap.mapCastling(from, to, type | MoveBitmap.updateCastling(type, parent.getCastlingState())));
    }

    @Override
    public String toString() {
        return parent.toString();
    }

}