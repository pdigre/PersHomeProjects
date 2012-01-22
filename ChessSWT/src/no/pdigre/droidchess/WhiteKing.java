package no.pdigre.droidchess;

import java.util.Collection;
import java.util.List;

public class WhiteKing extends Piece {

    boolean castling = true;

    WhiteKing(int pos, PieceType type) {
        super(pos, type);
    }

    @Override
    public void move(int to) {
        super.move(to);
        castling = false;
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
            if (right && board[6] == null && board[7] == PieceType.WhiteRook)
                addKingMove(board, moves, 2, pieces);
            if (left && board[2] == null && board[1] == null && board[0] == PieceType.WhiteRook)
                addKingMove(board, moves, -2, pieces);
        }
    }

}
