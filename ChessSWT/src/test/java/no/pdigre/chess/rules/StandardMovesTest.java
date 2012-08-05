package no.pdigre.chess.rules;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.base.INode;
import no.pdigre.chess.eval.EvalMove;
import no.pdigre.chess.eval.FindMoves;
import no.pdigre.chess.moves.FEN;
import no.pdigre.chess.moves.Move;
import no.pdigre.chess.moves.PieceType;
import no.pdigre.chess.moves.StartGame;

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
        int pos = FEN.text2pos(from);
        int[] board = start.getBoard();
        int type = board[pos];
        FEN.printPiece(type,pos);
        StringBuffer sb = new StringBuffer();
        sb.append(PieceType.types[type].fen);
        for (Move move : eval.getLegalMovesForPiece(board, pos)) {
            sb.append(" ");
            sb.append(FEN.pos2string(move.getTo()));
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

        public void count(INode move) {
            moves++;
            if (((Move)move).isCastling()) {
                castlings++;
            }
            if (((Move)move).isCapture()) {
                captures++;
                if (((Move)move).isEnpassant()) {
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
        countFirst(new StartGame(fen));
        System.out.println("Depth   Moves  Captures  Castling  Enpassant  Check  Mate");
        for (int i = 0; i < MAXDEPTH; i++) {
            Counter cnt = counters[i];
            System.out.println(String.format("%d  %d  %d  %d  %d", i, cnt.moves, cnt.captures, cnt.castlings,
                cnt.enpassants));
        }
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    @Test
    public void testThink2() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        countFirst(new StartGame(fen));
        System.out.println("Depth   Moves  Captures  Castling  Enpassant  Check  Mate");
        for (int i = 0; i < MAXDEPTH; i++) {
            Counter cnt = counters[i];
            System.out.println(String.format("%d  %d  %d  %d  %d", i, cnt.moves, cnt.captures, cnt.castlings,
                cnt.enpassants));
        }
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    private void countFirst(final StartGame start) {
        final int[] board = start.getBoard();
        for (Move move : FindMoves.getLegalMoves(FindMoves.getMoves(board, start), board, start))
            countDepth(move, 0, board);
    }

    private void countDepth(final Move parent, int depth, int[] board) {
        counters[depth].count(parent);
        depth++;
        if (depth < MAXDEPTH) {
            final int[] brd = parent.apply(board);
            for (Move move : FindMoves.getLegalMoves(FindMoves.getMoves(brd, parent), brd, parent))
                countDepth(move, depth, brd);
        }
    }

}
