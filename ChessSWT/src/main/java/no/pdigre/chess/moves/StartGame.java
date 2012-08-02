package no.pdigre.chess.moves;

import no.pdigre.chess.base.FindNodes;
import no.pdigre.chess.base.INode;

public class StartGame implements INode {

	private final String castling;
	private final boolean white;
	private final int enpassant;
	private final int halfMoves;
	private final int fullMoves;
	private final int[] board;

	public StartGame(String fen) {
		String[] split = fen.split(" ");
		board = getBoard(split[0]);
		white = "w".equalsIgnoreCase(split[1]);
		castling = split[2];
		enpassant = FEN.text2pos(split[3]);
		halfMoves = Integer.parseInt(split[4]);
		fullMoves = Integer.parseInt(split[5]);
	}

	public static int[] getBoard(String fen_board) {
        int[] board = new int[64];
        int y = 56;
        int x = 0;
        for (int i = 0; i < fen_board.length(); i++) {
        	char c = fen_board.charAt(i);
        	if (c == '/') {
        		y -= 8;
        		x = 0;
        	} else if (c == ' ') {
        		break;
        	} else if (c >= '0' && c <= '9') {
        		x += Integer.parseInt(String.valueOf(c));
        	} else if (c >= 'A' && c <= 'z') {
                board[x + y]=FindNodes.getPieceType(c).bitmap;
        		x++;
        	}
        }
        return board;
	}

	@Override
	public int[] getBoard() {
	    return board;
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
	public int getCastlingState() {
		return (castling.contains("K") ? 0 : INode.NOCASTLE_WHITEKING)
				| (castling.contains("Q") ? 0 : INode.NOCASTLE_WHITEQUEEN)
				| (castling.contains("k") ? 0 : INode.NOCASTLE_BLACKKING)
				| (castling.contains("q") ? 0 : INode.NOCASTLE_BLACKQUEEN);
	}

}
