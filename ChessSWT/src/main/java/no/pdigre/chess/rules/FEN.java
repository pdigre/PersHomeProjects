package no.pdigre.chess.rules;

public class FEN {

    /**
     * Standard Forsyth–Edwards Notation
     * 
     * @return
     */
    final public static String getFen(IMove move) {
        StringBuilder fen = new StringBuilder();
        fen.append(FEN.board2String(move.getBoard()));
        fen.append(" ");
        fen.append(move.whiteTurn() ? "w" : "b");
        fen.append(" ");
        fen.append(FEN.getFenCastling(move));
        fen.append(" ");
        fen.append(FEN.pos2text(move.getEnpassant()));
        fen.append(" ");
        fen.append(move.halfMoves());
        fen.append(" ");
        fen.append(move.totalMoves());
        return fen.toString();
    }

    final public static String pos2text(int i) {
        if (i < 0)
            return "-";
        int x = i % 8;
        int y = (i - x) / 8;
        return String.valueOf("abcdefgh".charAt(x)) + String.valueOf(y + 1);
    }

    final public static int text2pos(String pos) {
        if (pos == null || pos.length() != 2)
            return -1;
        return "abcdefgh".indexOf(pos.charAt(0)) + 8 * (pos.charAt(1) - '1');
    }

    final public static int[] array2board(int[] pieces) {
        int[] board = new int[64];
        for (int piece : pieces)
            board[Move.getPos(piece)] = Move.getType(piece);
        return board;
    }

    final public static String board2String(int[] board) {
        StringBuilder fen = new StringBuilder();
        for (int y = 8; y-- > 0;) {
            int i = 0;
            if (y != 7)
                fen.append("/");
            for (int x = 0; x < 8; x++) {
                PieceType type = PieceType.types[board[y * 8 + x]];
                if (type == null) {
                    i++;
                } else {
                    if (i > 0) {
                        fen.append(i);
                        i = 0;
                    }
                    fen.append(type.fen);
                }
            }
            if (i > 0)
                fen.append(i);
        }
        return fen.toString();
    }

    final public static String getFenCastling(IMove move) {
        StringBuilder sb = new StringBuilder();
        int state=move.getCastlingState();
        if ((state & IMove.NOCASTLE_WHITEKING)==0)
            sb.append("K");
        if ((state & IMove.NOCASTLE_WHITEQUEEN)==0)
            sb.append("Q");
        if ((state & IMove.NOCASTLE_BLACKKING)==0)
            sb.append("k");
        if ((state & IMove.NOCASTLE_BLACKQUEEN)==0)
            sb.append("q");
        return sb.toString();
    }

}
