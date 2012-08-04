package no.pdigre.chess.eval;

import no.pdigre.chess.base.INode;
import no.pdigre.chess.base.NodeGenerator;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.PieceType;

public final class Move implements INode {

    final private INode parent;

    final private int bitmap;

    protected Move(final INode parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    final public int[] apply(int[] in) {
        return MoveBitmap.apply(in, getBitmap());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int bitmap = getBitmap();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(getFrom()) + " to " + FEN.pos2string(getTo()));
        int capture = ((bitmap >> _CAPTURE) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
        if (isEnpassant())
            sb.append(" enpassant");
        if (isCastling())
            sb.append(" castling");
        int[] board = getBoard();
        if (NodeGenerator.isCheck(board,whiteTurn())) {
            sb.append(" check");
            if (FindMoves.isMate(this, board))
                sb.append("mate");
        }
        return sb.toString();
    }

    @Override
    final public boolean whiteTurn() {
        return (getBitmap() & BLACK) != 0;
    }

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if (whiteTurn())
            i++;
        return i;
    }

    @Override
    final public int halfMoves() {
        return MoveBitmap.halfMoves(getBitmap());
    }

    @Override
    final public int getEnpassant() {
        return MoveBitmap.getEnpassant(getBitmap());
    }


    @Override
    final public int[] getBoard() {
        return apply(parent.getBoard());
    }

    @Override
    final public int getCastlingState() {
        return MoveBitmap.getCastlingState(getBitmap());
    }

    @Override
    public int getBitmap() {
        return bitmap;
    }

    final public int getFrom() {
        return MoveBitmap.getFrom(getBitmap());
    }

    final public int getTo() {
        return MoveBitmap.getTo(getBitmap());
    }

    final public boolean isCapture() {
        return MoveBitmap.isCapture(getBitmap());
    }

    final public boolean isCastling() {
        return MoveBitmap.isCastling(getBitmap());
    }

    final public boolean isEnpassant() {
        return MoveBitmap.isEnpassant(getBitmap());
    }

    final public boolean isPromotion() {
        return MoveBitmap.isPromotion(getBitmap());
    }

}
