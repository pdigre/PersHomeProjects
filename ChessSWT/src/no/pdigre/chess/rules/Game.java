package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


public class Game {

	public HashSet<Piece> pieces = new HashSet<Piece>();

	public Stack<Move> log = new Stack<Move>();

	public Game() {
		super();
		newGame();
	}

	public void newGame() {
		log.clear();
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		System.out.println(fen);
		setFen(fen);
	}

	public void setFen(String fen) {
		pieces.clear();
		int y = 56;
		int x = 0;
		for (int i = 0; i < fen.length(); i++) {
			char c = fen.charAt(i);
			if (c == '/') {
				y-=8;
				x = 0;
			} else if (c == ' ') {
				break;
			} else if (c >= '1' && c <= '0') {
				x += Integer.parseInt(String.valueOf(c));
			} else if (c >= 'A' && c <= 'z') {
				pieces.add(Piece.newPiece(x+y, PieceType.getPieceType(c)));
				x++;
			}
		}
	}

	public void move(int from, int to) {
		Piece victim = null;
		for (Piece piece : pieces) {
			if (piece.pos == from) {
				PieceType type=null;
				for (Piece other : pieces) {
					if (other.pos == to){
						victim = other;
						type=other.type;
					}
				}
				piece.move(to);
				log.add(new Move(from, to, piece.type, type));
				System.out.println(getFen());
			}
		}
		if(victim!=null)
			pieces.remove(victim);
	}

	public PieceType[] getCurrentBoard() {
		PieceType[] board = new PieceType[64];
		for (Piece piece : pieces)
			board[piece.pos] = piece.type;
		return board;
	}

	/**
	 * Standard Forsyth–Edwards Notation
	 * 
	 * @return
	 */
	public String getFen() {
		PieceType[] board = getCurrentBoard();
		StringBuilder fen = new StringBuilder();
		for (int y = 8; y-- > 0; ) {
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
		String castling = "";
		for (Piece piece : pieces) {
			switch (piece.type) {
			case WhiteKing:
				if (((WhiteKing) piece).castling)
					castling = "KQ" + castling;
				break;
			case BlackKing:
				if (((BlackKing) piece).castling)
					castling = "kq" + castling;
				break;
			}
		}
		fen.append(" ");
		int n = log.size();
		int side = n % 2;
		fen.append(side == 0 ? "w" : "b");
		fen.append(" ");

		if (castling.isEmpty())
			castling = "-";
		fen.append(castling);
		String passant = "-";
		fen.append(" ");

		if (!log.isEmpty()) {
			Move move = log.peek();
			if (move.type == PieceType.WhitePawn && move.from - move.to == -16)
				passant = coord(move.from + 8);
			if (move.type == PieceType.BlackPawn && move.from - move.to == 16)
				passant = coord(move.from - 8);
		}
		fen.append(passant);
		fen.append(" ");

		int j = n;
		for (; j-- > 0;) {
			Move move = log.get(j);
			if (move.beats != null || move.type == PieceType.WhitePawn
					|| move.type == PieceType.BlackPawn)
				break;
		}
		fen.append(n - j);
		fen.append(" ");
		fen.append((n -side)/ 2 +1);
		fen.append(" ");
		return fen.toString();
	}

	private String coord(int i) {
		int x = i % 8;
		int y = (i - x) / 8;
		return String.valueOf("abcdefgh".charAt(x)) + String.valueOf(y + 1);
	}

	public List<Integer> getMoves(Piece piece) {
        PieceType[] board = getCurrentBoard();
		Move last = log.isEmpty()?null:log.peek();
        List<Integer> moves = new ArrayList<Integer>();
		piece.findMoves(board, moves, last, pieces);
		return moves;
	}

}
