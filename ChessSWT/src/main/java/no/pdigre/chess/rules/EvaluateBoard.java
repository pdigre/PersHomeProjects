package no.pdigre.chess.rules;



public class EvaluateBoard implements IEvaluator {
	final int[] board;
	final EvalMove eval;

	public EvaluateBoard(final EvalMove eval,final int[] board,int[] pieces) {
		this.board = board;
		this.eval = eval;
		evaluate(pieces);
	}

	private void evaluate(int[] pieces) {
	    for (int piece : pieces) {
			final int type = Move.getType(piece);
			PieceType t = PieceType.types[type];
			if(t==null)
			    throw new AssertionError("null");
			if(Move.isBlack(type)) {
				bPieceVal -= t.weight;
				FindMoves.addMovesForPiece(addblack, board, piece);
			}else {
				wPieceVal += t.weight;
				FindMoves.addMovesForPiece(addwhite, board, piece);
			}
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

	final IAdder addwhite = new IAdder() {

		@Override
		public void move(int to) {
			wMove++;
		}

		@Override
		public void movePromote(int to) {
			wMove++;
		}

		@Override
		public void beat(int to) {
			if (board[to] == IMove.BLACK_KING)
				wCheck = true;
			else
				wBeat++;
		}

		@Override
		public void capturePromote(int to) {
			if (board[to] == IMove.BLACK_KING)
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
		public int getCastlingState() {
			return eval.state;
		}

	};

	final IAdder addblack = new IAdder() {

		@Override
		public void move(int to) {
			bMove++;
		}

		@Override
		public void movePromote(int to) {
			bMove++;
		}

		@Override
		public void beat(int to) {
			if (board[to] == IMove.KING)
				bCheck = true;
			else
				bBeat++;
		}

		@Override
		public void capturePromote(int to) {
			if (board[to] == IMove.KING)
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
		public int getCastlingState() {
			return eval.state;
		}

  	};

}
