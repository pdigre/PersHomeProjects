package no.pdigre.chess.rules;


public class EvaluateBoard implements IEvaluator {
	final int[] board;
	final EvalMove eval;

	public EvaluateBoard(final EvalMove eval,final int[] board,Piece piece) {
		this.board = board;
		this.eval = eval;
		evaluate(piece);
	}

	private void evaluate(Piece piece) {
		while (piece != null) {
			final int type = piece.getType();
			PieceType t = PieceType.types[type];
			if(Move.isBlack(type)) {
				bPieceVal -= t.weight;
				PieceType.addAll(type,addblack, board, piece.pos);
			}else {
				wPieceVal += t.weight;
				PieceType.addAll(type,addwhite, board, piece.pos);
			}
			piece = piece.link;
		}
	}


	public boolean isCheck() {
		return wCheck || bCheck;
	}

	public int getScore() {
		return getScoreWhite() - getScoreBlack();
	}

	public boolean wCheck;
	public int wSupport;
	public int wBeat;
	public int wMove;
	public int wPieceVal;

	public int getScoreWhite() {
		return wPieceVal + wMove + 2 * wSupport + 3 * wBeat;
	}

	public boolean bCheck;
	public int bSupport;
	public int bBeat;
	public int bMove;
	public int bPieceVal;

	public int getScoreBlack() {
		return bPieceVal + bMove + 2 * bSupport + 3 * bBeat;
	}

	final IMoves addwhite = new IMoves() {

		@Override
		public void move(int to) {
			wMove++;
		}

		@Override
		public void moveTrade(int to) {
			wMove++;
		}

		@Override
		public void beat(int to) {
			if (board[to] == AbstractMove.BLACK_KING)
				wCheck = true;
			else
				wBeat++;
		}

		@Override
		public void beatTrade(int to) {
			if (board[to] == AbstractMove.BLACK_KING)
				wCheck = true;
			else
				wBeat++;
		}

		@Override
		public void enpassant(int beat) {
			wBeat++;
		}

		@Override
		public void support(int to) {
			wSupport++;
		}

		@Override
		public void castling(int to) {
			// not
		}

		@Override
		public int getEnpassant() {
			return -1;
		}

		@Override
		public int getState() {
			return eval.state;
		}

	};

	final IMoves addblack = new IMoves() {

		@Override
		public void move(int to) {
			bMove++;
		}

		@Override
		public void moveTrade(int to) {
			bMove++;
		}

		@Override
		public void beat(int to) {
			if (board[to] == AbstractMove.KING)
				bCheck = true;
			else
				bBeat++;
		}

		@Override
		public void beatTrade(int to) {
			if (board[to] == AbstractMove.KING)
				bCheck = true;
			else
				bBeat++;
		}

		@Override
		public void enpassant(int beat) {
			bBeat++;
		}

		@Override
		public void support(int to) {
			bSupport++;
		}

		@Override
		public void castling(int to) {
			// not
		}

		@Override
		public int getEnpassant() {
			return -1;
		}

		@Override
		public int getState() {
			return eval.state;
		}

	};

}
