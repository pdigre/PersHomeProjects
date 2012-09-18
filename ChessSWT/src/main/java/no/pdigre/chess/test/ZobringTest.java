package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.fen.StartGame;
import no.pdigre.chess.polyglot.ZobristKey;

import org.junit.Test;

public class ZobringTest {
    
    @SuppressWarnings("static-method")
    @Test
    public void testAlphaBeta() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StartGame move = new StartGame(fen);
        long[] key = ZobristKey.getKey(move);
        String string = Long.toHexString(key[0])+","+Long.toHexString(key[0]);
        assertEquals("463b96181691fc9c",string);
    }

}
