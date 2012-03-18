package no.pdigre.chess.rules;


public class StartGame extends AbstractMove {

	String board;
	String castling;
	boolean white;
	int enpassant;
	int halfMoves;
	int fullMoves;
	
	public StartGame(String fen) {
		String[] split=fen.split(" ");
		board = split[0];
		white="w".equalsIgnoreCase(split[1]);
		castling=split[2];
		enpassant=text2pos(split[3]);
		halfMoves=Integer.parseInt(split[4]);
		fullMoves=Integer.parseInt(split[5]);
	}

	public PieceType[] getBoard(){
		return pieces2board(getPieces());
	}
	
	public Piece getPieces() {
		Piece chain = null;
		int y = 56;
		int x = 0;
		for (int i = 0; i < board.length(); i++) {
			char c = board.charAt(i);
			if (c == '/') {
				y-=8;
				x = 0;
			} else if (c == ' ') {
				break;
			} else if (c >= '0' && c <= '9') {
				x += Integer.parseInt(String.valueOf(c));
			} else if (c >= 'A' && c <= 'z') {
				chain=new Piece(PieceType.getPieceType(c),x+y,chain);
				x++;
			}
		}
		return chain;
	}

	@Override
	public boolean canCastle(PieceType type) {
		switch (type) {
		case WHITE_KING:
			return castling.contains("K");
		case WHITE_QUEEN:
			return castling.contains("Q");
		case BLACK_KING:
			return castling.contains("k");
		case BLACK_QUEEN:
			return castling.contains("q");
		}
		return false;
	}

	@Override
	public boolean whiteTurn() {
		return white;
	}
	
	@Override
	public int totalMoves() {
		return fullMoves;
	}
	
	@Override
	public int halfMoves() {
		return halfMoves;
	}

	@Override
	public int getEnpassant() {
		return enpassant;
	}

	
}
