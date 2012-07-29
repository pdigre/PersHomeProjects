package no.pdigre.chess.rules;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class StandardMovesTest {

	private static final int MAXDEPTH = 5;

	@Test
	public void testWhiteStart() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		StartGame move = new StartGame(fen);
		assertEquals("Knight1", "N a3 c3", getMoves("b1", move));
		assertEquals("Knight2", "N f3 h3", getMoves("g1", move));
		assertEquals("Pawn1", "P a3 a4", getMoves("a2", move));
	}

	@Test
	public void testEnpassant() {
		String fen = "rnbqkbnr/ppp1pppp/8/8/1PpP4/8/P3PPPP/RNBQKBNR b KQkq b3 0 3";
		assertEquals("Pawn", "p c3 b3", getMoves("c4", new StartGame(fen)));
	}

	@Test
	public void testOpening1() {
		String fen = "rnbqkb1r/pppp1ppp/5n2/4p3/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3";
		assertEquals("Queen", "Q d2 d3 e2 f3 g4 h5", getMoves("d1", new StartGame(fen)));
	}

	@Test
	public void testCheck1() {
		String fen = "rnbqk1nr/ppp2ppp/4p3/3p4/1b1P4/P4P2/1PP1P1PP/RNBQKBNR w KQkq - 1 4";
		StartGame move = new StartGame(fen);
		assertEquals("King", "K f2", getMoves("e1", move));
		assertEquals("Queen", "Q d2", getMoves("d1", move));
		assertEquals("Pawn1", "P b4", getMoves("a3", move));
		assertEquals("Pawn2", "P c3", getMoves("c2", move));
	}

	/**
	 * Shows available moves
	 * 
	 * @param from
	 * @param fen
	 * @return
	 */
	public String testAvailMoves(String from, String fen) {
		return getMoves(from, new StartGame(fen));
	}

	public String getMoves(String from, StartGame start) {
		EvalMove eval = new EvalMove(start);
		Piece piece = start.getPiece(AbstractMove.text2pos(from));
		StringBuffer sb = new StringBuffer();
		sb.append(PieceType.types[piece.type].fen);
		for (Integer pos : eval.getLegalMoves(piece)) {
			sb.append(" ");
			sb.append(AbstractMove.pos2text(pos));
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

		public void count(AbstractMove move) {
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
	public void testThink() {
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
	public void testPromotion() {
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
		assertEquals(counters[4].moves,3605103);
	}

	private void countFirst(final StartGame start, int depth) {
		EvalMove eval = new EvalMove(start);
		int[] board = start.getBoard();
		Piece pieces = start.getPieces();
		ArrayList<Move> moves = eval.findMoves(board, pieces);
		if ((eval.state & EvalMove.ILLEGAL) == 0) {
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
			Piece pieces) {
		if (depth == MAXDEPTH)
			return;
		EvalMove eval = new EvalMove(pstate, mv);
		final int[] brd = board.clone();
		mv.apply(brd);
		Piece pcs = mv.apply(pieces);
		ArrayList<Move> moves = eval.findMoves(brd, pcs);
		if ((eval.state & EvalMove.ILLEGAL) == 0) {
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
