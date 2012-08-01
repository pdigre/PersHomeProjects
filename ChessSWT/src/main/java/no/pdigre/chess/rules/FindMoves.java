package no.pdigre.chess.rules;


public class FindMoves {
    
    final static boolean white(int bitmap) {
        return (bitmap & IMove.ISBLACK) == 0;
    }

    final private static int home(int bitmap) {
        return white(bitmap) ? 0 : 56;
    }

    final static int forward(int bitmap) {
        return white(bitmap) ? 8 : -8;
    }

    final static int pawnline(int bitmap) {
        return white(bitmap) ? 8 : 48;
    }

    final static int goalline(int bitmap) {
        return white(bitmap) ? 56 : 0;
    }

    final public static PieceType getPieceType(char fen) {
        for (PieceType type : PieceType.values()) {
            if (type.fen == fen)
                return type;
        }
        return null;
    }

    final public static void addMovesForPiece(int bitmap, IAdder adder, int[] board, int piece) {
        final int from = Move.getPos(piece);
        switch (bitmap & 7) {
            case IMove.PAWN:
                int fwd = forward(bitmap);
                pawnForward(adder, board, from, fwd, bitmap);
                int enpassant = adder.getEnpassant();
                pawnBeat(adder, board, from, enpassant, fwd + BaseMoves.LEFT, bitmap);
                pawnBeat(adder, board, from, enpassant, fwd + BaseMoves.RIGHT, bitmap);
                break;
            case IMove.KNIGHT:
                addSimple(adder, board, BaseMoves.KNIGHT_MOVES[from], bitmap);
                break;
            case IMove.BISHOP:
                addSlider(adder, board, BaseMoves.BISHOP_MOVES[from], bitmap);
                break;
            case IMove.ROOK:
                addSlider(adder, board, BaseMoves.ROOK_MOVES[from], bitmap);
                break;
            case IMove.QUEEN:
                addSlider(adder, board, BaseMoves.QUEEN_MOVES[from], bitmap);
                break;
            case IMove.KING:
                addSimple(adder, board, BaseMoves.KING_MOVES[from], bitmap);
                if (white(bitmap)) {
                    if ((adder.getCastlingState() & IMove.NOCASTLE_BLACKQUEEN) == 0)
                        castlingQueen(adder, board, from, IMove.BLACK_ROOK, bitmap);
                    if ((adder.getCastlingState() & IMove.NOCASTLE_BLACKKING) == 0)
                        castlingKing(adder, board, from, IMove.BLACK_ROOK, bitmap);
                } else {
                    if ((adder.getCastlingState() & IMove.NOCASTLE_WHITEQUEEN) == 0)
                        castlingQueen(adder, board, from, IMove.ROOK, bitmap);
                    if ((adder.getCastlingState() & IMove.NOCASTLE_WHITEKING) == 0)
                        castlingKing(adder, board, from, IMove.ROOK, bitmap);
                }
                break;
        }
    }

    final private static void addSlider(IAdder imoves, int[] board, int[][] moves, int bitmap) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length && add(imoves, board, slide[i], bitmap); i++) {
                // not
            }
        }
    }

    final private static void addSimple(IAdder imoves, int[] board, int[] moves, int bitmap) {
        for (int to : moves)
            add(imoves, board, to, bitmap);
    }

    /**
     * Calculate is move is within borders return true if can continue like
     * queen
     * 
     * @param moves
     * @param offset
     * @param pieces
     * @return
     */
    final private static boolean add(IAdder moves, int[] board, int to, int bitmap) {
        int victim = board[to];
        if (victim == 0)
            moves.move(to);
        else if (((victim & IMove.ISBLACK) == 0) != white(bitmap))
            moves.beat(to);
        else
            moves.support(to);
        return victim == 0;
    }

    /**
     * is it inside the board = legal move
     * 
     * @param i
     * @param from
     * @return
     */
    final private static boolean inside(int i, int from) {
        if (i < 0 || i > 63)
            return false;
        int x1 = i % 8;
        int x2 = from % 8;
        if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
            return false;
        return true;
    }

    final private static void pawnBeat(IAdder moves, int[] board, int from, int enpassant, int leftright,
        int bitmap) {
        int to = from + leftright;
        if (inside(to, from)) {
            int piece = board[to];
            if (piece != 0) {
                if (((piece & IMove.ISBLACK) == 0) == white(bitmap))
                    moves.support(to);
                else if (to >= goalline(bitmap) && to < goalline(bitmap) + 8)
                    moves.beatTrade(to);
                else
                    moves.beat(to);
            } else {
                if (enpassant == to)
                    moves.enpassant(to);
            }
        }
    }

    final private static void pawnForward(IAdder moves, int[] board, int from, int mv, int bitmap) {
        int to1 = from + mv;
        if (inside(to1, from)) {
            if (board[to1] == 0) {
                if (to1 >= goalline(bitmap) && to1 < goalline(bitmap) + 8)
                    moves.moveTrade(to1);
                else
                    moves.move(to1);
                if (from >= pawnline(bitmap) && from < pawnline(bitmap) + 8) {
                    int to2 = from + mv + mv;
                    if (inside(to2, from)) {
                        if (board[to2] == 0)
                            moves.move(to2);
                    }
                }
            }
        }
    }

    final private static void castlingKing(IAdder moves, int[] board, int from, int rook, int bitmap) {
        if (board[home(bitmap) + 5] == 0 && board[home(bitmap) + 6] == 0 && board[home(bitmap) + 7] == rook) {
            if (checkSafe(home(bitmap) + 4) && checkSafe(home(bitmap) + 5))
                add(moves, board, from, 2);
        }
    }

    final private static void castlingQueen(final IAdder moves, final int[] board, int from, int rook, int bitmap) {
        if (board[home(bitmap) + 3] == 0 && board[home(bitmap) + 2] == 0 && board[home(bitmap) + 1] == 0
            && board[home(bitmap) + 0] == rook) {
            if (checkSafe(home(bitmap) + 3) && checkSafe(home(bitmap) + 4))
                add(moves, board, from, -2);
        }
    }

    final public static boolean checkSafe(int i) {
        return true;
    }

}
