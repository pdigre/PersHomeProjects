package no.pdigre.chess.profile;

public class GraphicsCommon {
	public boolean nobuffer = false;
	
	public Square[] squares = new Square[64];

	public Square setup(int i) {
		Square square = squares[i];
		if (square == null) {
			square = new Square();
			if (!nobuffer)
				squares[i] = square;
		}
		return square;
	}

    private static final int PIECE_HEIGHT = 32;

    private static final int PIECE_WIDTH = 32;

    private static final int BOARD_OFFSET = PIECE_HEIGHT * 8 - 24;

    private static final int BOARD_MARGIN = PIECE_WIDTH - 24;


    public final static boolean isBlack(int i) {
        return (i % 8 + (i - i % 8) / 8) % 2 == 0;
    }

    public final static int[] getRectangleXYWH(int i) {
        int x = i % 8;
        return new int[]{BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - ((i - x) / 8) * PIECE_HEIGHT,
            PIECE_WIDTH - 1, PIECE_HEIGHT - 1};
    }

    public static int findSquare(int ex, int ey) {
        int x = (ex - BOARD_MARGIN) / PIECE_WIDTH;
        int y = (BOARD_OFFSET - ey + PIECE_HEIGHT) / PIECE_HEIGHT;
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return -1;
        return x + y * 8;
    }

    public static int[] toXY(int i){
        int x = i % 8;
        int y = (i - x) / 8;
        return new int[]{BOARD_MARGIN + x * PIECE_WIDTH, BOARD_OFFSET - y * PIECE_HEIGHT} ;       
    }
}
