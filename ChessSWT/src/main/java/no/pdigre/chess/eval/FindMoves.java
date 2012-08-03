package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.pdigre.chess.base.FindNodes;
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
            if (type != 0 && FindNodes.white(type) == adder.whiteTurn) {
                adder.type = type;
                adder.from = i;
                FindNodes.addMovesForPiece(adder, board, i, type, enpassant, castling);
            }
        }
        return adder.next;
    }
    
    public static List<Move> filterPieces(Collection<Move> moves,int from) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (mv.getFrom() == from)
                list.add(mv);
        }
        return list;
    }

    public static List<Move> filterPieces(Collection<Move> moves,int from,int to) {
        ArrayList<Move> list = new ArrayList<Move>();
        for (Move mv : moves) {
            if (mv.getFrom() == from && mv.getTo()==to)
                list.add(mv);
        }
        return list;
    }

    public static ArrayList<Move> getLegalMoves(final INode parent) {
        return getLegalMoves(parent.getBoard(), parent);
    }

    public static ArrayList<Move> getLegalMoves(int[] board,final INode parent) {
        return getLegalMoves(getMoves(board, parent), board, parent);
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
            if (FindNodes.checkSafe(mv.apply(board), pos, white))
                lmoves.add(mv);
        }
        return lmoves;
    }

    public static boolean isMate(INode move, int[] board) {
        return FindMoves.getLegalMoves(FindMoves.getMoves(board, move),board, move).isEmpty();
    }

    public static boolean isCheck(INode move, int[] board) {
        boolean white = move.whiteTurn();
        int enemyking = white?INode.KING:INode.BLACK_KING;
        int kingpos = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == enemyking) {
                kingpos = i;
                break;
            }
        }
        return !FindNodes.checkSafe(board, kingpos, white);
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
    public void move(int to) {
        next.add(Move.createMove(from, to, parent, type));
    }

    @Override
    public void movePromote(int to) {
        next.add(Move.createMovePromote(from, to, parent, type, INode.QUEEN));
        next.add(Move.createMovePromote(from, to, parent, type, INode.KNIGHT));
        next.add(Move.createMovePromote(from, to, parent, type, INode.ROOK));
        next.add(Move.createMovePromote(from, to, parent, type, INode.BISHOP));
    }

    @Override
    public void support(int to) {
        // not
    }

    @Override
    public void capture(int to) {
        next.add(Move.createCapture(from, to, parent, type, board[to] & 7));
    }

    @Override
    public void capturePromote(int to) {
        int victim = board[to] & 7;
        next.add(Move.createCapturePromote(from, to, parent, type, victim, INode.QUEEN));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, INode.KNIGHT));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, INode.ROOK));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, INode.BISHOP));
    }

    @Override
    public void enpassant(int to) {
        next.add(Move.createEnPassant(from, to, parent, type));
    }

    @Override
    public void castling(int to) {
        next.add(Move.createCastling(from, to, parent, type));
    }

    @Override
    public String toString() {
        return parent.toString();
    }
}