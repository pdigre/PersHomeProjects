package no.pdigre.droidchess;


public enum PieceType {
    WhitePawn(1, "1.gif"),
    WhiteBishop(3, "4.gif"),
    WhiteKnight(3, "3.gif"),
    WhiteRook(5, "2.gif"),
    WhiteQueen(9, "5.gif"),
    WhiteKing(100, "6.gif"),
    BlackPawn(-1, "9.gif"),
    BlackBishop(-3, "12.gif"),
    BlackKnight(-3, "11.gif"),
    BlackRook(-5, "10.gif"),
    BlackQueen(-9, "13.gif"),
    BlackKing(-100, "14.gif");

    final int weight;

    final String filename;

    PieceType(int weight, String filename) {
        this.weight = weight;
        this.filename = filename;
    }

}