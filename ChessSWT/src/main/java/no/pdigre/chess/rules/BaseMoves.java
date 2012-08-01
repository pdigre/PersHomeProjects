package no.pdigre.chess.rules;

import java.util.ArrayList;

public class BaseMoves {
	
    final public static int LEFT = -1;

    final public static int RIGHT = 1;

    final public static int UP = 8;

    final public static int DOWN = -8;

	final static int[][] KNIGHT_MOVES = new int[64][];
	static {
		for (int i = 0; i < 64; i++) {
			KNIGHT_MOVES[i] = getKnightMoves(i);
		}
	}

	private static int[] getKnightMoves(int from) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		add(moves, from, UP + LEFT + LEFT);
		add(moves, from, UP + UP + LEFT);
		add(moves, from, UP + RIGHT + RIGHT);
		add(moves, from, UP + UP + RIGHT);
		add(moves, from, DOWN + LEFT + LEFT);
		add(moves, from, DOWN + DOWN + LEFT);
		add(moves, from, DOWN + RIGHT + RIGHT);
		add(moves, from, DOWN + DOWN + RIGHT);
		return toArray(moves);
	}

	public final static int[][][] ROOK_MOVES = new int[64][][];
	static {
		for (int i = 0; i < 64; i++) {
			ROOK_MOVES[i] = getRookMoves(i);
		}
	}

	private static int[][] getRookMoves(int from) {
		ArrayList<int[]> slide = new ArrayList<int[]>();
		slide(slide, from, UP);
		slide(slide, from, DOWN);
		slide(slide, from, LEFT);
		slide(slide, from, RIGHT);
		return toArray2(slide);
	}
	
	public final static int[][][] BISHOP_MOVES = new int[64][][];
	static {
		for (int i = 0; i < 64; i++) {
			BISHOP_MOVES[i] = getBishopMoves(i);
		}
	}

	private static int[][] getBishopMoves(int from) {
		ArrayList<int[]> slide = new ArrayList<int[]>();
		slide(slide, from, UP + LEFT);
		slide(slide, from, UP + RIGHT);
		slide(slide, from, DOWN + LEFT);
		slide(slide, from, DOWN + RIGHT);
		return toArray2(slide);
	}

	public final static int[][][] QUEEN_MOVES = new int[64][][];
	static {
		for (int i = 0; i < 64; i++) {
			QUEEN_MOVES[i] = getQueenMoves(i);
		}
	}

	private static int[][] getQueenMoves(int from) {
		ArrayList<int[]> slide = new ArrayList<int[]>();
		slide(slide, from, UP);
		slide(slide, from, DOWN);
		slide(slide, from, LEFT);
		slide(slide, from, RIGHT);
		slide(slide, from, UP + LEFT);
		slide(slide, from, UP + RIGHT);
		slide(slide, from, DOWN + LEFT);
		slide(slide, from, DOWN + RIGHT);
		return toArray2(slide);
	}

	public final static int[][] KING_MOVES = new int[64][];
	static {
		for (int i = 0; i < 64; i++) {
			KING_MOVES[i] = getKingMoves(i);
		}
	}

	private static int[] getKingMoves(int from) {
		ArrayList<Integer> slide = new ArrayList<Integer>();
		add(slide, from, UP);
		add(slide, from, DOWN);
		add(slide, from, LEFT);
		add(slide, from, RIGHT);
		add(slide, from, UP + LEFT);
		add(slide, from, UP + RIGHT);
		add(slide, from, DOWN + LEFT);
		add(slide, from, DOWN + RIGHT);
		return toArray(slide);
	}
	
	static int[] toArray(ArrayList<Integer> moves) {
		int[] ret = new int[moves.size()];
		for (int i = 0; i < moves.size(); i++) {
			ret[i] = moves.get(i);
		}
		return ret;
	}

	static int[][] toArray2(ArrayList<int[]> moves) {
		int[][] ret = new int[moves.size()][];
		for (int i = 0; i < moves.size(); i++) {
			ret[i] = moves.get(i);
		}
		return ret;
	}

	/**
	 * Calculate is move is within borders return true if can continue like
	 * queen
	 * 
	 * @param moves
	 * @param offset
	 * @param pieces
	 * 
	 * @return
	 */
	static boolean add(ArrayList<Integer> moves, int from, int offset) {
		int i = from + offset;
		boolean has = inside(i, from);
		if (has)
			moves.add(i);
		return has;
	}

	/**
	 * is it inside the board = legal move
	 * 
	 * @param i
	 * @param from
	 * @return
	 */
	static boolean inside(int i, int from) {
		if (i < 0 || i > 63)
			return false;
		int x1 = i % 8;
		int x2 = from % 8;
		if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
			return false;
		return true;
	}

	/**
	 * Repeated moves like rook and queen
	 * 
	 * @param ROOK_MOVES
	 * @param board
	 * @param from
	 * @param offset
	 */
	static void slide(ArrayList<int[]> main, int from, int offset) {
		ArrayList<Integer> moves=new ArrayList<Integer>();
		for (int i = from; add(moves, i, offset); i += offset) {
			// not
		}
		int[] mv = toArray(moves);
		if(mv.length>0)
			main.add(mv);
	}

}
