package no.pdigre.chess.eval;

import no.pdigre.chess.base.FindNodes;
import no.pdigre.chess.base.IAdder;
import no.pdigre.chess.base.INode;
import no.pdigre.chess.moves.Move;
import no.pdigre.chess.moves.PieceType;

public class EvaluateBoard implements IEvaluator {

    final int[] board;

    final EvalMove eval;

    public EvaluateBoard(final EvalMove eval, final int[] board) {
        this.board = board;
        this.eval = eval;
        evaluate();
    }

    private void evaluate() {
        for (int i = 0; i < board.length; i++) {
            final int type=board[i];
            if(type==0)
                continue;
            PieceType t = PieceType.types[type];
            if (t == null)
                throw new AssertionError("null");
            boolean black = Move.isBlack(type);
            if (black) {
                bPieceVal -= t.weight;
            } else {
                wPieceVal += t.weight;
            }
            IAdder adder = black ? addblack : addwhite;
            FindNodes.addMovesForPiece(adder, board, i, type,
                eval.move.getEnpassant(), eval.move.getCastlingState());
        }
    }

    public boolean isCheck() {
        return wCheck || bCheck;
    }

    public int getScore() {
        return getScoreWhite() - getScoreBlack();
    }

    public boolean wCheck;

    public int wSupport;

    public int wBeat;

    public int wMove;

    public int wPieceVal;

    public int getScoreWhite() {
        return wPieceVal + wMove + 2 * wSupport + 3 * wBeat;
    }

    public boolean bCheck;

    public int bSupport;

    public int bBeat;

    public int bMove;

    public int bPieceVal;

    public int getScoreBlack() {
        return bPieceVal + bMove + 2 * bSupport + 3 * bBeat;
    }

    final IAdder addwhite = new IAdder() {

        @Override
        public void move(int to) {
            wMove++;
        }

        @Override
        public void movePromote(int to) {
            wMove++;
        }

        @Override
        public void capture(int to) {
            if (board[to] == INode.BLACK_KING)
                wCheck = true;
            else
                wBeat++;
        }

        @Override
        public void capturePromote(int to) {
            if (board[to] == INode.BLACK_KING)
                wCheck = true;
            else
                wBeat++;
        }

        @Override
        public void enpassant(int beat) {
            wBeat++;
        }

        @Override
        public void support(int to) {
            wSupport++;
        }

        @Override
        public void castling(int to) {
            // not
        }

    };

    final IAdder addblack = new IAdder() {

        @Override
        public void move(int to) {
            bMove++;
        }

        @Override
        public void movePromote(int to) {
            bMove++;
        }

        @Override
        public void capture(int to) {
            if (board[to] == INode.KING)
                bCheck = true;
            else
                bBeat++;
        }

        @Override
        public void capturePromote(int to) {
            if (board[to] == INode.KING)
                bCheck = true;
            else
                bBeat++;
        }

        @Override
        public void enpassant(int beat) {
            bBeat++;
        }

        @Override
        public void support(int to) {
            bSupport++;
        }

        @Override
        public void castling(int to) {
            // not
        }

    };

}
