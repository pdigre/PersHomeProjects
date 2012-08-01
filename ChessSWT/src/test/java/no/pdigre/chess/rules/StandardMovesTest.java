package no.pdigre.chess.rules;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StandardMovesTest {

	private static final int MAXDEPTH = 5;

	@SuppressWarnings("static-method")
    @Test
	public void testWhiteStart() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		StartGame move = new StartGame(fen);
		assertEquals("Knight1", "N a3 c3", getLegalMovesFromPos("b1", move));
		assertEquals("Knight2", "N f3 h3", getLegalMovesFromPos("g1", move));
		assertEquals("Pawn1", "P a3 a4", getLegalMovesFromPos("a2", move));
	}

	@SuppressWarnings("static-method")
    @Test
	public void testEnpassant() {
		String fen = "rnbqkbnr/ppp1pppp/8/8/1PpP4/8/P3PPPP/RNBQKBNR b KQkq b3 0 3";
		assertEquals("Pawn", "p c3 b3", getLegalMovesFromPos("c4", new StartGame(fen)));
	}

	@SuppressWarnings("static-method")
    @Test
	public void testOpening1() {
		String fen = "rnbqkb1r/pppp1ppp/5n2/4p3/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3";
		assertEquals("Queen", "Q d2 d3 e2 f3 g4 h5", getLegalMovesFromPos("d1", new StartGame(fen)));
	}

	@SuppressWarnings("static-method")
    @Test
	public void testPromotions() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		String moves = getLegalMovesFromPos("g2", new StartGame(fen));
		assertEquals("Pawn", "p g1 g1 g1 g1 f1 f1 f1 f1 h1 h1 h1 h1", moves);
	}

	@SuppressWarnings("static-method")
    @Test
	public void testCheck1() {
		String fen = "rnbqk1nr/ppp2ppp/4p3/3p4/1b1P4/P4P2/1PP1P1PP/RNBQKBNR w KQkq - 1 4";
		StartGame move = new StartGame(fen);
		assertEquals("King", "K f2", getLegalMovesFromPos("e1", move));
		assertEquals("Queen", "Q d2", getLegalMovesFromPos("d1", move));
		assertEquals("Pawn1", "P b4", getLegalMovesFromPos("a3", move));
		assertEquals("Pawn2", "P c3", getLegalMovesFromPos("c2", move));
	}

	/**
	 * Shows available moves
	 * 
	 * @param from
	 * @param fen
	 * @return
	 */
	public static String testAvailMoves(String from, String fen) {
		return getLegalMovesFromPos(from, new StartGame(fen));
	}

	public static String getLegalMovesFromPos(String from, StartGame start) {
		EvalMove eval = new EvalMove(start);
		int[] board = start.getBoard();
		int position = FEN.text2pos(from);
		int piece = board[position] | position<<12;
		FEN.printPiece(piece);
		StringBuffer sb = new StringBuffer();
		sb.append(PieceType.types[Move.getType(piece)].fen);
		for (Move pos : eval.getLegalMovesForPiece(piece)) {
			sb.append(" ");
			sb.append(FEN.pos2text(pos.getTo()));
		}
		return sb.toString();
	}

	public class Counter {
		public int moves;
		public int captures;
		public int checks;
		public int mates;
		public int castlings;
		public int enpassants;
		public int promotions;

		public void count(IMove move) {
			moves++;
			if (move instanceof Castling) {
				castlings++;
			}
			if (move instanceof Capture) {
				captures++;
				if (move instanceof EnPassant) {
					enpassants++;
				}
			}
		}
	}

	public Counter[] counters = new Counter[MAXDEPTH];

	/**
	 * Takes 22.5 sec with 28.07.2012
	 */
	@Test
	public void testThink1() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		counters = new Counter[MAXDEPTH];
		for (int i = 0; i < MAXDEPTH; i++)
			counters[i] = new Counter();
		countFirst(new StartGame(fen), -1);
		System.out
				.println("Depth   Moves  Captures  Castling  Enpassant  Check  Mate");
		for (int i = 0; i < MAXDEPTH; i++) {
			Counter cnt = counters[i];
			System.out.println(String.format("%d  %d  %d  %d  %d", i,
					cnt.moves, cnt.captures, cnt.castlings, cnt.enpassants));
		}
		assertEquals(counters[4].moves,4865609);
		assertEquals(counters[4].captures,82719);
		assertEquals(counters[4].enpassants,258);
	}
	
	
	@Test
	public void testThink2() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		counters = new Counter[MAXDEPTH];
		for (int i = 0; i < MAXDEPTH; i++)
			counters[i] = new Counter();
		countFirst(new StartGame(fen), -1);
		System.out
				.println("Depth   Moves  Captures  Castling  Enpassant  Check  Mate");
		for (int i = 0; i < MAXDEPTH; i++) {
			Counter cnt = counters[i];
			System.out.println(String.format("%d  %d  %d  %d  %d", i,
					cnt.moves, cnt.captures, cnt.castlings, cnt.enpassants));
		}
		assertEquals(counters[0].moves,24);
		assertEquals(counters[1].moves,496);
		assertEquals(counters[2].moves,9483);
		assertEquals(counters[3].moves,182838);
		assertEquals(counters[4].moves,3605103);
	}

	private void countFirst(final StartGame start, int depth) {
		EvalMove eval = new EvalMove(start);
		int[] board = start.getBoard();
		int[] pieces = start.getPieces();
		ArrayList<Move> moves = eval.getMoves(board, pieces);
		if ((eval.state & IMove.ILLEGAL) == 0) {
			if (depth >= 0)
				counters[depth].count(start);
			depth++;
			if (depth < MAXDEPTH)
				for (Move move : moves)
					if (move != null)
						countDepth(eval.state, move, depth, board, pieces);
		}
	}

	private void countDepth(int pstate, final Move mv, int depth, int[] board,
			int[] pieces) {
		if (depth == MAXDEPTH)
			return;
		EvalMove eval = new EvalMove(pstate, mv);
		final int[] brd= mv.applyBoard(board);
		int[] pcs = mv.applyPieces(pieces);
		ArrayList<Move> moves = eval.getMoves(brd, pcs);
		if ((eval.state & IMove.ILLEGAL) == 0) {
			if (depth >= 0)
				counters[depth].count(mv);
			depth++;
			if (depth < MAXDEPTH)
				for (Move move : moves)
					if (move != null)
						countDepth(eval.state, move, depth, brd, pcs);
		}
	}

}
