package no.pdigre.chess.test.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import no.pdigre.chess.engine.fen.StartGame;

import org.junit.Test;

public class AccuracyTest {

    private static final int MAXDEPTH = 6;

    public class Perft {

        public final String fen;

        public final int[] count;

        public Perft(String fen,int[] count) {
            this.fen = fen;
            this.count=count;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < count.length; i++)
                sb.append(count[i]+" ");
            sb.append(fen);
            return sb.toString();
        }
    }

    @Test
    public void testAccuracy() {
        ArrayList<Perft> list=new ArrayList<AccuracyTest.Perft>();
        try {
            InputStream in = getClass().getResourceAsStream("perftsuite.epd");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                String[] split = line.split("\\;");
                int[] count=new int[split.length-1];
                for (int i = 0; i < count.length; i++)
                    count[i] = Integer.parseInt(split[i + 1].split(" ")[1]);
                list.add(new Perft(split[0],count));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int line=1;
        for (Perft perft : list) {
            System.out.print((line++)+". "+perft);
            StartGame start = new StartGame(perft.fen);
            long time = System.currentTimeMillis();
            Counter[] counters = new TestCount(start.getInherit(), 0, Math.min(MAXDEPTH,perft.count.length), start.getBoard(),true).computeParallel();
            for (int i = 0; i < counters.length; i++) {
                if(perft.count[i]!=counters[i].moves){
                    System.out.println(" NOT "+(System.currentTimeMillis()-time)+"ms");
                    printCounter(counters);
                    throw new AssertionError("Wrong move count");
                }
            }
            System.out.println(" OK "+(System.currentTimeMillis()-time)+"ms");
        }
    }

    private static void printCounter(Counter[] counters) {
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
}
