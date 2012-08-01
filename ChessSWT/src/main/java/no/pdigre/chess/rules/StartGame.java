package no.pdigre.chess.rules;

import java.util.ArrayList;


public class StartGame extends AbstractMove {

	private final String board;
	private final String castling;
	private final boolean white;
	private final int enpassant;
	private final int halfMoves;
	private final int fullMoves;

	public StartGame(String fen) {
		String[] split = fen.split(" ");
		board = split[0];
		white = "w".equalsIgnoreCase(split[1]);
		castling = split[2];
		enpassant = text2pos(split[3]);
		halfMoves = Integer.parseInt(split[4]);
		fullMoves = Integer.parseInt(split[5]);
	}

	@Override
	public int[] getBoard() {
		return pieces2board(getPieces());
	}

	@Override
	public Piece getPieces() {
		Piece chain = null;
		int y = 56;
		int x = 0;
		for (int i = 0; i < board.length(); i++) {
			char c = board.charAt(i);
			if (c == '/') {
				y -= 8;
				x = 0;
			} else if (c == ' ') {
				break;
			} else if (c >= '0' && c <= '9') {
				x += Integer.parseInt(String.valueOf(c));
			} else if (c >= 'A' && c <= 'z') {
				chain = new Piece(PieceType.getPieceType(c).bitmap, x + y, chain);
				x++;
			}
		}
		return chain;
	}

	@Override
	public int[] getArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int y = 56;
		int x = 0;
		for (int i = 0; i < board.length(); i++) {
			char c = board.charAt(i);
			if (c == '/') {
				y -= 8;
				x = 0;
			} else if (c == ' ') {
				break;
			} else if (c >= '0' && c <= '9') {
				x += Integer.parseInt(String.valueOf(c));
			} else if (c >= 'A' && c <= 'z') {
				int type = PieceType.getPieceType(c).bitmap | ((x + y)<<12);
				list.add(type);
				x++;
			}
		}
		int[] array=new int[list.size()];
		for (int i = 0; i < array.length; i++) {
			array[i]=list.get(i);
		}
		return array;
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

	@Override
	public int getState() {
		return (castling.contains("K") ? 0 : EvalMove.NOCASTLE_WHITEKING)
				| (castling.contains("Q") ? 0 : EvalMove.NOCASTLE_WHITEQUEEN)
				| (castling.contains("k") ? 0 : EvalMove.NOCASTLE_BLACKKING)
				| (castling.contains("q") ? 0 : EvalMove.NOCASTLE_BLACKQUEEN);
	}

}
