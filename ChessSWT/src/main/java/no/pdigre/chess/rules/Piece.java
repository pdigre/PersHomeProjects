package no.pdigre.chess.rules;

public class Piece {

	public final int pos;
	public final int type;
	public final Piece link;

	public Piece(int type, int pos, Piece link) {
		this.pos = pos;
		this.type = type;
		this.link = link;
	}

	public int getType() {
		return type;
	}

	@Override
	public String toString() {
		return PieceType.types[type].toString()+" "+FEN.pos2text(pos);
	}
}