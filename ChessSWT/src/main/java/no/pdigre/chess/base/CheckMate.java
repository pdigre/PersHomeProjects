package no.pdigre.chess.base;

public class CheckMate implements IAdder {

    private boolean hasMoves;

    public static boolean isMate(int bitmap, int[] board) {
        CheckMate inst = new CheckMate();
        NodeGenerator.loopLegalMoves(inst, board, bitmap);
        return !inst.hasMoves;
    }

    @Override
    public void move(int bitmap) {
        hasmoves();
    }

    private boolean hasmoves() {
        return hasMoves = true;
    }

    @Override
    public void movePromote(int bitmap) {
        hasmoves();
    }

    @Override
    public void capture(int bitmap) {
        hasmoves();
    }

    @Override
    public void capturePromote(int bitmap) {
        hasmoves();
    }

    @Override
    public void castling(int bitmap) {
        hasmoves();
    }

    @Override
    public void enpassant(int bitmap) {
        hasmoves();
    }
}
