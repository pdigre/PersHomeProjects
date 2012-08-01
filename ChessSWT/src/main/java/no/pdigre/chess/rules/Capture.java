package no.pdigre.chess.rules;

public class Capture extends Move {

	public Capture(int from, int to, int type, IMove parent, int victim) {
		super(from,to,type|(victim << 4),parent);
	}

	@Override
	public String toString() {
		return super.toString() + " beats " + PieceType.types[((bitmap>>4)&7)];
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
//		if(pos==getTo())
//			return apply(piece.link);
//		if(pos==getFrom())
//			pos=getTo();
//		return new Piece(piece.type, pos, apply(piece.link));
//	}

    @Override
    public int[] applyPieces(final int[] in) {
        final int current = bitmap & CURRENT;
        final int to = bitmap & TO;
        int[] out=new int[in.length-1];
        for (int i = 0,j=0; i < in.length; i++) {
            int pos = in[i];
            int p = pos & CURRENT;
            if (p == current) {
                int a1=Move.getPos(pos);
                int b1=Move.getType(pos);
                int moved = moved(pos,bitmap);
                int a2=Move.getPos(moved);
                int b2=Move.getType(moved);
                out[j] = moved;
            } else 
                if (p != to) {
                    out[j]=pos;
                    j++;
                }
        }
        return out;
    }


}
