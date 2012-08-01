package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.Collection;

public final class Adder implements IAdder {

    private int piece;

    private int type;

    private final ArrayList<Move> next = new ArrayList<Move>();

    private final int[] board;

    private int from;

    private final boolean whiteTurn;
    
    private IMove parent;

    public Adder(int[] board, IMove parent) {
        this.board = board;
        this.whiteTurn = parent.whiteTurn();
        this.parent=parent;
    }

    public void setPiece(int piece){
        this.piece = piece;
        this.type = Move.getType(piece);
        this.from = Move.getPos(piece);
    }
    
    @Override
    public void move(int to) {
    	next.add(new Move(from, to, type, parent));
    }

    @Override
    public void moveTrade(int to) {
    	next.add(new MovePromote(from, to, type, parent,
    			whiteTurn ? IMove.QUEEN
    					: IMove.BLACK_QUEEN));
    	next.add(new MovePromote(from, to, type, parent,
    			whiteTurn ? IMove.KNIGHT
    					: IMove.BLACK_KNIGHT));
    	next.add(new MovePromote(from, to, type, parent,
    			whiteTurn ?IMove.ROOK
    					: IMove.BLACK_ROOK));
    	next.add(new MovePromote(from, to, type, parent,
    			whiteTurn ? IMove.BISHOP
    					: IMove.BLACK_BISHOP));
    }

    @Override
    public void support(int to) {
    	// not
    }

    @Override
    public void beat(int to) {
    	next.add(new Capture(from, to, type, parent, board[to]));
    }

    @Override
    public void beatTrade(int to) {
    	int victim = board[to];
    	next.add(new CapturePromote(from, to, type, parent,
    			victim, whiteTurn ? IMove.QUEEN : IMove.BLACK_QUEEN));
    	next.add(new CapturePromote(from, to, type, parent,
    			victim, whiteTurn ? IMove.KNIGHT : IMove.BLACK_KNIGHT));
    	next.add(new CapturePromote(from, to, type, parent,
    			victim, whiteTurn ? IMove.ROOK : IMove.BLACK_ROOK));
    	next.add(new CapturePromote(from, to, type, parent,
    			victim, whiteTurn ? IMove.BISHOP : IMove.BLACK_BISHOP));
    }

    @Override
    public void enpassant(int to) {
    	int enpassant = getEnpassant();
    	next.add(new EnPassant(from, to, type, parent,
    			board[enpassant - FindMoves.forward(type)]));
    }

    @Override
    public void castling(int to) {
    	next.add(new Castling(from, to, type, parent));
    }

    @Override
    public int getEnpassant() {
    	return parent.getEnpassant();
    }

    @Override
    public int getCastlingState() {
    	return parent.getCastlingState();
    }

    @Override
    public String toString() {
        return PieceType.types[Move.getType(piece)] + " " + Move.pos2string(Move.getType(piece));
    }

    @Override
    public Collection<Move> getMoves() {
        return next;
    }
}