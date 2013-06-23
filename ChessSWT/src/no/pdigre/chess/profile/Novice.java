package no.pdigre.chess.profile;

import no.pdigre.chess.engine.eval.AlphaBeta;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;

public class Novice extends Player {

    public Novice(GameData gameData) {
        super(gameData);
    }

    @Override
    public void run() {
        IPosition pos = game.position;
        System.out.println(FEN.getFen(pos));
        int[] board = pos.getBoard();
        int bitmap = pos.getBitmap();
        AlphaBeta eval = new AlphaBeta(board, bitmap, 5);
        bitmaps = eval.getBitmaps();
        game.makeMove(bitmaps[0]);
    }

}
