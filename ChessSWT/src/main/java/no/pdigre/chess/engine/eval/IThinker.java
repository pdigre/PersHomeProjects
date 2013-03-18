package no.pdigre.chess.engine.eval;


public interface IThinker {

    final static int MAX=99999;
    final static int MIN=-MAX;
    public int think(int[] board, int inherit, int total, int alpha, int beta);
    public int getBitmap();
    public IThinker getParent();
    public void setParent(IThinker prev);
}
