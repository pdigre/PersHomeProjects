package no.pdigre.chess.rules;

import java.util.ArrayList;
import java.util.List;

public class EvalMove {

	public final static int NOCASTLE_WHITEKING = 1 << 1;
	public final static int NOCASTLE_WHITEQUEEN = 1 << 2;
	public final static int NOCASTLE_BLACKKING = 1 << 3;
	public final static int NOCASTLE_BLACKQUEEN = 1 << 4;
	public final static int ILLEGAL = 1 << 5;
	public final static int CHECK = 1 << 6;
	public final static int MATE = 1 << 7;

	public int state;
	public final AbstractMove move;
	public float score;

	public EvalMove(int pstate, final Move move) {
		this.move = move;
		if (move != null)
			state = move.breakCastle(pstate & 15);
	}

	public EvalMove(final StartGame move) {
		this.move = move;
	}

	public ArrayList<Move> findMoves(final int[] board, Piece pieces) {
		final ArrayList<Move> moves = new ArrayList<Move>();
		final boolean whiteTurn = move.whiteTurn();
		while (pieces != null) {
			final int type = pieces.getType();
			final int from = pieces.pos;
			if (((type & AbstractMove.ISBLACK) == 0)== whiteTurn) {
				final ArrayList<Move> next = new ArrayList<Move>();
				IMoves adder = new IMoves() {

					@Override
					public void move(int to) {
						next.add(new Move(from, to, type, move));
					}

					@Override
					public void moveTrade(int to) {
						next.add(new MovePromote(from, to, type, move,
								whiteTurn ? AbstractMove.QUEEN
										: AbstractMove.BLACK_QUEEN));
						next.add(new MovePromote(from, to, type, move,
								whiteTurn ? AbstractMove.KNIGHT
										: AbstractMove.BLACK_KNIGHT));
						next.add(new MovePromote(from, to, type, move,
								whiteTurn ?AbstractMove.ROOK
										: AbstractMove.BLACK_ROOK));
						next.add(new MovePromote(from, to, type, move,
								whiteTurn ? AbstractMove.BISHOP
										: AbstractMove.BLACK_BISHOP));
					}

					@Override
					public void support(int to) {
						// not
					}

					@Override
					public void beat(int to) {
						next.add(new Capture(from, to, type, move, board[to]));
					}

					@Override
					public void beatTrade(int to) {
						int victim = board[to];
						next.add(new CapturePromote(from, to, type, move,
								victim, whiteTurn ? AbstractMove.QUEEN : AbstractMove.BLACK_QUEEN));
						next.add(new CapturePromote(from, to, type, move,
								victim, whiteTurn ? AbstractMove.KNIGHT : AbstractMove.BLACK_KNIGHT));
						next.add(new CapturePromote(from, to, type, move,
								victim, whiteTurn ? AbstractMove.ROOK : AbstractMove.BLACK_ROOK));
						next.add(new CapturePromote(from, to, type, move,
								victim, whiteTurn ? AbstractMove.BISHOP : AbstractMove.BLACK_BISHOP));
					}

					@Override
					public void enpassant(int to) {
						int enpassant = getEnpassant();
						next.add(new EnPassant(from, to, type, move,
								board[enpassant - PieceType.forward(type)]));
					}

					@Override
					public void castling(int to) {
						next.add(new Castling(from, to, type, move));
					}

					@Override
					public int getEnpassant() {
						return move.getEnpassant();
					}

					@Override
					public int getState() {
						return state;
					}

				};
				PieceType.addAll(type,adder, board, pieces.pos);

				// Check King in check position
				for (Move to : next) {
					if (to instanceof Capture) {
						int victim = (to.bitmap>>4)&7;
						if (victim == AbstractMove.KING) {
							state |= ILLEGAL;
							return moves;
						}
					}
					moves.add(to);
				}
			}
			pieces = pieces.link;
		}
		return moves;
	}

	public boolean think(int level) {
		if (level == 0)
			return true;
		ArrayList<Move> moves = findMoves(move.getBoard(), move.getPieces());
		if ((state & ILLEGAL) != 0)
			return false;
		for (Move mv : new ArrayList<Move>(moves)) {
			EvalMove eval = new EvalMove(state, mv);
			if (!eval.think(level - 1))
				moves.remove(eval);
		}
		return true;
	}

	@Override
	public String toString() {
		EvaluateBoard score = new EvaluateBoard(this, move.getBoard(),
				move.getPieces());
		if (score.wCheck || score.bCheck)
			return move.toString() + " check";
		return move.toString();
	}

	public List<Integer> getLegalMoves(Piece piece) {
		ArrayList<Move> moves = searchLegalMoves();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Move mv : moves) {
			if (mv.getFrom() == piece.pos)
				list.add(mv.getTo());
		}
		return list;
	}

	public ArrayList<Move> searchLegalMoves() {
		int[] board = move.getBoard();
		Piece pieces = move.getPieces();
		ArrayList<Move> moves = findMoves(board, pieces);
		if ((ILLEGAL & state) == 0) {
			for (Move mv : new ArrayList<Move>(moves)) {
				EvalMove eval = new EvalMove(state, mv);
				eval.findMoves(mv.getBoard(), mv.getPieces());
				if ((ILLEGAL & eval.state) != 0)
					moves.remove(mv);
			}
		}
		if ((ILLEGAL & state) != 0 || moves.size() == 0) {
			System.out.println("No moves");
			EvaluateBoard score = new EvaluateBoard(this, board, pieces);
			if (score.wCheck || score.bCheck)
				System.out.println("Check mate!");
			else
				System.out.println("Stale mate!");
		}
		return moves;
	}

	public Move move(int from, int to) {
		for (Move mv : findMoves(move.getBoard(), move.getPieces())) {
			if (mv.getFrom() == from && mv.getTo() == to)
				return mv;
		}
		return null;
	}

}
