package no.pdigre.chess.rules;

import java.util.HashSet;

public abstract class AbstractMove {

	public abstract boolean canCastle(PieceType type);

	public abstract boolean whiteTurn();

	public abstract int totalMoves();

	public abstract int halfMoves();

	public abstract HashSet<Piece> getPieces();

	public abstract PieceType[] getBoard();

	public abstract int getEnpassant();

	/**
	 * Standard Forsyth�Edwards Notation
	 * 
	 * @return
	 */
	public String getFen() {
		StringBuilder fen = new StringBuilder();
		fen.append(board2String(getBoard()));
		fen.append(" ");
		fen.append(whiteTurn() ? "w" : "b");
		fen.append(" ");
		fen.append(getFenCastling());
		fen.append(" ");
		fen.append(pos2text(getEnpassant()));
		fen.append(" ");
		fen.append(halfMoves());
		fen.append(" ");
		fen.append(totalMoves());
		return fen.toString();
	}

	public String getFenCastling() {
		StringBuilder sb = new StringBuilder();
		if (canCastle(PieceType.WhiteKing))
			sb.append("K");
		if (canCastle(PieceType.WhiteQueen))
			sb.append("Q");
		if (canCastle(PieceType.BlackKing))
			sb.append("k");
		if (canCastle(PieceType.BlackQueen))
			sb.append("q");
		return sb.toString();
	}

	public String board2String(PieceType[] board) {
		StringBuilder fen = new StringBuilder();
		for (int y = 8; y-- > 0;) {
			int i = 0;
			if (y != 7)
				fen.append("/");
			for (int x = 0; x < 8; x++) {
				PieceType type = board[y * 8 + x];
				if (type == null) {
					i++;
				} else {
					if (i > 0) {
						fen.append(i);
						i = 0;
					}
					fen.append(type.fen);
				}
			}
			if (i > 0)
				fen.append(i);
		}
		return fen.toString();
	}

	public String pos2text(int i) {
		if(i<0)
			return "-";
		int x = i % 8;
		int y = (i - x) / 8;
		return String.valueOf("abcdefgh".charAt(x)) + String.valueOf(y + 1);
	}

	public int text2pos(String pos) {
		if(pos==null || pos.length()!=2)
			return -1;
		return "abcdefgh".indexOf(pos.charAt(0))+8*(pos.charAt(1)-'1');
	}

	public PieceType[] pieces2board(HashSet<Piece> pieces) {
		PieceType[] board = new PieceType[64];
		for (Piece piece : pieces)
			board[piece.pos] = piece.type;
		return board;
	}

}
