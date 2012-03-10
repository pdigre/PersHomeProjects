package no.pdigre.chess.rules;



public enum PieceType {
    WhitePawn(1, 'P'),
    WhiteKnight(3, 'N'),
    WhiteBishop(3, 'B'),
    WhiteRook(5, 'R'),
    WhiteQueen(9, 'Q'),
    WhiteKing(100, 'K'),
    BlackPawn(-1, 'p'),
    BlackKnight(-3, 'n'),
    BlackBishop(-3, 'b'),
    BlackRook(-5, 'r'),
    BlackQueen(-9, 'q'),
    BlackKing(-100, 'k'); 

    final int weight;
    public final char fen;

    PieceType(int weight, char fen) {
        this.weight = weight;
        this.fen=fen;
    }

    public static PieceType getPieceType(char fen){
    	for (PieceType type : PieceType.values()) {
			if(type.fen==fen)
				return type;
		}
    	return null;
    }

	public boolean white() {
		return weight>0;
	}
}