package no.pdigre.droidchess;

import java.util.Collection;
import java.util.List;


public class BlackPawn extends Piece {

    BlackPawn(int pos, PieceType type) {
        super(pos, type);
    }

    @Override
    public void findMoves(PieceType[] board, List<int[]> moves, Move last, Collection<Piece> pieces) {
    int forward = pos - 8;
    if (onBoard(forward)) {
        if (board[forward] == null) {
            moves.add(new int[]{pos,forward});
            if (pos > 47 && pos < 56) {
                int forward2 = pos + 16;
                if (onBoard(forward2)) {
                    if (board[forward2] == null)
                        moves.add(new int[]{pos,forward2});
                }
            }
        }
    }
    int left = pos - 7;
    if (onBoard(left)) {
        PieceType piece = board[left];
        if (piece != null) {
            if (!sameColor(piece))
                moves.add(new int[] { pos, left });
        } else {
            if (last != null && last.from == left - 8 && last.to == left + 8)
                moves.add(new int[] { pos, left });
        }
    }
    int right = pos - 9;
    if (onBoard(right)) {
        PieceType piece = board[right];
        if (piece != null) {
            if (!sameColor(piece))
                moves.add(new int[] { pos, right });
        } else {
            if (last != null && last.from == right - 8 && last.to == right + 8)
                moves.add(new int[] { pos, right });
        }
    }
}

}
