package no.pdigre.chess.eval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.pdigre.chess.base.INode;
import no.pdigre.chess.moves.Move;
import no.pdigre.chess.moves.StartGame;

public class EvalMove {


	public int state;
	public final INode move;
	public float score;

	public EvalMove(int pstate, final Move move) {
		this.move = move;
	}

	public EvalMove(final StartGame move) {
		this.move = move;
	}

	public boolean think(int level) {
		if (level == 0)
			return true;
		int[] board = move.getBoard();
        Collection<Move> moves = FindMoves.getLegalMoves(FindMoves.getMoves(board, move),board, move);
		for (Move mv : new ArrayList<Move>(moves)) {
			EvalMove eval = new EvalMove(state, mv);
			if (!eval.think(level - 1))
				moves.remove(eval);
		}
		return true;
	}

	@Override
	public String toString() {
		EvaluateBoard score = new EvaluateBoard(this, move.getBoard());
		if (score.wCheck || score.bCheck)
			return move.toString() + " check";
		return move.toString();
	}

	public List<Move> getLegalMovesForPiece(int[] board,int pos) {
		ArrayList<Move> moves = getLegalMoves(board);
		ArrayList<Move> list = new ArrayList<Move>();
		for (Move mv : moves) {
            if (mv.getFrom() == pos)
				list.add(mv);
		}
		return list;
	}

	public ArrayList<Move> getLegalMoves(int[] board) {
		Collection<Move> moves = FindMoves.getMoves(board, move);
		ArrayList<Move> lmoves = FindMoves.getLegalMoves(moves,board,move);
		return lmoves;
	}

	public Move move(int from, int to) {
		for (Move mv : FindMoves.getMoves(move.getBoard(), move)) {
			if (mv.getFrom() == from && mv.getTo() == to)
				return mv;
		}
		return null;
	}

}
