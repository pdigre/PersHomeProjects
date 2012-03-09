package no.pdigre.chess.evaluate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import no.pdigre.chess.rules.Move;
import no.pdigre.chess.rules.Piece;
import no.pdigre.chess.rules.PieceType;

public class EvalMove extends Move{

	public Move move;
	public HashSet<Piece> pieces = new HashSet<Piece>();
	public PieceType[] board;
	public ArrayList<EvalMove> moves = new ArrayList<EvalMove>();
	
	public EvalMove(int from, int to, PieceType type, PieceType beats) {
		super(from, to, type, beats);
	}
	
	public void findMoves() {
		for (Piece piece : pieces) {
	        List<Integer> next = new ArrayList<Integer>();
			piece.findMoves(board, next, move.parent, pieces);
			for (int to : next)
				moves.add(new EvalMove(piece.pos, to, piece.type, board[to]));
		}
	}
}
