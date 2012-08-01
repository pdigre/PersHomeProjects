package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EvalMove {


	public int state;
	public final IMove move;
	public float score;

	public EvalMove(int pstate, final Move move) {
		this.move = move;
		if (move != null)
			state = move.breakCastle(pstate & 15);
	}

	public EvalMove(final StartGame move) {
		this.move = move;
	}

	public ArrayList<Move> getMoves(final int[] board, int[] pieces) {
		final ArrayList<Move> moves = new ArrayList<Move>();
		final boolean whiteTurn = move.whiteTurn();
        Adder adder = new Adder(board, move);
		for (final int piece : pieces) {
			final int type = Move.getType(piece);
			if (FindMoves.white(type)== whiteTurn) {
			    adder.setPiece(piece);
				FindMoves.addMovesForPiece(adder, board, piece);

			}
		}
		// Check King in check position
		Collection<Move> moves2 = adder.getMoves();
        for (Move to : moves2) {
			if (to instanceof Capture) {
				int victim = (to.bitmap>>4)&7;
				if (victim == IMove.KING) {
					state |= IMove.ILLEGAL;
					return moves;
				}
			}
			moves.add(to);
		}
		return moves;
	}

	public boolean think(int level) {
		if (level == 0)
			return true;
		ArrayList<Move> moves = getMoves(move.getBoard(), move.getPieces());
		if ((state & IMove.ILLEGAL) != 0)
			return false;
		for (Move mv : new ArrayList<Move>(moves)) {
			EvalMove eval = new EvalMove(state, mv);
			if (!eval.think(level - 1))
				moves.remove(eval);
		}
		return true;
	}

	@Override
	public String toString() {
		EvaluateBoard score = new EvaluateBoard(this, move.getBoard(),
				move.getPieces());
		if (score.wCheck || score.bCheck)
			return move.toString() + " check";
		return move.toString();
	}

	public List<Move> getLegalMovesForPiece(int piece) {
		ArrayList<Move> moves = getLegalMoves();
		ArrayList<Move> list = new ArrayList<Move>();
        int pos = Move.getPos(piece);
		for (Move mv : moves) {
            if (mv.getFrom() == pos)
				list.add(mv);
		}
		return list;
	}

	public ArrayList<Move> getLegalMoves() {
		int[] board = move.getBoard();
		int[] pieces = move.getPieces();
		ArrayList<Move> moves = getMoves(board, pieces);
		ArrayList<Move> lmoves = getLegalMoves(moves,board, pieces);
		if (!legal() || lmoves.size() == 0) {
			System.out.println("No moves");
			EvaluateBoard score = new EvaluateBoard(this, board, pieces);
			if (score.wCheck || score.bCheck)
				System.out.println("Check mate!");
			else
				System.out.println("Stale mate!");
		}
		return lmoves;
	}

	private ArrayList<Move> getLegalMoves(ArrayList<Move> moves, int[] board, int[] pieces) {
		ArrayList<Move> lmoves = new ArrayList<Move>();
		if (legal()) {
			for (Move mv : moves) {
				if (checkLegal(mv,mv.applyBoard(board), mv.applyPieces(pieces)))
					lmoves.add(mv);
			}
		}
		return lmoves;
	}

	private boolean legal() {
		return (IMove.ILLEGAL & state) == 0;
	}

	private boolean checkLegal(Move mv, int[] board, int[] pieces) {
		EvalMove eval = new EvalMove(state, mv);
		eval.getMoves(board, pieces);
		return eval.legal();
	}

	public Move move(int from, int to) {
		for (Move mv : getMoves(move.getBoard(), move.getPieces())) {
			if (mv.getFrom() == from && mv.getTo() == to)
				return mv;
		}
		return null;
	}

}
