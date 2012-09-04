package no.pdigre.chess.base;

public class NodePull {

    final private int[] moves=new int[28];

    final boolean white;

    final int kingpos;

    final int enpassant;

    final int pawn_fwd;

    final int pawn_left;

    final int pawn_right;

    final int goalline;

    final int home;

    final int castle_rook;

    final boolean castle_queen;

    final boolean castle_king;

    final int[] board;

    final int inherit;

    private int from = -1;

    private int sqr;

    private int imoves;

    public NodePull(int[] board, int inherit) {
        this.inherit = inherit;
        this.board = board;
        white = !Bitmap.white(inherit);
        kingpos = getKingPos(board, white);
        enpassant = Bitmap.getEnpassant(inherit);
        pawn_fwd = forward(white);
        pawn_left = pawn_fwd + BaseNodes.LEFT;
        pawn_right = pawn_fwd + BaseNodes.RIGHT;
        goalline = goalline(white);
        home = home(white);
        castle_rook = white ? IConst.ROOK : IConst.BLACK_ROOK;
        castle_queen = (inherit & (white ? IConst.NOCASTLE_WHITEQUEEN : IConst.NOCASTLE_BLACKQUEEN)) == 0;
        castle_king = (inherit & (white ? IConst.NOCASTLE_WHITEKING : IConst.NOCASTLE_BLACKKING)) == 0;
    }

    public int next() {
        if (imoves > 0)
            return moves[--imoves];
        do {
            from++;
            if (from == 64)
                return 0;
            sqr = board[from];
        } while (sqr == 0 || white != Bitmap.white(sqr));
        nextPiece();
        return next();
    }

    private void nextPiece() {
        switch (sqr & 7) {
            case IConst.KNIGHT:
                addSimple(board, BaseNodes.KNIGHT_MOVES[from], white, from, kingpos, inherit);
                break;
            case IConst.BISHOP:
                addSlider(board, BaseNodes.BISHOP_MOVES[from], white, from, kingpos, inherit);
                break;
            case IConst.ROOK:
                addSlider(board, BaseNodes.ROOK_MOVES[from], white, from, kingpos, inherit);
                break;
            case IConst.QUEEN:
                addSlider(board, BaseNodes.QUEEN_MOVES[from], white, from, kingpos, inherit);
                break;
            case IConst.KING:
                addSimple(board, BaseNodes.KING_MOVES[from], white, from, kingpos, inherit);
                if (castle_queen) {
                    int to4 = home + 2;
                    if (board[home + 3] == 0 && board[to4] == 0 && board[home + 1] == 0
                        && board[home + 0] == castle_rook) {
                        if (checkSafe(board, home + 3, white) && checkSafe(board, home + 4, white)) {
                            int bitmap = Bitmap.bitCastling(board, from, inherit, to4);
                            if (isSafe(board, from, kingpos, to4, bitmap))
                                add(bitmap);
                        }
                    }
                }
                if (castle_king) {
                    int to = home + 6;
                    if (board[home + 5] == 0 && board[to] == 0 && board[home + 7] == castle_rook) {
                        if (checkSafe(board, home + 4, white) && checkSafe(board, home + 5, white)) {
                            int bitmap = Bitmap.bitCastling(board, from, inherit, to);
                            if (isSafe(board, from, kingpos, to, bitmap))
                                add(bitmap);
                        }
                    }
                }
                break;
            case IConst.PAWN: {
                int to1 = from + pawn_fwd;
                if (board[to1] == 0) {
                    if (to1 >= goalline && to1 < goalline + 8) {
                        int bitmap = Bitmap.bitPawnPromote(board, from, inherit, to1);
                        if (isSafe(board, from, kingpos, to1, bitmap)) {
                            add(bitmap | IConst.QUEEN);
                            add(bitmap | IConst.ROOK);
                            add(bitmap | IConst.KNIGHT);
                            add(bitmap | IConst.BISHOP);
                        }
                    } else {
                        int bitmap = Bitmap.bitMove(from, inherit, to1, board[from]);
                        if (isSafe(board, from, kingpos, to1, bitmap))
                            add(bitmap);
                    }
                    if (from >= pawnline(white) && from < pawnline(white) + 8) {
                        int to2 = to1 + pawn_fwd;
                        if (board[to2] == 0) {
                            int bitmap = Bitmap.bitMove(from, inherit, to2, board[from]);
                            if (isSafe(board, from, kingpos, to2, bitmap))
                                add(bitmap);
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
                                if (isSafe(board, from, kingpos, to2, bitmap)) {
                                    add(bitmap | IConst.QUEEN);
                                    add(bitmap | IConst.ROOK);
                                    add(bitmap | IConst.KNIGHT);
                                    add(bitmap | IConst.BISHOP);
                                }
                            } else {
                                int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to2);
                                if (isSafe(board, from, kingpos, to2, bitmap))
                                    add(bitmap);
                            }
                        }
                    } else {
                        if (enpassant == to2) {
                            int bitmap = Bitmap.bitPawnEnpassant(board, from, inherit, to2);
                            if (isSafe(board, from, kingpos, to2, bitmap))
                                add(bitmap);
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
                                if (isSafe(board, from, kingpos, to3, bitmap)) {
                                    add(bitmap | IConst.QUEEN);
                                    add(bitmap | IConst.ROOK);
                                    add(bitmap | IConst.KNIGHT);
                                    add(bitmap | IConst.BISHOP);
                                }
                            } else {
                                int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to3);
                                if (isSafe(board, from, kingpos, to3, bitmap))
                                    add(bitmap);
                            }
                        }
                    } else {
                        if (enpassant == to3) {
                            int bitmap = Bitmap.bitPawnEnpassant(board, from, inherit, to3);
                            if (isSafe(board, from, kingpos, to3, bitmap))
                                add(bitmap);
                        }
                    }
                }
                break;
            }
        }
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

    final private void addSlider(int[] board, int[][] moves, boolean white, int from, int kingpos, int inherit) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length && add(board, slide[i], white, from, inherit, kingpos); i++) {
                // not
            }
        }
    }

    final private void addSimple(int[] board, int[] moves, boolean white, int from, int kingpos, int inherit) {
        for (int to : moves)
            add(board, to, white, from, inherit, kingpos);
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
    final private boolean add(int[] board, int to, boolean white, int from, int inherit, int kingpos) {
        int victim = board[to];
        if (victim == 0) {
            int bitmap = Bitmap.bitMove(from, inherit, to, board[from]);
            if (isSafe(board, from, kingpos, to, bitmap))
                add(bitmap);
        } else if (((victim & IConst.BLACK) == 0) != white) {
            int bitmap = Bitmap.bitPawnCapture(board, from, inherit, to);
            if (isSafe(board, from, kingpos, to, bitmap))
                add(bitmap);
        }
        return victim == 0;
    }

    final private static boolean isSafe(int[] board, int from, int kingpos, int to, int bitmap) {
        return NodePull.checkSafe(Bitmap.apply(board, bitmap), from == kingpos ? to : kingpos,
            Bitmap.white(bitmap));
    }

    final public static boolean isCheck(int[] board, boolean white) {
        return !NodePull.checkSafe(board, getKingPos(board, white), white);
    }

    final private void add(int bitmap) {
        moves[imoves] = bitmap;
        imoves++;
    }

    public static int[] getAllNodes(final int[] board, int parent) {
        int length = 0;
        int[] array = new int[100];
        NodePull pull = new NodePull(board, parent);
        int bitmap = pull.next();
        while (bitmap != 0) {
            array[length] = bitmap;
            length++;
            bitmap = pull.next();
        }
        int[] ret = new int[length];
        System.arraycopy(array, 0, ret, 0, length);
        return ret;
    }

}
