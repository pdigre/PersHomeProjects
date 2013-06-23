package no.pdigre.chess.engine.polyglot;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Polyglot {

    static public HashMap<ZobristKey, BookEntry> book = new HashMap<ZobristKey, BookEntry>();

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
                if (entry == null) {
                    entry = new BookEntry(key);
                    book.put(zobrist, entry);
                }
                entry.addMove(move, weight);
            }
        } catch (Exception e) {
            // nothing
        }
    }

    /**
     * "move" is a bit field with the following meaning (bit 0 is the least
     * significant bit) bits meaning =================================== 0,1,2
     * to file 3,4,5 to row 6,7,8 from file 9,10,11 from row 12,13,14 promotion
     * piece "promotion piece" is encoded as follows none 0 knight 1 bishop 2
     * rook 3 queen 4
     * 
     * @param move
     * @return
     */
    public static String int2MoveString(int move) {
        StringBuffer sb = new StringBuffer();
        sb.append((char) ('a' + ((move >> 6) & 0x7)));
        sb.append(((move >> 9) & 0x7) + 1);
        sb.append((char) ('a' + (move & 0x7)));
        sb.append(((move >> 3) & 0x7) + 1);
        if (((move >> 12) & 0x7) != 0)
            sb.append("nbrq".charAt(((move >> 12) & 0x7) - 1));
        return sb.toString();
    }

    public static int getFrom(int move) {
        return ((move >> 6) & 0x7)+((move >> 9) & 0x7)*8;
    }

    public static int getTo(int move) {
        return (move & 0x7)+((move >> 3) & 0x7)*8;
    }

    public static int randomBitmap(ArrayList<BookMove> moves, int variation, int stupidity) {
        int total = 0;
        for (BookMove move : moves)
            total += move.weight / (101 - variation) + stupidity;
        int random = (int) (Math.random() * total);
        for (BookMove move : moves) {
            random -= move.weight / (101 - variation) + stupidity;
            if (random <= 0)
                return move.move;
        }
        return moves.get(0).move;
    }

    public static String printMoves(ArrayList<BookMove> moves) {
        StringBuffer sb = new StringBuffer();
        for (BookMove move : moves) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(move.weight);
            sb.append("(");
            sb.append(Polyglot.int2MoveString(move.move));
            sb.append(")");
        }
        return sb.toString();
    }

    public static ArrayList<BookMove> get(long key) {
        BookEntry entry = Polyglot.book.get(new ZobristKey(key));
        if (entry != null)
            return entry.moves;
        return new ArrayList<BookMove>();
    }

}
