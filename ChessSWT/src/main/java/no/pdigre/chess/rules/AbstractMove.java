package no.pdigre.chess.rules;



public abstract class AbstractMove {

	public final static int PIECETYPE = 7 << 0;
	public final static int ISBLACK = 1 << 3;
	public final static int PIECE = 15 << 0;
	public final static int CAPTURE = 7 << 4;
	public final static int PROMOTE = 7 << 7;
	public final static int ENPASSANT = 1 << 10;
	public final static int CASTLING = 1 << 11;
	public final static int FROM = 63 << 12;
	public final static int TO = 63 << 18;

	// piecetype
	public final static int NONE = 0;
	public final static int PAWN = 1;
	public final static int KNIGHT = 2;
	public final static int BISHOP = 3;
	public final static int ROOK = 4;
	public final static int QUEEN = 5;
	public final static int KING = 6;
	public final static int BLACK_PAWN = PAWN | ISBLACK;
	public final static int BLACK_KNIGHT = KNIGHT | ISBLACK;
	public final static int BLACK_BISHOP = BISHOP | ISBLACK;
	public final static int BLACK_ROOK = ROOK | ISBLACK;
	public final static int BLACK_QUEEN = QUEEN | ISBLACK;
	public final static int BLACK_KING = KING | ISBLACK;

	public abstract int getState();

	public abstract boolean whiteTurn();

	public abstract int totalMoves();

	public abstract int halfMoves();

	public abstract Piece getPieces();

	public abstract int[] getArray();

	public abstract int[] getBoard();

	public abstract int getEnpassant();

	/**
	 * Standard Forsyth–Edwards Notation
	 * 
	 * @return
	 */
	final public String getFen() {
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

	final public String getFenCastling() {
		StringBuilder sb = new StringBuilder();
		int state=getState();
		if ((state & EvalMove.NOCASTLE_WHITEKING)==0)
			sb.append("K");
		if ((state & EvalMove.NOCASTLE_WHITEQUEEN)==0)
			sb.append("Q");
		if ((state & EvalMove.NOCASTLE_BLACKKING)==0)
			sb.append("k");
		if ((state & EvalMove.NOCASTLE_BLACKQUEEN)==0)
			sb.append("q");
		return sb.toString();
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

	final public static String pos2text(int i) {
		if(i<0)
			return "-";
		int x = i % 8;
		int y = (i - x) / 8;
		return String.valueOf("abcdefgh".charAt(x)) + String.valueOf(y + 1);
	}

	final public static int text2pos(String pos) {
		if(pos==null || pos.length()!=2)
			return -1;
		return "abcdefgh".indexOf(pos.charAt(0))+8*(pos.charAt(1)-'1');
	}

	final public static int[] pieces2board(Piece piece) {
		int[] board = new int[64];
		while(piece!=null){
			board[piece.pos] = piece.getType();
			piece=piece.link;
		}
		return board;
	}

	final public Piece getPiece(int pos) {
		int[] board = getBoard();
		int type = board[pos];
		if(type==0)
			return null;
		return new Piece(type,pos,null);
	}

}
