package no.pdigre.chess.base;

import no.pdigre.chess.eval.MoveBitmap;

public class NodeGenerator {

    final public static void loopLegalMoves(final IAdder adder, final int[] board, int inherit) {
        final boolean white = !MoveBitmap.white(inherit);
        final int kingpos = getKingPos(board, white);
        final int enpassant = MoveBitmap.getEnpassant(inherit);
        final int castling = MoveBitmap.getCastlingState(inherit);
        final int pawn_fwd = forward(white);
        final int pawn_left = pawn_fwd + BaseNodes.LEFT;
        final int pawn_right = pawn_fwd + BaseNodes.RIGHT;
        final int goalline = goalline(white);
        final int home = home(white);
        final int castle_rook = white ? INode.ROOK : INode.BLACK_ROOK;
        final boolean castle_queen = (castling & (white ? INode.NOCASTLE_WHITEQUEEN : INode.NOCASTLE_BLACKQUEEN)) == 0;
        final boolean castle_king = (castling & (white ? INode.NOCASTLE_WHITEKING : INode.NOCASTLE_BLACKKING)) == 0;

        for (int from = 0; from < 64; from++) {
            int sqr = board[from];
            if (sqr == 0 || white != MoveBitmap.white(sqr))
                continue;
            switch (sqr & 7) {
                case INode.KNIGHT:
                    addSimple(adder, board, BaseNodes.KNIGHT_MOVES[from], white, from, kingpos, inherit);
                    break;
                case INode.BISHOP:
                    addSlider(adder, board, BaseNodes.BISHOP_MOVES[from], white, from, kingpos, inherit);
                    break;
                case INode.ROOK:
                    addSlider(adder, board, BaseNodes.ROOK_MOVES[from], white, from, kingpos, inherit);
                    break;
                case INode.QUEEN:
                    addSlider(adder, board, BaseNodes.QUEEN_MOVES[from], white, from, kingpos, inherit);
                    break;
                case INode.KING:
                    addSimple(adder, board, BaseNodes.KING_MOVES[from], white, from, kingpos, inherit);
                    if (castle_queen) {
                        int to4 = home + 2;
                        if (board[home + 3] == 0 && board[to4] == 0 && board[home + 1] == 0
                            && board[home + 0] == castle_rook) {
                            if (checkSafe(board, home + 3, white) && checkSafe(board, home + 4, white)) {
                                int bitmap = MoveBitmap.bitCastling(board, from, inherit, to4);
                                if (isSafe(board, from, kingpos, to4, bitmap))
                                    adder.castling(bitmap);
                            }
                        }
                    }
                    if (castle_king) {
                        int to = home + 6;
                        if (board[home + 5] == 0 && board[to] == 0 && board[home + 7] == castle_rook) {
                            if (checkSafe(board, home + 4, white) && checkSafe(board, home + 5, white)) {
                                int bitmap = MoveBitmap.bitCastling(board, from, inherit, to);
                                if (isSafe(board, from, kingpos, to, bitmap))
                                    adder.castling(bitmap);
                            }
                        }
                    }
                    break;
                case INode.PAWN: {
                    int to1 = from + pawn_fwd;
                    if (board[to1] == 0) {
                        if (to1 >= goalline && to1 < goalline + 8) {
                            int bitmap = MoveBitmap.bitPawnPromote(board, from, inherit, to1);
                            if (isSafe(board, from, kingpos, to1, bitmap)) {
                                adder.movePromote(bitmap | INode.QUEEN);
                                adder.movePromote(bitmap | INode.ROOK);
                                adder.movePromote(bitmap | INode.KNIGHT);
                                adder.movePromote(bitmap | INode.BISHOP);
                            }
                        } else {
                            int bitmap = MoveBitmap.bitMove(from, inherit, to1, board[from]);
                            if (isSafe(board, from, kingpos, to1, bitmap))
                                adder.move(bitmap);
                        }
                        if (from >= pawnline(white) && from < pawnline(white) + 8) {
                            int to2 = to1 + pawn_fwd;
                            if (board[to2] == 0) {
                                int bitmap = MoveBitmap.bitMove(from, inherit, to2, board[from]);
                                if (isSafe(board, from, kingpos, to2, bitmap))
                                    adder.move(bitmap);
                            }
                        }
                    }
                    int x = from & 7;
                    if (x != 0) {
                        int to2 = from + pawn_left;
                        int piece = board[to2];
                        if (piece != 0) {
                            if (((piece & INode.BLACK) != 0) == white) {
                                if (to2 >= goalline && to2 < goalline + 8) {
                                    int bitmap = MoveBitmap.bitPawnCapturePromote(board, from, inherit, to2);
                                    if (isSafe(board, from, kingpos, to2, bitmap)) {
                                        adder.capturePromote(bitmap | INode.QUEEN);
                                        adder.capturePromote(bitmap | INode.ROOK);
                                        adder.capturePromote(bitmap | INode.KNIGHT);
                                        adder.capturePromote(bitmap | INode.BISHOP);
                                    }
                                } else {
                                    int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to2);
                                    if (isSafe(board, from, kingpos, to2, bitmap))
                                        adder.capture(bitmap);
                                }
                            }
                        } else {
                            if (enpassant == to2) {
                                int bitmap = MoveBitmap.bitPawnEnpassant(board, from, inherit, to2);
                                if (isSafe(board, from, kingpos, to2, bitmap))
                                    adder.enpassant(bitmap);
                            }
                        }
                    }
                    if (x != 7) {
                        int to3 = from + pawn_right;
                        int piece = board[to3];
                        if (piece != 0) {
                            if (((piece & INode.BLACK) != 0) == white) {
                                if (to3 >= goalline && to3 < goalline + 8) {
                                    int bitmap = MoveBitmap.bitPawnCapturePromote(board, from, inherit, to3);
                                    if (isSafe(board, from, kingpos, to3, bitmap)) {
                                        adder.capturePromote(bitmap | INode.QUEEN);
                                        adder.capturePromote(bitmap | INode.ROOK);
                                        adder.capturePromote(bitmap | INode.KNIGHT);
                                        adder.capturePromote(bitmap | INode.BISHOP);
                                    }
                                } else {
                                    int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to3);
                                    if (isSafe(board, from, kingpos, to3, bitmap))
                                        adder.capture(bitmap);
                                }
                            }
                        } else {
                            if (enpassant == to3) {
                                int bitmap = MoveBitmap.bitPawnEnpassant(board, from, inherit, to3);
                                if (isSafe(board, from, kingpos, to3, bitmap))
                                    adder.enpassant(bitmap);
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    final public static boolean hasLegalMoves(final int[] board, int inherit) {
        final boolean white = !MoveBitmap.white(inherit);
        final int kingpos = getKingPos(board, white);
        final int enpassant = MoveBitmap.getEnpassant(inherit);
        final int castling = MoveBitmap.getCastlingState(inherit);
        final int pawn_fwd = forward(white);
        final int pawn_left = pawn_fwd + BaseNodes.LEFT;
        final int pawn_right = pawn_fwd + BaseNodes.RIGHT;
        final int goalline = goalline(white);
        final int home = home(white);
        final int castle_rook = white ? INode.ROOK : INode.BLACK_ROOK;
        final boolean castle_queen = (castling & (white ? INode.NOCASTLE_WHITEQUEEN : INode.NOCASTLE_BLACKQUEEN)) == 0;
        final boolean castle_king = (castling & (white ? INode.NOCASTLE_WHITEKING : INode.NOCASTLE_BLACKKING)) == 0;

        for (int from = 0; from < 64; from++) {
            int sqr = board[from];
            if (sqr == 0 || white != MoveBitmap.white(sqr))
                continue;
            switch (sqr & 7) {
                case INode.KNIGHT:
                    if (hasSimple(board, BaseNodes.KNIGHT_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case INode.BISHOP:
                    if (hasSlider(board, BaseNodes.BISHOP_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case INode.ROOK:
                    if (hasSlider(board, BaseNodes.ROOK_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case INode.QUEEN:
                    if (hasSlider(board, BaseNodes.QUEEN_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case INode.KING:
                    if (hasSimple(board, BaseNodes.KING_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    if (castle_queen) {
                        int to4 = home + 2;
                        if (board[home + 3] == 0 && board[to4] == 0 && board[home + 1] == 0
                            && board[home + 0] == castle_rook) {
                            if (checkSafe(board, home + 3, white) && checkSafe(board, home + 4, white)) {
                                int bitmap = MoveBitmap.bitCastling(board, from, inherit, to4);
                                if (isSafe(board, from, kingpos, to4, bitmap))
                                    return true;
                            }
                        }
                    }
                    if (castle_king) {
                        int to = home + 6;
                        if (board[home + 5] == 0 && board[to] == 0 && board[home + 7] == castle_rook) {
                            if (checkSafe(board, home + 4, white) && checkSafe(board, home + 5, white)) {
                                int bitmap = MoveBitmap.bitCastling(board, from, inherit, to);
                                if (isSafe(board, from, kingpos, to, bitmap))
                                    return true;
                            }
                        }
                    }
                    break;
                case INode.PAWN: {
                    int to1 = from + pawn_fwd;
                    if (board[to1] == 0) {
                        if (to1 >= goalline && to1 < goalline + 8) {
                            int bitmap = MoveBitmap.bitPawnPromote(board, from, inherit, to1);
                            if (isSafe(board, from, kingpos, to1, bitmap)) {
                                return true;
                            }
                        } else {
                            int bitmap = MoveBitmap.bitMove(from, inherit, to1, board[from]);
                            if (isSafe(board, from, kingpos, to1, bitmap))
                                return true;
                        }
                        if (from >= pawnline(white) && from < pawnline(white) + 8) {
                            int to2 = to1 + pawn_fwd;
                            if (board[to2] == 0) {
                                int bitmap = MoveBitmap.bitMove(from, inherit, to2, board[from]);
                                if (isSafe(board, from, kingpos, to2, bitmap))
                                    return true;
                            }
                        }
                    }
                    int x = from & 7;
                    if (x != 0) {
                        int to2 = from + pawn_left;
                        int piece = board[to2];
                        if (piece != 0) {
                            if (((piece & INode.BLACK) != 0) == white) {
                                if (to2 >= goalline && to2 < goalline + 8) {
                                    int bitmap = MoveBitmap.bitPawnCapturePromote(board, from, inherit, to2);
                                    if (isSafe(board, from, kingpos, to2, bitmap)) {
                                        return true;
                                    }
                                } else {
                                    int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to2);
                                    if (isSafe(board, from, kingpos, to2, bitmap))
                                        return true;
                                }
                            }
                        } else {
                            if (enpassant == to2) {
                                int bitmap = MoveBitmap.bitPawnEnpassant(board, from, inherit, to2);
                                if (isSafe(board, from, kingpos, to2, bitmap))
                                    return true;
                            }
                        }
                    }
                    if (x != 7) {
                        int to3 = from + pawn_right;
                        int piece = board[to3];
                        if (piece != 0) {
                            if (((piece & INode.BLACK) != 0) == white) {
                                if (to3 >= goalline && to3 < goalline + 8) {
                                    int bitmap = MoveBitmap.bitPawnCapturePromote(board, from, inherit, to3);
                                    if (isSafe(board, from, kingpos, to3, bitmap)) {
                                        return true;
                                    }
                                } else {
                                    int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to3);
                                    if (isSafe(board, from, kingpos, to3, bitmap))
                                        return true;
                                }
                            }
                        } else {
                            if (enpassant == to3) {
                                int bitmap = MoveBitmap.bitPawnEnpassant(board, from, inherit, to3);
                                if (isSafe(board, from, kingpos, to3, bitmap))
                                    return true;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return false;
    }

    final public static int getKingPos(final int[] board, boolean white) {
        int kingtype = white ? INode.KING : INode.BLACK_KING;
        for (int i = 0; i < 64; i++)
            if (board[i] == kingtype)
                return i;
        return 0;
    }

    final public static boolean checkSafe(int[] board, final int from, final boolean white) {
        int enemy = white ? INode.BLACK_KNIGHT : INode.KNIGHT;
        for (int pos : BaseNodes.KNIGHT_MOVES[from]) {
            if (board[pos] == enemy)
                return false;
        }
        enemy = white ? INode.BLACK_KING : INode.KING;
        for (int pos : BaseNodes.KING_MOVES[from]) {
            if (board[pos] == enemy)
                return false;
        }
        for (int[] slide : BaseNodes.BISHOP_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if (type == 0)
                    continue;
                if (((type & INode.BLACK) == 0) == white)
                    break;
                int t = type & INode.PIECETYPE;
                if (t == INode.QUEEN || t == INode.BISHOP)
                    return false;
                break;
            }
        }
        for (int[] slide : BaseNodes.ROOK_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if (type == 0)
                    continue;
                if (((type & INode.BLACK) == 0) == white)
                    break;
                int t = type & INode.PIECETYPE;
                if (t == INode.QUEEN || t == INode.ROOK)
                    return false;
                break;
            }
        }

        int x = from & 7;
        if (white) {
            if (from < 48) {
                if ((x != 0) && board[from + 7] == INode.BLACK_PAWN)
                    return false;
                if ((x != 7) && board[from + 9] == INode.BLACK_PAWN)
                    return false;
            }
        } else {
            if (from > 15) {
                if ((x != 0) && board[from - 9] == INode.PAWN)
                    return false;
                if ((x != 7) && board[from - 7] == INode.PAWN)
                    return false;
            }
        }
        return true;
    }

    final public static boolean checkSafe(int i) {
        return i == 0;
    }

    final private static int home(boolean white) {
        return white ? 0 : 56;
    }

    final private static int forward(boolean white) {
        return white ? 8 : -8;
    }

    final private static int pawnline(boolean white) {
        return white ? 8 : 48;
    }

    final private static int goalline(boolean white) {
        return white ? 56 : 0;
    }

    final private static void addSlider(IAdder imoves, int[] board, int[][] moves, boolean white, int from,
        int kingpos, int inherit) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length && add(imoves, board, slide[i], white, from, inherit, kingpos); i++) {
                // not
            }
        }
    }

    final private static boolean hasSlider(int[] board, int[][] moves, boolean white, int from, int kingpos, int inherit) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length; i++) {
                if (has(board, slide[i], white, from, inherit, kingpos))
                    return true;
            }
        }
        return false;
    }

    final private static void addSimple(IAdder imoves, int[] board, int[] moves, boolean white, int from,
        int kingpos, int inherit) {
        for (int to : moves)
            add(imoves, board, to, white, from, inherit, kingpos);
    }

    final private static boolean hasSimple(int[] board, int[] moves, boolean white, int from, int kingpos, int inherit) {
        for (int to : moves)
            if (has(board, to, white, from, inherit, kingpos))
                return true;
        return false;
    }

    /**
     * Calculate is move is within borders return true if can continue like
     * queen
     * 
     * @param moves
     * @param from TODO
     * @param inherit TODO
     * @param kingpos TODO
     * @param offset
     * @param pieces
     * @return
     */
    final private static boolean add(IAdder moves, int[] board, int to, boolean white, int from, int inherit,
        int kingpos) {
        int victim = board[to];
        if (victim == 0) {
            int bitmap = MoveBitmap.bitMove(from, inherit, to, board[from]);
            if (isSafe(board, from, kingpos, to, bitmap))
                moves.move(bitmap);
        } else if (((victim & INode.BLACK) == 0) != white) {
            int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to);
            if (isSafe(board, from, kingpos, to, bitmap))
                moves.capture(bitmap);
        }
        return victim == 0;
    }

    final private static boolean has(int[] board, int to, boolean white, int from, int inherit, int kingpos) {
        int victim = board[to];
        if (victim == 0) {
            int bitmap = MoveBitmap.bitMove(from, inherit, to, board[from]);
            if (isSafe(board, from, kingpos, to, bitmap))
                return true;
        } else if (((victim & INode.BLACK) == 0) != white) {
            int bitmap = MoveBitmap.bitPawnCapture(board, from, inherit, to);
            if (isSafe(board, from, kingpos, to, bitmap))
                return true;
        }
        return false;
    }

    final private static boolean isSafe(int[] board, int from, int kingpos, int to, int bitmap) {
        return NodeGenerator.checkSafe(MoveBitmap.apply(board, bitmap), from == kingpos ? to : kingpos,
            MoveBitmap.white(bitmap));
    }

    final public static boolean isCheck(int[] board, boolean white) {
        return !NodeGenerator.checkSafe(board, getKingPos(board, white), white);
    }

}
