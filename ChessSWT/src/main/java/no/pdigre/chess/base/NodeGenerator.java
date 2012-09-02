package no.pdigre.chess.base;

public class NodeGenerator {

    final public static void loopLegalMoves(final IAdder adder, final int[] board, int inherit) {
        NodePull pull = new NodePull(board, inherit);
        int bitmap = pull.next();
        while (bitmap != 0) {
            if (Bitmap.isCapture(bitmap)) {
                if (Bitmap.isEnpassant(bitmap))
                    adder.enpassant(bitmap);
                else if (Bitmap.isPromotion(bitmap))
                    adder.capturePromote(bitmap);
                else
                    adder.capture(bitmap);
            } else {
                if (Bitmap.isCastling(bitmap))
                    adder.castling(bitmap);
                else if (Bitmap.isPromotion(bitmap))
                    adder.movePromote(bitmap);
                else
                    adder.move(bitmap);
            }
            bitmap = pull.next();
        }
    }

    final public static boolean hasLegalMoves(final int[] board, int inherit) {
        final boolean white = !Bitmap.white(inherit);
        final int kingpos = getKingPos(board, white);
        final int enpassant = Bitmap.getEnpassant(inherit);
        final int castling = Bitmap.getCastlingState(inherit);
        final int pawn_fwd = forward(white);
        final int pawn_left = pawn_fwd + BaseNodes.LEFT;
        final int pawn_right = pawn_fwd + BaseNodes.RIGHT;
        final int goalline = goalline(white);
        final int home = home(white);
        final int castle_rook = white ? IConst.ROOK : IConst.BLACK_ROOK;
        final boolean castle_queen = (castling & (white ? IConst.NOCASTLE_WHITEQUEEN : IConst.NOCASTLE_BLACKQUEEN)) == 0;
        final boolean castle_king = (castling & (white ? IConst.NOCASTLE_WHITEKING : IConst.NOCASTLE_BLACKKING)) == 0;

        for (int from = 0; from < 64; from++) {
            int sqr = board[from];
            if (sqr == 0 || white != Bitmap.white(sqr))
                continue;
            switch (sqr & 7) {
                case IConst.KNIGHT:
                    if (hasSimple(board, BaseNodes.KNIGHT_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case IConst.BISHOP:
                    if (hasSlider(board, BaseNodes.BISHOP_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case IConst.ROOK:
                    if (hasSlider(board, BaseNodes.ROOK_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case IConst.QUEEN:
                    if (hasSlider(board, BaseNodes.QUEEN_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    break;
                case IConst.KING:
                    if (hasSimple(board, BaseNodes.KING_MOVES[from], white, from, kingpos, inherit))
                        return true;
                    if (castle_queen) {
                        int to4 = home + 2;
                        if (board[home + 3] == 0 && board[to4] == 0 && board[home + 1] == 0
                            && board[home + 0] == castle_rook) {
                            if (checkSafe(board, home + 3, white) && checkSafe(board, home + 4, white)) {
                                int bitmap = Bitmap.bitCastling(board, from, inherit, to4);
                                boolean safe = isSafe(board, from, kingpos, to4, bitmap);
                                if (safe)
                                    return true;
                            }
                        }
                    }
                    if (castle_king) {
                        int to = home + 6;
                        if (board[home + 5] == 0 && board[to] == 0 && board[home + 7] == castle_rook) {
                            if (checkSafe(board, home + 4, white) && checkSafe(board, home + 5, white)) {
                                int bitmap = Bitmap.bitCastling(board, from, inherit, to);
                                boolean safe = isSafe(board, from, kingpos, to, bitmap);
                                if (safe)
                                    return true;
                            }
                        }
                    }
                    break;
                case IConst.PAWN: {
                    int to1 = from + pawn_fwd;
                    if (board[to1] == 0) {
                        if (to1 >= goalline && to1 < goalline + 8) {
                            int bitmap = Bitmap.bitPawnPromote(board, from, inherit, to1);
                            boolean safe = isSafe(board, from, kingpos, to1, bitmap);
                            if (safe) {
                                return true;
                            }
                        } else {
                            int bitmap = Bitmap.bitMove(from, inherit, to1, board[from]);
                            boolean safe = isSafe(board, from, kingpos, to1, bitmap);
                            if (safe)
                                return true;
                        }
                        if (from >= pawnline(white) && from < pawnline(white) + 8) {
                            int to2 = to1 + pawn_fwd;
                            if (board[to2] == 0) {
                                int bitmap = Bitmap.bitMove(from, inherit, to2, board[from]);
                                boolean safe = isSafe(board, from, kingpos, to2, bitmap);
                                if (safe)
                                    return true;
                            }
                        }
                    }
                    int x = from & 7;
                    if (x != 0) {
                        int to2 = from + pawn_left;
                        int piece = board[to2];
                        if (piece != 0) {
                            if (((piece & IConst.BLACK) != 0) == white) {
                                if (to2 >= goalline && to2 < goalline + 8) {
                                    int bitmap = Bitmap.bitPawnCapturePromote(board, from, inherit, to2);
                                    boolean safe = isSafe(board, from, kingpos, to2, bitmap);
                                    if (safe) {
                                        return true;
                                    }
                                } else {
                                    int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to2);
                                    boolean safe = isSafe(board, from, kingpos, to2, bitmap);
                                    if (safe)
                                        return true;
                                }
                            }
                        } else {
                            if (enpassant == to2) {
                                int bitmap = Bitmap.bitPawnEnpassant(board, from, inherit, to2);
                                boolean safe = isSafe(board, from, kingpos, to2, bitmap);
                                if (safe)
                                    return true;
                            }
                        }
                    }
                    if (x != 7) {
                        int to3 = from + pawn_right;
                        int piece = board[to3];
                        if (piece != 0) {
                            if (((piece & IConst.BLACK) != 0) == white) {
                                if (to3 >= goalline && to3 < goalline + 8) {
                                    int bitmap = Bitmap.bitPawnCapturePromote(board, from, inherit, to3);
                                    boolean safe = isSafe(board, from, kingpos, to3, bitmap);
                                    if (safe) {
                                        return true;
                                    }
                                } else {
                                    int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to3);
                                    boolean safe = isSafe(board, from, kingpos, to3, bitmap);
                                    if (safe)
                                        return true;
                                }
                            }
                        } else {
                            if (enpassant == to3) {
                                int bitmap = Bitmap.bitPawnEnpassant(board, from, inherit, to3);
                                boolean safe = isSafe(board, from, kingpos, to3, bitmap);
                                if (safe)
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
        int kingtype = white ? IConst.KING : IConst.BLACK_KING;
        for (int i = 0; i < 64; i++)
            if (board[i] == kingtype)
                return i;
        return 0;
    }

    final public static boolean checkSafe(int[] board, final int from, final boolean white) {
        int enemy = white ? IConst.BLACK_KNIGHT : IConst.KNIGHT;
        for (int pos : BaseNodes.KNIGHT_MOVES[from]) {
            if (board[pos] == enemy)
                return false;
        }
        enemy = white ? IConst.BLACK_KING : IConst.KING;
        for (int pos : BaseNodes.KING_MOVES[from]) {
            if (board[pos] == enemy)
                return false;
        }
        for (int[] slide : BaseNodes.BISHOP_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if (type == 0)
                    continue;
                if (((type & IConst.BLACK) == 0) == white)
                    break;
                int t = type & IConst.PIECETYPE;
                if (t == IConst.QUEEN || t == IConst.BISHOP)
                    return false;
                break;
            }
        }
        for (int[] slide : BaseNodes.ROOK_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if (type == 0)
                    continue;
                if (((type & IConst.BLACK) == 0) == white)
                    break;
                int t = type & IConst.PIECETYPE;
                if (t == IConst.QUEEN || t == IConst.ROOK)
                    return false;
                break;
            }
        }

        int x = from & 7;
        if (white) {
            if (from < 48) {
                if ((x != 0) && board[from + 7] == IConst.BLACK_PAWN)
                    return false;
                if ((x != 7) && board[from + 9] == IConst.BLACK_PAWN)
                    return false;
            }
        } else {
            if (from > 15) {
                if ((x != 0) && board[from - 9] == IConst.PAWN)
                    return false;
                if ((x != 7) && board[from - 7] == IConst.PAWN)
                    return false;
            }
        }
        return true;
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

    final private static boolean hasSlider(int[] board, int[][] moves, boolean white, int from, int kingpos,
        int inherit) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length; i++) {
                if (has(board, slide[i], white, from, inherit, kingpos))
                    return true;
            }
        }
        return false;
    }

    final private static boolean hasSimple(int[] board, int[] moves, boolean white, int from, int kingpos,
        int inherit) {
        for (int to : moves)
            if (has(board, to, white, from, inherit, kingpos))
                return true;
        return false;
    }

    final private static boolean has(int[] board, int to, boolean white, int from, int inherit, int kingpos) {
        int victim = board[to];
        if (victim == 0) {
            int bitmap = Bitmap.bitMove(from, inherit, to, board[from]);
            if (NodeGenerator.checkSafe(Bitmap.apply(board, bitmap), from == kingpos ? to : kingpos, Bitmap.white(bitmap)))
                return true;
        } else if (((victim & IConst.BLACK) == 0) != white) {
            int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to);
            if (NodeGenerator.checkSafe(Bitmap.apply(board, bitmap), from == kingpos ? to : kingpos, Bitmap.white(bitmap)))
                return true;
        }
        return false;
    }

    final private static boolean isSafe(int[] board, int from, int kingpos, int to, int bitmap) {
        return NodeGenerator.checkSafe(Bitmap.apply(board, bitmap), from == kingpos ? to : kingpos, Bitmap.white(bitmap));
    }
}
