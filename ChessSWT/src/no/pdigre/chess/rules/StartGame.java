package no.pdigre.chess.rules;

import java.util.HashSet;

public class StartGame extends AbstractMove {

	String board;
	String castling;
	boolean white;
	int enpassant;
	int halfMoves;
	int fullMoves;
	
	protected StartGame(String fen) {
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
	
	public HashSet<AbstractPiece> getPieces() {
		HashSet<AbstractPiece> pieces = new HashSet<AbstractPiece>();
		int y = 56;
		int x = 0;
		for (int i = 0; i < board.length(); i++) {
			char c = board.charAt(i);
			if (c == '/') {
				y-=8;
				x = 0;
			} else if (c == ' ') {
				break;
			} else if (c >= '1' && c <= '0') {
				x += Integer.parseInt(String.valueOf(c));
			} else if (c >= 'A' && c <= 'z') {
				pieces.add(PieceType.getPieceType(c).create(x+y));
				x++;
			}
		}
		return pieces;
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
	
	public static StartGame newGame() {
		return new StartGame("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
	}

	
}
