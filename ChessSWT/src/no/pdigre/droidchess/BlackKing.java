package no.pdigre.droidchess;

import java.util.Collection;
import java.util.List;


public class BlackKing extends Piece {

    boolean castling=true;
    BlackKing(int pos, PieceType type) {
        super(pos, type);
    }

    @Override
    public void findMoves(PieceType[] board, List<int[]> moves, Move last, Collection<Piece> pieces) {
        boolean right = addKingMove(board, moves, 1, pieces);
        boolean left = addKingMove(board, moves, -1, pieces);
        addKingMove(board, moves, 8, pieces);
        addKingMove(board, moves, -8,pieces);
        addKingMove(board, moves, 7,pieces);
        addKingMove(board, moves, 9,pieces);
        addKingMove(board, moves, -7,pieces);
        addKingMove(board, moves, -9,pieces);
        if (castling) {
            if(right && board[62]==null && board[63]==PieceType.BlackRook)
                addKingMove(board, moves, 2, pieces);
            if(left && board[58]==null && board[57]==null && board[56]==PieceType.BlackRook)
                addKingMove(board, moves, -2, pieces);
        }
    }
    
    @Override
    public void move(int to) {
        super.move(to);
        castling=false;
    }
}
