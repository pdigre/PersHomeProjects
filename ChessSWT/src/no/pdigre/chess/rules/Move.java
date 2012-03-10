package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.HashSet;

public class Move extends AbstractMove {
	PieceType type;
	public int from;
	public int to;
	public AbstractMove parent;

	protected Move(int from, int to, PieceType type, AbstractMove parent) {
		super();
		this.type = type;
		this.from = from;
		this.to = to;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return type + " from " + pos2string(from) + " to " + pos2string(to);
	}

	public String pos2string(int pos) {
		int h = pos % 8;
		StringBuilder sb = new StringBuilder();
		sb.append("abcdefgh".charAt((pos - h) / 8));
		sb.append("12345678".charAt(h));
		return sb.toString();
	}

	public static Move create(int from, int to, PieceType type, PieceType victim, AbstractMove parent) {
		if (victim != null)
			return new Beats(from, to, type, victim, parent);
		return new Move(from, to, type, parent);
	}

	public static Move create(int from, Piece piece, Piece victim, AbstractMove last) {
		return create(from, piece.pos, piece.type, victim == null ? null : victim.type, last);
	}

	public boolean whiteTurn() {
		return type.weight < 0;
	}

	public boolean canCastle(PieceType castling) {
		if (breakCastle(castling))
			return false;
		return parent.canCastle(castling);
	}

	public boolean breakCastle(PieceType castling) {
		switch (castling) {
		case WhiteKing:
			return type == PieceType.WhiteKing || (type == PieceType.WhiteRook && from == 7);
		case WhiteQueen:
			return type == PieceType.WhiteKing || (type == PieceType.WhiteRook && from == 0);
		case BlackKing:
			return type == PieceType.BlackKing || (type == PieceType.BlackRook && from == 63);
		case BlackQueen:
			return type == PieceType.BlackKing || (type == PieceType.BlackRook && from == 56);
		}
		return true;
	}

	public int totalMoves() {
		int i = parent.totalMoves();
		if (whiteTurn())
			i++;
		return i;
	}

	public int halfMoves() {
		if (type == PieceType.WhitePawn || type == PieceType.BlackPawn)
			return 0;
		return parent.halfMoves() + 1;
	}

	public String getFenEnpassant() {
		return pos2text(getEnpassant());
	}

	public int getEnpassant() {
		if (type == PieceType.WhitePawn && from - to == -16)
			return from + 8;
		if (type == PieceType.BlackPawn && from - to == 16)
			return from - 8;
		return -1;
	}

	@Override
	public HashSet<Piece> getPieces() {
		HashSet<Piece> pieces = parent.getPieces();
		applyMove(pieces);
		return pieces;
	}

	public void applyMove(HashSet<Piece> pieces) {
		Piece pfrom = null;
		Piece pto = null;
		for (Piece piece : pieces) {
			if (piece.pos == from)
				pfrom = piece;
			if (piece.pos == to)
				pto = piece;
		}
		if (pto != null)
			pieces.remove(pto);
		if (pfrom != null)
			pfrom.pos = to;
		else 
			System.out.println("hi");
	}

	@Override
	public PieceType[] getBoard() {
		PieceType[] board = parent.getBoard();
		applyMove(board);
		return board;
	}

	public void applyMove(PieceType[] board) {
		board[from] = null;
		board[to] = type;
	}

}
