package no.pdigre.chess.evaluate;

import no.pdigre.chess.rules.IMoves;
import no.pdigre.chess.rules.Piece;
import no.pdigre.chess.rules.PieceType;

public class EvaluateBoard implements IEvaluator {
	final PieceType[] board;
	final EvalMove eval;

	public EvaluateBoard(final EvalMove eval) {
		this.board = eval.board;
		this.eval = eval;
		evaluate();
	}

	private void evaluate() {
		Piece piece = eval.pieces;
		while (piece != null) {
			final PieceType type = piece.getType();
			switch (type) {
			case BLACK_PAWN:
			case BLACK_KING:
			case BLACK_BISHOP:
			case BLACK_KNIGHT:
			case BLACK_QUEEN:
			case BLACK_ROOK:
				bPieceVal -= type.weight;
				type.addAll(addblack, board, piece.pos);
				break;
			case WHITE_PAWN:
			case WHITE_KING:
			case WHITE_BISHOP:
			case WHITE_KNIGHT:
			case WHITE_QUEEN:
			case WHITE_ROOK:
				wPieceVal += type.weight;
				type.addAll(addwhite, board, piece.pos);
				break;
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
			if (board[to] == PieceType.BLACK_KING)
				wCheck = true;
			else
				wBeat++;
		}

		@Override
		public void beatTrade(int to) {
			if (board[to] == PieceType.BLACK_KING)
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
		}

		@Override
		public int getEnpassant() {
			return -1;
		}

		@Override
		public boolean getCastling(PieceType castling) {
			return eval.getCastling(castling);
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
			if (board[to] == PieceType.WHITE_KING)
				bCheck = true;
			else
				bBeat++;
		}

		@Override
		public void beatTrade(int to) {
			if (board[to] == PieceType.WHITE_KING)
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
		}

		@Override
		public int getEnpassant() {
			return -1;
		}

		@Override
		public boolean getCastling(PieceType castling) {
			return eval.getCastling(castling);
		}

	};

}
