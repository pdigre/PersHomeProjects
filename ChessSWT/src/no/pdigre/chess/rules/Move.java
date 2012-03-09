package no.pdigre.chess.rules;



public class Move {
    PieceType type;
    PieceType beats;
    public int from;
    public int to;
    public Move parent;
    
    public Move(int from, int to, PieceType type, PieceType beats) {
        super();
        this.type = type;
        this.beats = beats;
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        String out = type+" from " + from + " to " + to;
        if(beats!=null)
            out+=" beats "+beats;
        return out;
    }
}
