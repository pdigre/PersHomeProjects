package no.pdigre.chess.swt;

public class GraphicsCommon {
	public boolean nobuffer = false;
	
	public Square[] squares = new Square[64];

	protected Square setup(int i) {
		Square square = squares[i];
		if (square == null) {
			square = new Square();
			if (!nobuffer)
				squares[i] = square;
		}
		return square;
	}

}
