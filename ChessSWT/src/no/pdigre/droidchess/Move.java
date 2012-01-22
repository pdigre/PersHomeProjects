package no.pdigre.droidchess;


public class Move {
    PieceType type;
    PieceType beats;
    int from;
    int to;
    
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
