package no.pdigre.chess.polyglot;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import no.pdigre.chess.polyglot.BookEntry.BookMove;

public class Polyglot {

    static public HashMap<ZobristKey,BookEntry> book=new HashMap<ZobristKey, BookEntry>();

    static {
        try {
            InputStream bookIs = Polyglot.class.getResourceAsStream("fruit.bin");
            DataInputStream in = new DataInputStream(new BufferedInputStream(bookIs));

            while (true) {
                long key = in.readLong();
                int move = in.readShort();
                int weight = in.readShort();
                in.readInt(); // Unused learn field
                ZobristKey zobrist = new ZobristKey(key);
                BookEntry entry = book.get(zobrist);
                if(entry==null){
                    entry=new BookEntry(key);
                    book.put(zobrist, entry);
                }
                entry.addMove(move, weight);
            }
        } catch (Exception e) {
            // nothing
        }
    }
    
    
    /**
     * "move" is a bit field with the following meaning (bit 0 is the least significant bit)
     *
     *      bits                meaning
     * ===================================
     * 0,1,2               to file
     * 3,4,5               to row
     * 6,7,8               from file
     * 9,10,11             from row
     * 12,13,14            promotion piece
     * "promotion piece" is encoded as follows
     * none       0
     * knight     1
     * bishop     2
     * rook       3
     * queen      4
     * @param move
     * @return
     */
    public static String int2MoveString(int move) {
        StringBuffer sb = new StringBuffer();
        sb.append((char)('a' + ((move >> 6) & 0x7)));
        sb.append(((move >> 9) & 0x7) +1);
        sb.append((char)('a' + (move & 0x7)));
        sb.append(((move >> 3) & 0x7) +1);
        if (((move >> 12) & 0x7) != 0) sb.append("nbrq".charAt(((move >> 12) & 0x7) - 1));
        return sb.toString();
    }

    
}
