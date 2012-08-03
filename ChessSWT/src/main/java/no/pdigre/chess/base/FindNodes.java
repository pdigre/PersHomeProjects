package no.pdigre.chess.base;

import no.pdigre.chess.moves.PieceType;

public class FindNodes {

    /**
     * Main entry for calculating moves
     * 
     * @param adder
     * @param board
     * @param piece
     */
    final public static void addMovesForPiece(IAdder adder, int[] board, final int from, int type,int enpassant,int castling) {
        boolean white = white(type);
        switch (type & 7) {
            case INode.PAWN:
                int fwd = forward(white);
                pawnForward(adder, board, from, fwd, white);
                pawnBeat(adder, board, from, enpassant, fwd + BaseNodes.LEFT, white);
                pawnBeat(adder, board, from, enpassant, fwd + BaseNodes.RIGHT, white);
                break;
            case INode.KNIGHT:
                addSimple(adder, board, BaseNodes.KNIGHT_MOVES[from], white);
                break;
            case INode.BISHOP:
                addSlider(adder, board, BaseNodes.BISHOP_MOVES[from], white);
                break;
            case INode.ROOK:
                addSlider(adder, board, BaseNodes.ROOK_MOVES[from], white);
                break;
            case INode.QUEEN:
                addSlider(adder, board, BaseNodes.QUEEN_MOVES[from], white);
                break;
            case INode.KING:
                addSimple(adder, board, BaseNodes.KING_MOVES[from], white);
                if (white) {
                    if ((castling & INode.NOCASTLE_WHITEQUEEN) == 0)
                        castlingQueen(adder, board, INode.ROOK, white);
                    if ((castling & INode.NOCASTLE_WHITEKING) == 0)
                        castlingKing(adder, board, INode.ROOK, white);
                } else {
                    if ((castling & INode.NOCASTLE_BLACKQUEEN) == 0)
                        castlingQueen(adder, board, INode.BLACK_ROOK, white);
                    if ((castling & INode.NOCASTLE_BLACKKING) == 0)
                        castlingKing(adder, board, INode.BLACK_ROOK, white);
                }
                break;
        }
    }
    
    final public static boolean checkSafe(int[] board, final int from,final boolean white) {
        int enemy=white?INode.BLACK_KNIGHT:INode.KNIGHT;
        for (int pos : BaseNodes.KNIGHT_MOVES[from]) {
            if(board[pos]==enemy)
                return false;
        }
        enemy=white?INode.BLACK_KING:INode.KING;
        for (int pos : BaseNodes.KING_MOVES[from]) {
            if(board[pos]==enemy)
                return false;
        }
        for (int[] slide : BaseNodes.BISHOP_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if(type==0)
                    continue;
                if(((type&INode.BLACK)==0)==white)
                    break;
                int t = type&INode.PIECETYPE;
                if(t==INode.QUEEN || t==INode.BISHOP)
                    return false;
                break;
            }
        }
        for (int[] slide : BaseNodes.ROOK_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
                if(type==0)
                    continue;
                if(((type&INode.BLACK)==0)==white)
                    break;
                int t = type&INode.PIECETYPE;
                if(t==INode.QUEEN || t==INode.ROOK)
                    return false;
                break;
            }
        }

        int x = from&7;
        if(white){
            if(from<48){
                if ((x!=0) && board[from+7]==INode.BLACK_PAWN)
                    return false;
                if ((x!=7) && board[from+9]==INode.BLACK_PAWN)
                    return false;
            }
        } else {
            if(from>15){
                if ((x!=0) && board[from-9]==INode.PAWN)
                    return false;
                if ((x!=7) && board[from-7]==INode.PAWN)
                    return false;
            }
        }
        return true;
    }

    final public static boolean checkSafe(int i) {
        return i==0;
    }

    public final static boolean white(int bitmap) {
        return (bitmap & INode.BLACK) == 0;
    }

    final private static int home(boolean white) {
        return white ? 0 : 56;
    }

    public final static int forward(boolean white) {
        return white ? 8 : -8;
    }

    final static int pawnline(boolean white) {
        return white ? 8 : 48;
    }

    final static int goalline(boolean white) {
        return white ? 56 : 0;
    }

    final public static PieceType getPieceType(char fen) {
        for (PieceType type : PieceType.values()) {
            if (type.fen == fen)
                return type;
        }
        return null;
    }

    final private static void addSlider(IAdder imoves, int[] board, int[][] moves, boolean white) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length && add(imoves, board, slide[i], white); i++) {
                // not
            }
        }
    }

    final private static void addSimple(IAdder imoves, int[] board, int[] moves, boolean white) {
        for (int to : moves)
            add(imoves, board, to, white);
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
    final private static boolean add(IAdder moves, int[] board, int to, boolean white) {
        int victim = board[to];
        if (victim == 0)
            moves.move(to);
        else if (((victim & INode.BLACK) == 0) != white)
            moves.capture(to);
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
        boolean white) {
        int to = from + leftright;
        if (inside(to, from)) {
            int piece = board[to];
            if (piece != 0) {
                if (((piece & INode.BLACK) == 0) == white)
                    moves.support(to);
                else if (to >= goalline(white) && to < goalline(white) + 8)
                    moves.capturePromote(to);
                else
                    moves.capture(to);
            } else {
                if (enpassant == to)
                    moves.enpassant(to);
            }
        }
    }

    final private static void pawnForward(IAdder moves, int[] board, int from, int mv, boolean white) {
        int to1 = from + mv;
        if (inside(to1, from)) {
            if (board[to1] == 0) {
                if (to1 >= goalline(white) && to1 < goalline(white) + 8)
                    moves.movePromote(to1);
                else
                    moves.move(to1);
                if (from >= pawnline(white) && from < pawnline(white) + 8) {
                    int to2 = from + mv + mv;
                    if (inside(to2, from)) {
                        if (board[to2] == 0)
                            moves.move(to2);
                    }
                }
            }
        }
    }

    final private static void castlingKing(IAdder moves, int[] board, int rook, boolean white) {
        int home = home(white);
        if (board[home + 5] == 0 && board[home + 6] == 0 && board[home + 7] == rook) {
            if (checkSafe(board,home + 4,white) && checkSafe(board,home + 5,white))
                moves.castling(home + 6);
        }
    }

    final private static void castlingQueen(final IAdder moves, final int[] board, int rook,
        boolean white) {
        int home = home(white);
        if (board[home + 3] == 0 && board[home + 2] == 0 && board[home + 1] == 0 && board[home + 0] == rook) {
            if (checkSafe(board,home + 3,white) && checkSafe(board,home + 4,white))
                moves.castling(home + 2);
        }
    }


}
