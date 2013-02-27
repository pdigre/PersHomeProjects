package no.pdigre.chess.engine.eval;


public interface IThinker {

    public abstract int run(int[] board, int inherit, int depth);

}
