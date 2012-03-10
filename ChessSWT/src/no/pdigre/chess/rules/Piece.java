package no.pdigre.chess.rules;

import java.util.Collection;
import java.util.List;


public abstract class Piece implements Cloneable {

    public int pos;

    public PieceType type;

    public static Piece create(int pos, PieceType type) {
        Piece create = factory(type);
        create.pos=pos;
        create.type=type;
		return create;
    }

	public static Piece factory(PieceType type) {
		switch (type) {
            case WhiteKnight:
            case BlackKnight:
                return new Knight();
            case WhiteBishop:
            case BlackBishop:
                return new Bishop();
            case WhiteRook:
            case BlackRook:
                return new Rook();
            case WhiteQueen:
            case BlackQueen:
                return new Queen();
            case WhiteKing:
                return new WhiteKing();
            case BlackKing:
                return new BlackKing();
            case WhitePawn:
                return new WhitePawn();
            case BlackPawn:
                return new BlackPawn();
        }
        return null;
	}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return create(pos, type);
    }

    public void findMoves(PieceType[] board, List<Integer> moves, Collection<Piece> pieces){
    }

    public void repeatMove(PieceType[] board, List<Integer> moves, int offset) {
        for (int i = pos; addMove(board, moves, offset, i); i += offset)
            ;
    }

    /**
     * Calculate is move is within borders return true if can continue like
     * queen
     * 
     * @param pieces
     * @param moves
     * @param offset
     * @return
     */
    public boolean addMove(PieceType[] board, List<Integer> moves, int offset, int from) {
        int i = from + offset;
        if (!onBoard(i, from))
            return false;

        PieceType type2 = board[i];
        if (type2 != null) {
            if (!sameColor(type2))
                moves.add(i);
            return false;
        }
        moves.add(i);
        return true;
    }

    public boolean addMove(PieceType[] board, List<Integer> moves, int offset) {
        return addMove(board, moves, offset, pos);
    }

    public boolean sameColor(PieceType type2) {
        return (type2.weight > 0) == (type.weight > 0);
    }

    public boolean onBoard(int i, int orig) {
        if (i < 0 || i > 63)
            return false;
        int x1 = i % 8;
        int x2 = orig % 8;
        if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
            return false;
        return true;
    }

    public boolean onBoard(int i) {
        return onBoard(i, pos);
    }

    public void move(int to) {
        pos = to;
    }


}