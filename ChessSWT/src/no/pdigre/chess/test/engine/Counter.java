package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class Counter {

    public int moves;

    public int captures;

    public int checks;

    public int mates;

    public int castlings;

    public int enpassants;

    public int promotions;

    public Counter(){
    	
    }
    
    public void count(IPosition move, int[] board) {
        moves++;
        int inherit = move.getInherit();
        if (Bitmap.isCastling(inherit)) {
            castlings++;
        }
        if (Bitmap.isPromotion(inherit)) {
            promotions++;
        }
        if (Bitmap.isCapture(inherit)) {
            captures++;
            if (Bitmap.isEnpassant(inherit)) {
                enpassants++;
            }
        }
        int[] brd = Bitmap.apply(board, inherit);
        boolean white = move.whiteTurn();
        int kpos = NodeGen.getKingPos(brd, white);
        if(!NodeGen.checkSafe(brd, kpos, white)){
            checks++;
            if(!(new NodeGen(brd, inherit).nextSafe()!=0))
                mates++;
        }
    }

	private void add(Counter count) {
        captures += count.captures;
        castlings += count.castlings;
        checks += count.checks;
        enpassants += count.enpassants;
        mates += count.mates;
        moves += count.moves;
        promotions += count.promotions;
	}

    public static void total(Counter[] total, Counter[] add) {
        for (int i = 0; i < add.length; i++)
            total[i+1].add(add[i]);
    }

    public static void total(int[] total, int[] add) {
        for (int i = 0; i < add.length; i++)
            total[i+1]+=add[i];
    }

}