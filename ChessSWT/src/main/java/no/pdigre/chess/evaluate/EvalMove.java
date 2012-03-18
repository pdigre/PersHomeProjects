package no.pdigre.chess.evaluate;

import java.util.ArrayList;
import java.util.List;

import no.pdigre.chess.rules.AbstractMove;
import no.pdigre.chess.rules.Beat;
import no.pdigre.chess.rules.Beat2Knight;
import no.pdigre.chess.rules.Beat2Queen;
import no.pdigre.chess.rules.Castling;
import no.pdigre.chess.rules.EnPassant;
import no.pdigre.chess.rules.IMoves;
import no.pdigre.chess.rules.Move;
import no.pdigre.chess.rules.Move2Knight;
import no.pdigre.chess.rules.Move2Queen;
import no.pdigre.chess.rules.Piece;
import no.pdigre.chess.rules.PieceType;
import no.pdigre.chess.rules.StartGame;

public class EvalMove {

	public AbstractMove move;
	public Piece pieces;
	public PieceType[] board;
	public ArrayList<EvalMove> moves;
	boolean castlingWhiteKing;
	boolean castlingWhiteQueen;
	boolean castlingBlackKing;
	boolean castlingBlackQueen;
	public float score;

	public EvalMove(final EvalMove parent, final Move move) {
		this.move = move;
		this.board = parent.board.clone();
		this.pieces = move.apply(parent.pieces);
		move.apply(board);
		castlingWhiteKing = applyCastling(parent.castlingWhiteKing, PieceType.WHITE_KING);
		castlingWhiteQueen = applyCastling(parent.castlingWhiteQueen, PieceType.WHITE_QUEEN);
		castlingBlackKing = applyCastling(parent.castlingBlackKing, PieceType.BLACK_KING);
		castlingBlackQueen = applyCastling(parent.castlingBlackQueen, PieceType.BLACK_QUEEN);
	}

	public EvalMove(final StartGame move) {
		this.move = move;
		this.board = move.getBoard().clone();
		this.pieces = move.getPieces();
	}

	private boolean applyCastling(boolean castling, PieceType type) {
		return castling && !((Move) move).breakCastle(type);
	}

	public boolean collectMoves() {
		moves = new ArrayList<EvalMove>();
		boolean whiteTurn = move.whiteTurn();
		Piece piece = pieces;
		while (piece != null) {
			final PieceType type = piece.getType();
			final int from = piece.pos;
			if (type.white == whiteTurn) {
				final ArrayList<Move> next = new ArrayList<Move>();
				IMoves adder = new IMoves() {

					@Override
					public void move(int to) {
						next.add(new Move(from, to, type, move));
					}

					@Override
					public void moveTrade(int to) {
						next.add(new Move2Queen(from, to, type, move));
						next.add(new Move2Knight(from, to, type, move));
					}

					@Override
					public void support(int to) {
					}

					@Override
					public void beat(int to) {
						next.add(new Beat(from, to, type, move, board[to]));
					}

					@Override
					public void beatTrade(int to) {
						next.add(new Beat2Queen(from, to, type, move, board[to]));
						next.add(new Beat2Knight(from, to, type, move, board[to]));
					}

					@Override
					public void enpassant(int to) {
						int enpassant = getEnpassant();
						next.add(new EnPassant(from, to, type, move, board[enpassant - type.forward], enpassant));
					}

					@Override
					public void castling(int to) {
						next.add(new Castling(from, to, type, move));
					}

					@Override
					public int getEnpassant() {
						return move.getEnpassant();
					}

					@Override
					public boolean getCastling(PieceType castling) {
						return EvalMove.this.getCastling(castling);
					}

				};
				type.addAll(adder, board, piece.pos);

				// Check King in check position
				for (Move to : next) {
					if (to instanceof Beat) {
						PieceType victim = ((Beat) to).beat;
						if (victim == PieceType.WHITE_KING || victim == PieceType.BLACK_KING)
							return false;
					}
					moves.add(new EvalMove(this, to));
				}
			}
			piece = piece.link;
		}
		return true;
	}

	public boolean think(int level) {
		if (level == 0)
			return true;
		if (moves == null) {
			if (!collectMoves())
				return false;
		}
		for (EvalMove eval : new ArrayList<EvalMove>(moves)) {
			if (!eval.think(level - 1))
				moves.remove(eval);
		}
		return true;
	}

	@Override
	public String toString() {
		EvaluateBoard score = new EvaluateBoard(this);
		if (score.wCheck || score.bCheck)
			return move.toString() + " check";
		return move.toString();
	}


	public List<Integer> getLegalMoves(Piece piece) {
		if (moves == null)
			findLegalMoves();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (EvalMove eval : moves) {
			Move mv = (Move) eval.move;
			if (mv.from == piece.pos)
				list.add(mv.to);
		}
		return list;
	}

	public void findLegalMoves() {
		boolean isok = collectMoves();
		if (isok) {
			for (EvalMove eval : new ArrayList<EvalMove>(moves)) {
				if (!eval.collectMoves())
					moves.remove(eval);
			}
		}
		if (!isok || moves.size() == 0) {
			System.out.println("No moves");
			EvaluateBoard score = new EvaluateBoard(this);
			if (score.wCheck || score.bCheck)
				System.out.println("Check mate!");
			else
				System.out.println("Stale mate!");
		}
	}

	public EvalMove move(int from, int to) {
		for (EvalMove eval : moves) {
			if (((Move) eval.move).from == from && ((Move) eval.move).to == to) {
				eval.findLegalMoves();
				return eval;
			}
		}
		return null;
	}

	public boolean getCastling(PieceType castling) {
		switch (castling) {
		case WHITE_QUEEN:
			return castlingWhiteQueen;
		case WHITE_KING:
			return castlingWhiteKing;
		case BLACK_QUEEN:
			return castlingBlackQueen;
		case BLACK_KING:
			return castlingBlackKing;
		}
		return true;
	}

}
