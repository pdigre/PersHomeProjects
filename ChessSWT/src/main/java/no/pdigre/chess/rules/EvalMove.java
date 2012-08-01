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

	public ArrayList<Move> findMoves(final int[] board, int[] pieces) {
		final ArrayList<Move> moves = new ArrayList<Move>();
		final boolean whiteTurn = move.whiteTurn();
        Adder adder = new Adder(board, move);
		for (final int piece : pieces) {
			final int type = Move.getType(piece);
			if (((type & IMove.ISBLACK) == 0)== whiteTurn) {
			    adder.setPiece(piece);
				FindMoves.addMovesForPiece(type,adder, board, piece);

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
			}
		}
		return moves;
	}

	public boolean think(int level) {
		if (level == 0)
			return true;
		ArrayList<Move> moves = findMoves(move.getBoard(), move.getPieces());
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

	public List<Integer> getLegalMoves(int piece) {
		ArrayList<Move> moves = searchLegalMoves();
		ArrayList<Integer> list = new ArrayList<Integer>();
        int pos = Move.getPos(piece);
		for (Move mv : moves) {
            if (mv.getFrom() == pos)
				list.add(mv.getTo());
		}
		return list;
	}

	public ArrayList<Move> searchLegalMoves() {
		int[] board = move.getBoard();
		int[] pieces = move.getPieces();
		ArrayList<Move> moves = findMoves(board, pieces);
		if ((IMove.ILLEGAL & state) == 0) {
			for (Move mv : new ArrayList<Move>(moves)) {
				EvalMove eval = new EvalMove(state, mv);
				eval.findMoves(mv.getBoard(), mv.getPieces());
				if ((IMove.ILLEGAL & eval.state) != 0)
					moves.remove(mv);
			}
		}
		if ((IMove.ILLEGAL & state) != 0 || moves.size() == 0) {
			System.out.println("No moves");
			EvaluateBoard score = new EvaluateBoard(this, board, pieces);
			if (score.wCheck || score.bCheck)
				System.out.println("Check mate!");
			else
				System.out.println("Stale mate!");
		}
		return moves;
	}

	public Move move(int from, int to) {
		for (Move mv : findMoves(move.getBoard(), move.getPieces())) {
			if (mv.getFrom() == from && mv.getTo() == to)
				return mv;
		}
		return null;
	}

}
