package no.pdigre.droidchess;

import java.util.HashSet;
import java.util.Stack;

public class Game {

    public HashSet<Piece> pieces = new HashSet<Piece>();

    public Stack<Move> log = new Stack<Move>();

    public Game() {
        super();
        newGame();
    }

    public void newGame() {
        pieces.add(Piece.newPiece(0, PieceType.WhiteRook));
        pieces.add(Piece.newPiece(1, PieceType.WhiteKnight));
        pieces.add(Piece.newPiece(2, PieceType.WhiteBishop));
        pieces.add(Piece.newPiece(3, PieceType.WhiteQueen));
        pieces.add(Piece.newPiece(4, PieceType.WhiteKing));
        pieces.add(Piece.newPiece(5, PieceType.WhiteBishop));
        pieces.add(Piece.newPiece(6, PieceType.WhiteKnight));
        pieces.add(Piece.newPiece(7, PieceType.WhiteRook));
        pieces.add(Piece.newPiece(8, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(9, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(10, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(11, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(12, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(13, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(14, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(15, PieceType.WhitePawn));
        pieces.add(Piece.newPiece(63, PieceType.BlackRook));
        pieces.add(Piece.newPiece(62, PieceType.BlackKnight));
        pieces.add(Piece.newPiece(61, PieceType.BlackBishop));
        pieces.add(Piece.newPiece(60, PieceType.BlackQueen));
        pieces.add(Piece.newPiece(59, PieceType.BlackKing));
        pieces.add(Piece.newPiece(58, PieceType.BlackBishop));
        pieces.add(Piece.newPiece(57, PieceType.BlackKnight));
        pieces.add(Piece.newPiece(56, PieceType.BlackRook));
        pieces.add(Piece.newPiece(55, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(54, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(53, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(52, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(51, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(50, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(49, PieceType.BlackPawn));
        pieces.add(Piece.newPiece(48, PieceType.BlackPawn));
    }

    public void move(int from, int to) {
        for (Piece piece : pieces) {
            if (piece.pos == from) {
                piece.move(to);
                PieceType victim = null;
                for (Piece other : pieces) {
                    if (other.pos == to)
                        victim = other.type;
                }
                log.add(new Move(from, to, piece.type, victim));
                System.out.println(log.peek());
            }
        }
    }

    public PieceType[] getcurrentBoard(){
        PieceType[] board=new PieceType[64];
        for (Piece piece : pieces)
            board[piece.pos]=piece.type;
        return board;
    }
}
