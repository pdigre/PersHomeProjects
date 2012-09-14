package no.pdigre.chess.eval;


public class MoveEval implements Comparable<MoveEval>{
    final int bitmap;
    final int[] board;
    int depth;
    int score;
    
    public MoveEval(int bitmap, int[] board, int depth, int score) {
        super();
        this.bitmap = bitmap;
        this.board = board;
        this.depth = depth;
        this.score = score;
    }

    @Override
    public int compareTo(MoveEval o) {
        return Integer.compare(this.score, o.score);
    }
    
}   
