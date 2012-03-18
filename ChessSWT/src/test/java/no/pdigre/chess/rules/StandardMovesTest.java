package no.pdigre.chess.rules;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.evaluate.EvalMove;

import org.junit.Test;

public class StandardMovesTest {

	@Test
	public void testWhiteStart() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		EvalMove eval = new EvalMove(new StartGame(fen));
		assertEquals("Knight1", "N a3 c3", getMoves("b1", eval));
		assertEquals("Knight2", "N f3 h3", getMoves("g1", eval));
		assertEquals("Pawn1", "P a3 a4", getMoves("a2", eval));
	}
	
	@Test
	public void testEnpassant() {
		String fen = "rnbqkbnr/ppp1pppp/8/8/1PpP4/8/P3PPPP/RNBQKBNR b KQkq b3 0 3";
		EvalMove eval = new EvalMove(new StartGame(fen));
		assertEquals("Pawn", "p c3 b3", getMoves("c4", eval));
	}
	
	@Test
	public void testOpening1() {
		String fen = "rnbqkb1r/pppp1ppp/5n2/4p3/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3";
		EvalMove eval = new EvalMove(new StartGame(fen));
		assertEquals("Queen", "Q d2 d3 e2 f3 g4 h5", getMoves("d1", eval));
	}
	
	@Test
	public void testCheck1() {
		String fen = "rnbqk1nr/ppp2ppp/4p3/3p4/1b1P4/P4P2/1PP1P1PP/RNBQKBNR w KQkq - 1 4";
		EvalMove eval = new EvalMove(new StartGame(fen));
		assertEquals("King", "K f2", getMoves("e1", eval));
		assertEquals("Queen", "Q d2", getMoves("d1", eval));
		assertEquals("Pawn1", "P b4", getMoves("a3", eval));
		assertEquals("Pawn2", "P c3", getMoves("c2", eval));
	}

	
	/**
	 * Shows available moves
	 * @param from
	 * @param fen
	 * @return
	 */
	public String testAvailMoves(String from, String fen) {
		return getMoves(from, new EvalMove(new StartGame(fen)));
	}

	public String getMoves(String from, EvalMove eval) {
		Piece piece = eval.move.getPiece(Move.text2pos(from));
		StringBuffer sb = new StringBuffer();
		sb.append(piece.type.fen);
		for (Integer pos : eval.getLegalMoves(piece)) {
			sb.append(" ");
			sb.append(Move.pos2text(pos));
		}
		return sb.toString();
	}

}
