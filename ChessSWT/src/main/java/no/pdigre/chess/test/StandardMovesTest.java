package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.NodeGen;
import no.pdigre.chess.fen.FEN;
import no.pdigre.chess.fen.IPosition;
import no.pdigre.chess.fen.Move;
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
        assertEquals("Knight1", "N c3 a3", getLegalMovesFromPos("b1", move));
        assertEquals("Knight2", "N h3 f3", getLegalMovesFromPos("g1", move));
        assertEquals("Pawn1", "P a4 a3", getLegalMovesFromPos("a2", move));
    }

    @SuppressWarnings("static-method")
    @Test
    public void testEnpassant() {
        String fen = "rnbqkbnr/ppp1pppp/8/8/1PpP4/8/P3PPPP/RNBQKBNR b KQkq b3 0 3";
        assertEquals("Pawn", "p b3 c3", getLegalMovesFromPos("c4", new StartGame(fen)));
    }

    @SuppressWarnings("static-method")
    @Test
    public void testOpening1() {
        String fen = "rnbqkb1r/pppp1ppp/5n2/4p3/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3";
        assertEquals("Queen", "Q h5 g4 f3 e2 d3 d2", getLegalMovesFromPos("d1", new StartGame(fen)));
    }

    @SuppressWarnings("static-method")
    @Test
    public void testPromotions() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        String moves = getLegalMovesFromPos("g2", new StartGame(fen));
        assertEquals("Pawn", "p h1 h1 h1 h1 f1 f1 f1 f1 g1 g1 g1 g1", moves);
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

    public static String getLegalMovesFromPos(String from_txt, StartGame start) {
        int from = FEN.text2pos(from_txt);
        int[] board = start.getBoard();
        int type = board[from];
        FEN.printPiece(type, from);
        StringBuffer sb = new StringBuffer();
        sb.append(PieceType.types[type].fen);
        for (int bitmap : NodeGen.filterFrom(NodeGen.getAllMoves(board, start.getInherit()), from)) {
            sb.append(" ");
            sb.append(FEN.pos2string(Bitmap.getTo(bitmap)));
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

        public void count(IPosition move, int[] board) {
            moves++;
            if (Bitmap.isCastling(((Move) move).getInherit())) {
                castlings++;
            }
            if (Bitmap.isPromotion(((Move) move).getInherit())) {
                promotions++;
            }
            if (Bitmap.isCapture(((Move) move).getInherit())) {
                captures++;
                if (Bitmap.isEnpassant(((Move) move).getInherit())) {
                    enpassants++;
                }
            }
            int[] brd = Bitmap.apply(board, ((Move)move).getInherit());
            boolean white = move.whiteTurn();
            int kpos = NodeGen.getKingPos(brd, white);
            if(!NodeGen.checkSafe(brd, kpos, white)){
                checks++;
                if(!(new NodeGen(brd, move.getInherit()).nextSafe()!=0))
                    mates++;
            }
        }

    }

    public Counter[] counters = new Counter[MAXDEPTH];

    /**
     * Takes 22.5 sec with 28.07.2012 Takes 2.1 sec with 02.08.2012 Takes 60.0
     * sec with 02.08.2012 for 6 levels
     * Takes 4.1 secs with 05.08.2012
     * Takes 3.9 secs with 07.08.2012
     */
    @Test
    public void testThinkStart1() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        StartGame start = new StartGame(fen);
        new TestCount(start.getInherit(), 0, counters, start.getBoard()).run();
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
    public void testThinkPromo() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        counters = new Counter[MAXDEPTH];
        for (int i = 0; i < MAXDEPTH; i++)
            counters[i] = new Counter();
        StartGame start = new StartGame(fen);
        new TestCount(start.getInherit(), 0, counters, start.getBoard()).run();
        printCounter();
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

}
