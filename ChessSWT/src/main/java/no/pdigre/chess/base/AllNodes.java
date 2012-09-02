package no.pdigre.chess.base;


public final class AllNodes implements IAdder {

    int length = 0;

    int[] array = new int[100];

    public static int[] getNodes(final int[] board, int parent) {
        AllNodes adder = new AllNodes();
        NodeGenerator.loopLegalMoves(adder, board, parent);
        int[] ret = new int[adder.length];
        System.arraycopy(adder.array, 0, ret, 0, adder.length);
        return ret;
    }

    private void add(int bitmap) {
        array[length] = bitmap;
        length++;
    }

    @Override
    public void move(int bitmap) {
        add(bitmap);
    }

    @Override
    public void movePromote(int bitmap) {
        add(bitmap);
    }

    @Override
    public void capture(int bitmap) {
        add(bitmap);
    }

    @Override
    public void capturePromote(int bitmap) {
        add(bitmap);
    }

    @Override
    public void enpassant(int bitmap) {
        add(bitmap);
    }

    @Override
    public void castling(int bitmap) {
        add(bitmap);
    }

}