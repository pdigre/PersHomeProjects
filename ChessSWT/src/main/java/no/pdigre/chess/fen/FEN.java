package no.pdigre.chess.fen;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.base.NodePull;

public class FEN implements IConst{

	/**
	 * Standard Forsyth–Edwards Notation
	 * 
	 * @return
	 */
	final public static String getFen(IPosition move) {
		StringBuilder fen = new StringBuilder();
		fen.append(FEN.board2String(move.getBoard()));
		fen.append(" ");
		fen.append(move.whiteTurn() ? "w" : "b");
		fen.append(" ");
		fen.append(FEN.getFenCastling(move));
		fen.append(" ");
		fen.append(FEN.pos2string(Bitmap.getEnpassant(move.getInherit())));
		fen.append(" ");
		fen.append(Bitmap.halfMoves(move.getInherit()));
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

	final public static String getFenCastling(IPosition move) {
		StringBuilder sb = new StringBuilder();
		int state = Bitmap.getCastlingState(move.getInherit());
		if ((state & IConst.NOCASTLE_WHITEKING) == 0)
			sb.append("K");
		if ((state & IConst.NOCASTLE_WHITEQUEEN) == 0)
			sb.append("Q");
		if ((state & IConst.NOCASTLE_BLACKKING) == 0)
			sb.append("k");
		if ((state & IConst.NOCASTLE_BLACKQUEEN) == 0)
			sb.append("q");
		return sb.toString();
	}

	public static String printBoard(int[] board) {
		StringBuffer sb = new StringBuffer();
		for (int y = 56; y >= 0; y -= 8) {
			for (int x = 0; x < 8; x++) {
				PieceType type = PieceType.types[board[x + y]];
				sb.append(type == null ? "." : type.fen);
			}
			sb.append("\n");
		}
		return  sb.toString();
	}

	public static void printPiece(int type,int pos) {
		PieceType pt = PieceType.types[type];
        System.out.println(pt==null?"<none>":pt.toString()
				+ " " + pos2string(pos));
	}


    public static String printMove(int bitmap, int[] board) {
        StringBuilder sb = new StringBuilder();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(Bitmap.getFrom(bitmap)) + " to "
            + FEN.pos2string(Bitmap.getTo(bitmap)));
        int capture = ((bitmap >> _CAPTURE) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
        if (Bitmap.isEnpassant(bitmap))
            sb.append(" enpassant");
        if (Bitmap.isCastling(bitmap))
            sb.append(" castling");
        boolean white = Bitmap.white(bitmap);
        if (!NodePull.checkSafe(board, NodePull.getKingPos(board, white), white)) {
            sb.append(" check");
            if (!(new NodePull(board, bitmap).next()!=0))
                sb.append("mate");
        }
        return sb.toString();
    }


}
