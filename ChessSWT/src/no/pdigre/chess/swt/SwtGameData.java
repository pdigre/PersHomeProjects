package no.pdigre.chess.swt;

import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.IPlayer.Players;


public class SwtGameData extends GameData {

    private SwtChessDialog dialog;

    public SwtGameData(SwtChessDialog dialog) {
        this.dialog=dialog;
    }

    @Override
    public void updateBoard() {
        dialog.updateBoard(position);
    }

    protected void start(String fen, Players p_white, Players p_black) {
        setPlayer(p_white, true);
        setPlayer(p_black, false);
        setupFEN(fen);
        run();
    }
}
