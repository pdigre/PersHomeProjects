package no.pdigre.chess.profile;

public class Marking {
	public MarkingType type;
	public int pos;
	public int score;

	public Marking(MarkingType type, int pos) {
		super();
		this.type = type;
		this.pos = pos;
	}

	public Marking(MarkingType type, int pos, int score) {
		super();
		this.type = type;
		this.pos = pos;
		this.score=score;
	}

}
