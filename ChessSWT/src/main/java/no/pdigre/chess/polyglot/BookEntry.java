package no.pdigre.chess.polyglot;

import java.util.ArrayList;


public class BookEntry {
    public class BookMove{
        public BookMove(int move, int weight) {
            this.move=move;
            this.weight=weight;
        }
        public int move;
        public int weight;
    }
    
    final long zobrist;
    public ArrayList<BookMove> moves=new ArrayList<BookMove>();
    
    public BookEntry(long zobrist) {
        super();
        this.zobrist = zobrist;
    }
    
    public void addMove(int move,int weight){
        moves.add(new BookMove(move,weight));
    }
    
    @Override
    public int hashCode() {
        return (int) zobrist;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BookEntry)
            return ((BookEntry) obj).zobrist==zobrist;
        return super.equals(obj);
    }
}
