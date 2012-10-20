package no.pdigre.chess.swt;

import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;


public class Chess {

    public static void main(String[] args) {
        new Chess();
    }

    public Chess(){
    	ChessDialog dia = new ChessDialog();
		dia.setup(new StartGame(StartingGames.FEN_GAMES[0]));
		dia.run();
    }



}
