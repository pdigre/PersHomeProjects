package no.pdigre.chess.test.engine;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;

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

	public static void total(Counter[] total, Counter[] add) {
        for (int i = 0; i < total.length; i++)
        	total[i].add(add[i]);
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

}