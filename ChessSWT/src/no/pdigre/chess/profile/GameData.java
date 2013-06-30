package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Move;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.profile.IPlayer.Players;

public abstract class GameData {

    public IPosition position;

    private Player[] players=new Player[2];

	public Thread thread;

    public void setPlayer(Players profile,boolean white){
    	Player player = profile.getInstance();
    	players[white?0:1]=player;
    	player.setGameData(this);
    }
    
    public void setupFEN(String fen) {
        position = new StartGame(fen);
		updateBoard();
    }

    public void run() {
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
            	getPlayer().run();
            }
        });
        thread.start();
    }

    Player getPlayer() {
        return players[position.whiteTurn() ? 0 : 1];
    }

    public void clickSquare(int i) {
        Player player = getPlayer();
        int move=player.clickSquare(i);
        if(move>-1)
            makeMove(move);
        else
        	updateBoard();
    }

    public void makeMove(int bitmap) {
        position = new Move(position, bitmap);
		updateBoard();
        run();
    }

    public abstract void updateBoard();

    public ArrayList<Marking> getMarkers() {
        return getPlayer().getMarkers();
    }

}
