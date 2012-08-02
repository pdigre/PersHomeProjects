package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;

import no.pdigre.chess.base.FindNodes;
import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.INode;
import no.pdigre.chess.moves.FEN;
import no.pdigre.chess.moves.Move;
import no.pdigre.chess.moves.PieceType;

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
        next.add(Move.createMovePromote(from, to, parent, type, whiteTurn ? INode.QUEEN : INode.BLACK_QUEEN));
        next.add(Move.createMovePromote(from, to, parent, type, whiteTurn ? INode.KNIGHT : INode.BLACK_KNIGHT));
        next.add(Move.createMovePromote(from, to, parent, type, whiteTurn ? INode.ROOK : INode.BLACK_ROOK));
        next.add(Move.createMovePromote(from, to, parent, type, whiteTurn ? INode.BISHOP : INode.BLACK_BISHOP));
    }

    @Override
    public void support(int to) {
        // not
    }

    @Override
    public void capture(int to) {
        next.add(Move.createCapture(from, to, parent, type, board[to]));
    }

    @Override
    public void capturePromote(int to) {
        int victim = board[to];
        next.add(Move.createCapturePromote(from, to, parent, type, victim, whiteTurn ? INode.QUEEN : INode.BLACK_QUEEN));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, whiteTurn ? INode.KNIGHT : INode.BLACK_KNIGHT));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, whiteTurn ? INode.ROOK : INode.BLACK_ROOK));
        next.add(Move.createCapturePromote(from, to, parent, type, victim, whiteTurn ? INode.BISHOP : INode.BLACK_BISHOP));
    }

    @Override
    public void enpassant(int to) {
        int enpassant = parent.getEnpassant();
        next.add(Move.createEnPassant(from, to, parent, type, board[enpassant - FindNodes.forward(FindNodes.white(type))]));
    }

    @Override
    public void castling(int to) {
        next.add(Move.createCastling(from, to, parent, type));
    }

    @Override
    public String toString() {
        return PieceType.types[type] + " " + FEN.pos2string(from);
    }
}