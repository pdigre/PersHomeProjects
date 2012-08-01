package no.pdigre.chess.rules;

public class EnPassant extends Capture {

	public EnPassant(int from, int to, int type, IMove parent, int victim) {
		super(from, to, type|IMove.ENPASSANT,parent, victim);
	}

	@Override
	public String toString() {
		return super.toString() + " enpassant ";
	}

	@Override
	public int halfMoves() {
		return 0;
	}

//	@Override
//	public Piece apply(Piece piece) {
//		if(piece==null)
//			return null;
//		int pos=piece.pos;
//		if(pos==getFrom()-PieceType.forward(bitmap))
//			return apply(piece.link);
//		if(pos==getFrom())
//			pos=getTo();
//		return new Piece(piece.type, pos, apply(piece.link));
//	}

	@Override
	public int[] applyPieces(final int[] in) {
	    final int current = bitmap & CURRENT;
        int to = getTo();
        int from = getFrom();
        final int enpassant = (to+(to>from?-8:8))<< 18;
        final int[] out=new int[in.length-1];
        for (int i = 0,j=0; i < in.length; i++) {
            int pos = in[i];
            int p = pos & CURRENT;
            if (p == current) {
                out[j] = moved(pos,bitmap);
            } else 
                if (p != enpassant) {
                    out[j]=pos;
                    j++;
                }
        }
        return out;
	}
	
	@Override
    public int[] applyBoard(int[] in) {
        int[] board = in.clone();
		board[getFrom()] = 0;
		board[getFrom()-FindMoves.forward(bitmap)]=0;
		board[getTo()] = bitmap & PIECE;
        return board;
	}
}
