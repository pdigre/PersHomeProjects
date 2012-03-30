package no.pdigre.chess.rules;

public class Beats extends Move {
	public PieceType beats;

	protected Beats(int from, int to, PieceType type, PieceType beats, AbstractMove parent) {
		super(from, to, type, parent);
		this.beats = beats;
	}

	@Override
	public String toString() {
		return super.toString() + " beats " + beats;
	}

	public int halfMoves() {
		return 0;
	}

}
