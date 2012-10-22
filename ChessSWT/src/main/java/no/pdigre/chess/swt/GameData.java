package no.pdigre.chess.swt;

import java.util.ArrayList;


import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.eval.MoveEval;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;

public class GameData {
	public int[] draw_targets = new int[64];

	public int[] draw_score = new int[64];

	public int best_from;
	public int best_to;

	public int[] board;

	public Integer from = -1;


	public IPosition lastmove;

	AlphaBeta eval;

	public void setup(IPosition startGame) {
		lastmove = startGame;
		board = lastmove.getBoard();
		from = -1;
	}

	public void analyzeMarkers() {
		eval = new AlphaBeta(lastmove.getBoard(),
				lastmove.getInherit(), 5);
		System.out.println(FEN.getFen(lastmove));
		draw_targets = new int[64];
		draw_score = new int[64];
		MoveEval[] moves = eval.moves;
		int best = moves[0].bitmap;
		best_from = Bitmap.getFrom(best);
		best_to = Bitmap.getTo(best);
		for (MoveEval move : moves) {
			int from = Bitmap.getFrom(move.bitmap);
			if (draw_score[from] == 0)
				draw_score[from] = move.score;
		}
	}

	public void markToMoves(int i) {
		int[] bitmaps = eval.getBitmaps();
		from = i;
		draw_targets = new int[64];
		draw_score = new int[64];
		int[] movesfrom = NodeGen.filterFrom(bitmaps, i);
		for (int bitmap : movesfrom) {
			int to = Bitmap.getTo(bitmap);
			draw_targets[to] = Bitmap.type(bitmap);
			System.out.println("\n==" + FEN.printMove(bitmap, board));
			draw_score[to] = eval.getMove(bitmap).score;
		}
	}

	public void makeMove(int i) {
		setup(new Move(lastmove, NodeGen.filterTo(
				NodeGen.filterFrom(eval.getBitmaps(), from), i)[0]));
	}

	public ArrayList<Marking> markPiecesThatCanMove() {
		ArrayList<Marking> list = new ArrayList<Marking>();
		MoveEval[] moves = eval.moves;
		int best = Bitmap.getFrom(moves[0].bitmap);
		for (MoveEval move : moves) {
			int fr = Bitmap.getFrom(move.bitmap);
			list.add(new Marking(fr == best ? MarkingType.BestMoveFrom
					: MarkingType.MoveFrom, fr));
		}
		return list;
	}

	public ArrayList<Marking> markMovesForPiece() {
		ArrayList<Marking> list=new ArrayList<Marking>();
		MoveEval[] moves = eval.moves;
		list.add(new Marking(MarkingType.MoveFrom,from));
		for (MoveEval move : moves) {
			if (Bitmap.getFrom(move.bitmap) == from) {
				int to = Bitmap.getTo(move.bitmap);
				list.add(new Marking(MarkingType.MoveTo,to,move.score));
			}
		}
		return list;
	}

}
