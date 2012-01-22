package no.pdigre.droidchess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Piece {
	int pos;
	final PieceType type;

	Piece(final int pos, final PieceType type) {
		this.pos = pos;
		this.type = type;
	}

	Piece(final int x, final int y, final PieceType type) {
		this.pos = x + y * 8;
		this.type = type;
	}

	public static HashSet<Piece> startNewBoard() {
		HashSet<Piece> pieces = new HashSet<Piece>();
		pieces.add(new Piece(0, PieceType.WhiteRook));
		pieces.add(new Piece(1, PieceType.WhiteKnight));
		pieces.add(new Piece(2, PieceType.WhiteBishop));
		pieces.add(new Piece(3, PieceType.WhiteQueen));
		pieces.add(new Piece(4, PieceType.WhiteKing));
		pieces.add(new Piece(5, PieceType.WhiteBishop));
		pieces.add(new Piece(6, PieceType.WhiteKnight));
		pieces.add(new Piece(7, PieceType.WhiteRook));
		pieces.add(new Piece(8, PieceType.WhitePawn));
		pieces.add(new Piece(9, PieceType.WhitePawn));
		pieces.add(new Piece(10, PieceType.WhitePawn));
		pieces.add(new Piece(11, PieceType.WhitePawn));
		pieces.add(new Piece(12, PieceType.WhitePawn));
		pieces.add(new Piece(13, PieceType.WhitePawn));
		pieces.add(new Piece(14, PieceType.WhitePawn));
		pieces.add(new Piece(15, PieceType.WhitePawn));
		pieces.add(new Piece(63, PieceType.BlackRook));
		pieces.add(new Piece(62, PieceType.BlackKnight));
		pieces.add(new Piece(61, PieceType.BlackBishop));
		pieces.add(new Piece(60, PieceType.BlackQueen));
		pieces.add(new Piece(59, PieceType.BlackKing));
		pieces.add(new Piece(58, PieceType.BlackBishop));
		pieces.add(new Piece(57, PieceType.BlackKnight));
		pieces.add(new Piece(56, PieceType.BlackRook));
		pieces.add(new Piece(55, PieceType.BlackPawn));
		pieces.add(new Piece(54, PieceType.BlackPawn));
		pieces.add(new Piece(53, PieceType.BlackPawn));
		pieces.add(new Piece(52, PieceType.BlackPawn));
		pieces.add(new Piece(51, PieceType.BlackPawn));
		pieces.add(new Piece(50, PieceType.BlackPawn));
		pieces.add(new Piece(49, PieceType.BlackPawn));
		pieces.add(new Piece(48, PieceType.BlackPawn));
		return pieces;
	}

	public void findMoves(HashSet<Piece> pieces, List<Integer> moves) {
		switch (type) {
		case WhiteKnight:
		case BlackKnight:
			addMove(pieces, moves, 6);
			addMove(pieces, moves, 10);
			addMove(pieces, moves, 15);
			addMove(pieces, moves, 17);
			addMove(pieces, moves, -6);
			addMove(pieces, moves, -10);
			addMove(pieces, moves, -15);
			addMove(pieces, moves, -17);
			break;
		case WhiteBishop:
		case BlackBishop:
			repeatMove(pieces, moves, 7);
			repeatMove(pieces, moves, 9);
			repeatMove(pieces, moves, -7);
			repeatMove(pieces, moves, -9);
			break;
		case WhiteRook:
		case BlackRook:
			repeatMove(pieces, moves, 8);
			repeatMove(pieces, moves, 1);
			repeatMove(pieces, moves, -1);
			repeatMove(pieces, moves, -8);
			break;
		case WhiteQueen:
		case BlackQueen:
			repeatMove(pieces, moves, 8);
			repeatMove(pieces, moves, 1);
			repeatMove(pieces, moves, -1);
			repeatMove(pieces, moves, -8);
			repeatMove(pieces, moves, 7);
			repeatMove(pieces, moves, 9);
			repeatMove(pieces, moves, -7);
			repeatMove(pieces, moves, -9);
			break;
		case WhiteKing:
		case BlackKing:
			addMove(pieces, moves, 8);
			addMove(pieces, moves, 1);
			addMove(pieces, moves, -1);
			addMove(pieces, moves, -8);
			addMove(pieces, moves, 7);
			addMove(pieces, moves, 9);
			addMove(pieces, moves, -7);
			addMove(pieces, moves, -9);
			break;
		case WhitePawn: {
			int forward = pos + 8;
			if (onBoard(forward)) {
				if (getPiece(pieces, forward) == null) {
					moves.add(forward);
					if (pos > 7 && pos < 16) {
						int forward2 = pos + 16;
						if (onBoard(forward2)) {
							if (getPiece(pieces, forward2) == null)
								moves.add(forward2);
						}
					}
				}
			}
			int left = pos + 7;
			if (onBoard(left)) {
				Piece piece = getPiece(pieces, left);
				if (piece != null && !sameColor(piece))
					moves.add(left);
			}
			int right = pos + 9;
			if (onBoard(right)) {
				Piece piece = getPiece(pieces, right);
				if (piece != null && !sameColor(piece))
					moves.add(right);
			}
		}
			break;
		case BlackPawn: {
			int forward = pos - 8;
			if (onBoard(forward)) {
				if (getPiece(pieces, forward) == null) {
					moves.add(forward);
					if (pos > 47 && pos < 56) {
						int forward2 = pos - 16;
						if (onBoard(forward2)) {
							if (getPiece(pieces, forward2) == null)
								moves.add(forward2);
						}
					}
				}
			}
			int left = pos - 7;
			if (onBoard(left)) {
				Piece piece = getPiece(pieces, left);
				if (piece != null && !sameColor(piece))
					moves.add(left);
			}
			int right = pos - 9;
			if (onBoard(right)) {
				Piece piece = getPiece(pieces, right);
				if (piece != null && !sameColor(piece))
					moves.add(right);
			}
		}
			break;

		default:
		}

	}

	public void repeatMove(HashSet<Piece> pieces, List<Integer> moves,
			int offset) {
		for (int i = pos; addMove(pieces, moves, offset,i); i += offset)
			;
	}

	/**
	 * Calculate is move is within borders return true if can continue like
	 * queen
	 * 
	 * @param pieces
	 * @param moves
	 * @param offset
	 * @return
	 */
	public boolean addMove(HashSet<Piece> pieces, List<Integer> moves,
			int offset, int from) {
		int i = from + offset;
		if (!onBoard(i, from))
			return false;
		Piece piece = getPiece(pieces, i);
		if (piece != null) {
			if (!sameColor(piece))
				moves.add(i);
			return false;
		}
		moves.add(i);
		return true;
	}

	public boolean addMove(HashSet<Piece> pieces, List<Integer> moves,
			int offset) {
		return addMove(pieces, moves, offset, pos);
	}

	public boolean sameColor(Piece piece) {
		return (piece.type.weight > 0) == (type.weight > 0);
	}

	public Piece getPiece(HashSet<Piece> pieces, int i) {
		for (Piece piece : pieces) {
			if (piece.pos == i)
				return piece;
		}
		return null;
	}

	public boolean onBoard(int i, int orig) {
		if (i < 0 || i > 63)
			return false;
		int x1 = i % 8;
		int x2 = orig % 8;
		if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
			return false;
		return true;
	}

	public boolean onBoard(int i) {
		return onBoard(i, pos);
	}

}