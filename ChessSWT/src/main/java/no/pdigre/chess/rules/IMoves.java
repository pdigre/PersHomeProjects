package no.pdigre.chess.rules;

public interface IMoves {
	
	
	
	
	
	
	// Moves relative
	public final static int UP=8;
	public final static int DOWN=-8;
	public final static int LEFT=-1;
	public final static int RIGHT=1;
	// Castling positions
	public final static int CST_WK=5;
	public final static int CST_WQ=2;
	public final static int CST_BK=61;
	public final static int CST_BQ=58;
	
	public abstract void move(final int to); 
	public abstract void moveTrade(final int to);
	public abstract void beat(final int to);
	public abstract void beatTrade(final int to);
	public abstract void support(final int to); 
	public abstract void castling(final int to); 
	public abstract void enpassant(final int to);
	public abstract int getEnpassant();
	public abstract int getState();
}
