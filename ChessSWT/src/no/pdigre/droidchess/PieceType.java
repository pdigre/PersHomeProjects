package no.pdigre.droidchess;

import java.util.HashSet;
import java.util.List;

public enum PieceType {
	WhitePawn(1, "C:/eclipse/work37/ChessSWT/images/1.gif"), WhiteBishop(3,
			"C:/eclipse/work37/ChessSWT/images/4.gif"), WhiteKnight(3,
			"C:/eclipse/work37/ChessSWT/images/3.gif"), WhiteRook(5,
			"C:/eclipse/work37/ChessSWT/images/2.gif"), WhiteQueen(9,
			"C:/eclipse/work37/ChessSWT/images/5.gif"), WhiteKing(100,
			"C:/eclipse/work37/ChessSWT/images/6.gif"), BlackPawn(-1,
			"C:/eclipse/work37/ChessSWT/images/9.gif"), BlackBishop(-3,
			"C:/eclipse/work37/ChessSWT/images/12.gif"), BlackKnight(-3,
			"C:/eclipse/work37/ChessSWT/images/11.gif"), BlackRook(-5,
			"C:/eclipse/work37/ChessSWT/images/10.gif"), BlackQueen(-9,
			"C:/eclipse/work37/ChessSWT/images/13.gif"), BlackKing(-100,
			"C:/eclipse/work37/ChessSWT/images/14.gif");

	final int weight;
	final String filename;

	PieceType(int weight, String filename) {
		this.weight = weight;
		this.filename = filename;
	}
	

}