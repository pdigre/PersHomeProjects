package no.pdigre.chess.evaluate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import no.pdigre.chess.rules.AbstractMove;
import no.pdigre.chess.rules.King;
import no.pdigre.chess.rules.Move;
import no.pdigre.chess.rules.Pawn;
import no.pdigre.chess.rules.Piece;
import no.pdigre.chess.rules.PieceType;

public class EvalMove {

	public AbstractMove move;
	public HashSet<Piece> pieces;
	public PieceType[] board;
	public ArrayList<EvalMove> moves;
	boolean castlingWhiteKing;
	boolean castlingWhiteQueen;
	boolean castlingBlackKing;
	boolean castlingBlackQueen;

	public EvalMove(AbstractMove move) {
		this.move = move;
	}

	@SuppressWarnings("unchecked")
	public void init() {
		this.board = move.getBoard().clone();
		this.pieces = (HashSet<Piece>) move.getPieces().clone();
	}

	@SuppressWarnings("unchecked")
	public void init(EvalMove eval) {
		this.board = eval.board.clone();
		this.pieces = (HashSet<Piece>) eval.pieces.clone();
		((Move) move).applyMove(board);
		((Move) move).applyMove(pieces);
		castlingWhiteKing = applyCastling(eval.castlingWhiteKing, PieceType.WhiteKing);
		castlingWhiteQueen = applyCastling(eval.castlingWhiteQueen, PieceType.WhiteQueen);
		castlingBlackKing = applyCastling(eval.castlingBlackKing, PieceType.BlackKing);
		castlingBlackQueen = applyCastling(eval.castlingBlackQueen, PieceType.BlackQueen);
	}

	private boolean applyCastling(boolean castling, PieceType type) {
		return castling && !((Move) move).breakCastle(type);
	}

	public boolean findMoves() {
		if (board == null)
			init();
		moves = new ArrayList<EvalMove>();
		boolean whiteTurn = move.whiteTurn();
		for (Piece piece : pieces) {
			if (piece.type.white() != whiteTurn)
				continue;
			List<Integer> next = new ArrayList<Integer>();
			if (piece instanceof Pawn) {
				((Pawn) piece).findMoves(board, next, move.getEnpassant(), pieces);
			} else if (piece instanceof King) {
				boolean castleKing = whiteTurn ? castlingWhiteKing : castlingBlackKing;
				boolean castleQueen = whiteTurn ? castlingWhiteQueen : castlingBlackQueen;
				((King) piece).findMoves(board, next, pieces, castleKing, castleQueen);
			} else
				piece.findMoves(board, next, pieces);

			for (int to : next) {
				PieceType victim = board[to];
				if (victim == PieceType.WhiteKing || victim == PieceType.BlackKing)
					return false;
				moves.add(new EvalMove(Move.create(piece.pos, to, piece.type, victim, move)));
			}
		}
		return true;
	}

	public void think() {

	}

	@Override
	public String toString() {
		String basemove = move.toString();
		if (isCheck())
			basemove += " check";
		return basemove;
	}

	public boolean isCheck() {
		boolean white1 = !move.whiteTurn();
		PieceType otherKing = white1 ? PieceType.BlackKing : PieceType.WhiteKing;
		for (Piece piece : pieces) {
			boolean white2 = piece.type.white();
			if (white1 == white2 && piece.type != PieceType.BlackKing && piece.type != PieceType.WhiteKing) {
				ArrayList<Integer> other = new ArrayList<Integer>();
				if (piece instanceof Pawn) {
					((Pawn) piece).findMoves(board, other, move.getEnpassant(), pieces);
				} else if (piece instanceof King) {
				} else {
					piece.findMoves(board, other, pieces);
				}
				for (int move : other) {
					if (board[move] == otherKing)
						return true;
				}
			}
		}
		return false;
	}

	public List<Integer> getMoves(Piece piece) {
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
		boolean isok = findMoves();
		if (isok) {
			for (EvalMove eval : new ArrayList<EvalMove>(moves)) {
				if (!eval.findMoves())
					moves.remove(eval);
			}
		}
		if (!isok || moves.size() == 0) {
			System.out.println("No moves");
			if (isCheck())
				System.out.println("Check mate!");
			else
				System.out.println("Stale mate!");
		}
	}

	public EvalMove move(int from, int to) {
		Piece victim = null;
		for (Piece piece : pieces) {
			if (piece.pos == from) {
				for (Piece other : pieces) {
					if (other.pos == to)
						victim = other;
				}
				Move last = Move.create(from, to, piece.type,victim==null?null:victim.type, move);
				EvalMove lasteval = new EvalMove((Move) last);
				lasteval.init(this);
				lasteval.findLegalMoves();
				return lasteval;
			}
		}
		return this;
	}

}
