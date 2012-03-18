package no.pdigre.chess.rules;

public class Piece {

	public final int pos;
	public final PieceType type;
	public final Piece link;

	public Piece(PieceType type, int pos, Piece link) {
		this.pos = pos;
		this.type = type;
		this.link = link;
	}

	public PieceType getType() {
		return type;
	}

	@Override
	public String toString() {
		return type.toString()+" "+Move.pos2text(pos);
	}
}