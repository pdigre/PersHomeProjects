package no.pdigre.chess.moves;

import no.pdigre.chess.base.INode;

public class FEN {

	/**
	 * Standard Forsyth–Edwards Notation
	 * 
	 * @return
	 */
	final public static String getFen(INode move) {
		StringBuilder fen = new StringBuilder();
		fen.append(FEN.board2String(move.getBoard()));
		fen.append(" ");
		fen.append(move.whiteTurn() ? "w" : "b");
		fen.append(" ");
		fen.append(FEN.getFenCastling(move));
		fen.append(" ");
		fen.append(FEN.pos2string(move.getEnpassant()));
		fen.append(" ");
		fen.append(move.halfMoves());
		fen.append(" ");
		fen.append(move.totalMoves());
		return fen.toString();
	}

    final public static String pos2string(int pos) {
        if (pos == -1)
            return "-";
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefgh".charAt(pos & 7));
        sb.append("12345678".charAt(pos >> 3));
        return sb.toString();
    }


	final public static int text2pos(String pos) {
		if (pos == null || pos.length() != 2)
			return -1;
		return "abcdefgh".indexOf(pos.charAt(0)) + 8 * (pos.charAt(1) - '1');
	}

	final public static int[] array2board(int[] pieces) {
		int[] board = new int[64];
		for (int piece : pieces)
			board[Move.getPos(piece)] = Move.getType(piece);
		return board;
	}

	final public static String board2String(int[] board) {
		StringBuilder fen = new StringBuilder();
		for (int y = 8; y-- > 0;) {
			int i = 0;
			if (y != 7)
				fen.append("/");
			for (int x = 0; x < 8; x++) {
				PieceType type = PieceType.types[board[y * 8 + x]];
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

	final public static String getFenCastling(INode move) {
		StringBuilder sb = new StringBuilder();
		int state = move.getCastlingState();
		if ((state & INode.NOCASTLE_WHITEKING) == 0)
			sb.append("K");
		if ((state & INode.NOCASTLE_WHITEQUEEN) == 0)
			sb.append("Q");
		if ((state & INode.NOCASTLE_BLACKKING) == 0)
			sb.append("k");
		if ((state & INode.NOCASTLE_BLACKQUEEN) == 0)
			sb.append("q");
		return sb.toString();
	}

	public static void printBoard(int[] board) {
		StringBuffer sb = new StringBuffer();
		for (int y = 56; y >= 0; y -= 8) {
			for (int x = 0; x < 8; x++) {
				PieceType type = PieceType.types[board[x + y]];
				sb.append(type == null ? "." : type.fen);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void printPiece(int type,int pos) {
		PieceType pt = PieceType.types[type];
        System.out.println(pt==null?"<none>":pt.toString()
				+ " " + pos2string(pos));
	}

}
