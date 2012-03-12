package no.pdigre.chess.rules;

public enum PieceType {
    WHITE_PAWN(1, 'P',WhitePawn.class),
    WHITE_KNIGHT(3, 'N',WhiteKnight.class),
    WHITE_BISHOP(3, 'B',WhiteBishop.class),
    WHITE_ROOK(5, 'R',WhiteRook.class),
    WHITE_QUEEN(9, 'Q',WhiteQueen.class),
    WHITE_KING(100, 'K',WhiteKing.class),
    BLACK_PAWN(-1, 'p',BlackPawn.class),
    BLACK_KINGHT(-3, 'n',BlackKnight.class),
    BLACK_BISHOP(-3, 'b',BlackBishop.class),
    BLACK_ROOK(-5, 'r',BlackRook.class),
    BLACK_QUEEN(-9, 'q',BlackQueen.class),
    BLACK_KING(-100, 'k',BlackKing.class); 

    final public int weight;
    final public char fen;
    final public Class<AbstractPiece> clazz;
    final public boolean white;

    @SuppressWarnings("unchecked")
	<T extends AbstractPiece> PieceType(int weight, char fen,Class<T> clazz) {
        this.weight = weight;
        this.fen=fen;
        this.clazz=(Class<AbstractPiece>) clazz;
        this.white=weight>0;
    }

    public static PieceType getPieceType(char fen){
    	for (PieceType type : PieceType.values()) {
			if(type.fen==fen)
				return type;
		}
    	return null;
    }

	public boolean white() {
		return white;
	}
	
    public AbstractPiece create(int pos) {
		try {
			AbstractPiece create = this.clazz.newInstance();
	        create.from=pos;
			return create;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

}