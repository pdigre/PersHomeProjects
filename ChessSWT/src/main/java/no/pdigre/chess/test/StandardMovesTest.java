package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.base.INode;
import no.pdigre.chess.base.NodeGenerator;
import no.pdigre.chess.base.TestGenerator;
import no.pdigre.chess.eval.FindMoves;
import no.pdigre.chess.eval.Move;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.PieceType;
import no.pdigre.chess.fen.StartGame;

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
        int pos = FEN.text2pos(from);
        int[] board = start.getBoard();
        int type = board[pos];
        FEN.printPiece(type, pos);
        StringBuffer sb = new StringBuffer();
        sb.append(PieceType.types[type].fen);
        for (Move move : FindMoves.filterPieces(FindMoves.getMoves(board, start), pos)) {
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

        public void count(INode move, int[] board) {
            moves++;
            if (((Move) move).isCastling()) {
                castlings++;
            }
            if (((Move) move).isPromotion()) {
                promotions++;
            }
            if (((Move) move).isCapture()) {
                captures++;
                if (((Move) move).isEnpassant()) {
                    enpassants++;
                }
            }
            int[] brd = ((Move)move).apply(board);
            if(NodeGenerator.isCheck(brd,move.whiteTurn())){
                checks++;
                if(FindMoves.isMate(move, brd))
                    mates++;
            }
        }

    }

    public Counter[] counters = new Counter[MAXDEPTH];

    /**
     * Takes 22.5 sec with 28.07.2012 Takes 2.1 sec with 02.08.2012 Takes 60.0
     * sec with 02.08.2012 for 6 levels
     */
    @Test
    public void testThinkStart1() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        countFirst(new StartGame(fen));
        printCounter();
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    /**
     * Takes 22.5 sec with 28.07.2012 Takes 2.1 sec with 02.08.2012 Takes 60.0
     * sec with 02.08.2012 for 6 levels
     * Takes 4.1 secs with 05.08.2012
     */
    @Test
    public void testThinkStart2() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        StartGame start = new StartGame(fen);
        TestGenerator.run(start.getBitmap(),start.getBoard(),counters);
        printCounter();
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    private void printCounter() {
        String x = "Depth,Moves,Captures,Enpassant,Castling,Promotion,Check,Mate";
        System.out.println(format10(x));
        for (int i = 0; i < MAXDEPTH; i++) {
            Counter cnt = counters[i];
            System.out.println(format10(String.format("%d,%d,%d,%d,%d,%d,%d,%d", i + 1, cnt.moves, cnt.captures,
                cnt.enpassants, cnt.castlings, cnt.promotions, cnt.checks, cnt.mates)));
        }
    }

    private static String format10(String delimited) {
        StringBuilder sb = new StringBuilder();
        for (String string : delimited.split(",")) {
            sb.append("          ".substring(string.length()));
            sb.append(string);
        }
        return sb.toString();
    }

    @Test
    public void testThinkPromo1() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        countFirst(new StartGame(fen));
        printCounter();
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    @Test
    public void testThinkPromo2() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        StartGame start = new StartGame(fen);
        TestGenerator.run(start.getBitmap(),start.getBoard(),counters);
        printCounter();
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    private void countFirst(final StartGame start) {
        final int[] board = start.getBoard();
        for (Move move : FindMoves.getMoves(board, start))
            countDepth(move, 0, board);
    }

    private void countDepth(final Move parent, int depth, int[] board) {
        counters[depth].count(parent, board);
        depth++;
        if (depth < MAXDEPTH) {
            final int[] brd = parent.apply(board);
            for (Move move : FindMoves.getMoves(brd, parent))
                countDepth(move, depth, brd);
        }
    }

}
