package no.pdigre.droidchess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Piece implements Cloneable {

    int pos;

    final PieceType type;

    public static Piece newPiece(int pos, PieceType type) {
        switch (type) {
            case WhiteKnight:
            case BlackKnight:
                return new Knight(pos, type);
            case WhiteBishop:
            case BlackBishop:
                return new Bishop(pos, type);
            case WhiteRook:
            case BlackRook:
                return new Rook(pos, type);
            case WhiteQueen:
            case BlackQueen:
                return new Queen(pos, type);
            case WhiteKing:
                return new WhiteKing(pos, type);
            case BlackKing:
                return new BlackKing(pos, type);
            case WhitePawn:
                return new WhitePawn(pos, type);
            case BlackPawn:
                return new BlackPawn(pos, type);
        }
        return null;
    }

    public Piece(final int pos, final PieceType type) {
        this.pos = pos;
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return newPiece(pos, type);
    }

    public abstract void findMoves(PieceType[] board, List<int[]> moves, Move last, Collection<Piece> pieces);

    public void repeatMove(PieceType[] board, List<int[]> moves, int offset) {
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
    public boolean addMove(PieceType[] board, List<int[]> moves, int offset, int from) {
        int i = from + offset;
        if (!onBoard(i, from))
            return false;

        PieceType type2 = board[i];
        if (type2 != null) {
            if (!sameColor(type2))
                moves.add(new int[] { pos, i });
            return false;
        }
        moves.add(new int[] { pos, i });
        return true;
    }

    public boolean addMove(PieceType[] board, List<int[]> moves, int offset) {
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

    public boolean addKingMove(PieceType[] board, List<int[]> moves, int offset, Collection<Piece> pieces) {
        int i = pos + offset;
        if (!onBoard(i, pos))
            return false;
        PieceType type2 = board[i];
        if (type2 != null) {
            if (!sameColor(type2) && checkKing(board, pieces, i))
                moves.add(new int[] { pos, i });
            return false;
        }
        if (checkKing(board, pieces, i)) {
            moves.add(new int[] { pos, i });
            return true;
        }
        return false;
    }

    public boolean checkKing(PieceType[] board, Collection<Piece> pieces, int i) {
        for (Piece piece : pieces) {
            if (!sameColor(piece.type) && piece.type != PieceType.BlackKing && piece.type != PieceType.WhiteKing) {
                ArrayList<int[]> other = new ArrayList<int[]>();
                piece.findMoves(board, other, null, pieces);
                for (int[] move : other) {
                    if (move[1] == i)
                        return false;
                }
            }
        }
        return true;
    }

}