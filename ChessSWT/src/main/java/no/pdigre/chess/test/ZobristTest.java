package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.fen.StartGame;
import no.pdigre.chess.polyglot.ZobristKey;

import org.junit.Test;

public class ZobristTest {

    @SuppressWarnings("static-method")
    @Test
    public void testZobringKeyStraight() {
        assertZobrist("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", "463b96181691fc9c");
        assertZobrist("rnbqkbnr/ppp1pppp/8/3pP3/8/8/PPPP1PPP/RNBQKBNR b KQkq - 0 2", "662fafb965db29d4");
    }

    @SuppressWarnings("static-method")
    @Test
    public void testZobringKeyEnpassant() {
        assertZobrist("rnbqkbnr/ppp1pppp/8/3p4/4P3/8/PPPP1PPP/RNBQKBNR w KQkq d6 0 2", "756b94461c50fb0");
        assertZobrist("rnbqkbnr/p1pppppp/8/8/PpP4P/8/1P1PPPP1/RNBQKBNR b KQkq c3 0 3", "3c8123ea7b067637");
        assertZobrist("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1", "823c9b50fd114196");
        assertZobrist("rnbqkbnr/ppp1p1pp/8/3pPp2/8/8/PPPP1PPP/RNBQKBNR w KQkq f6 0 3", "22a48b5a8e47ff78");
    }

    @SuppressWarnings("static-method")
    @Test
    public void testZobringKeyCastling() {
        assertZobrist("rnbqkbnr/ppp1p1pp/8/3pPp2/8/8/PPPPKPPP/RNBQ1BNR b kq - 0 3", "652a607ca3f242c1");
        assertZobrist("rnbqkbnr/p1pppppp/8/8/P6P/R1p5/1P1PPPP1/1NBQKBNR b Kkq - 0 4", "5c3f9b829b279560");
        assertZobrist("rnbq1bnr/ppp1pkpp/8/3pPp2/8/8/PPPPKPPP/RNBQ1BNR w - - 0 4", "00fdd303c946bdd9");
    }

    public static void assertZobrist(String fen, String key) {
        assertEquals(key, Long.toHexString(ZobristKey.getKey(new StartGame(fen))));
    }

}
