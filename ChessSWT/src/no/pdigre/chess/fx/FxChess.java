package no.pdigre.chess.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.IPlayer.Players;

public class FxChess extends Application {

	@Override
	public void start(Stage primaryStage) {
        FxGameData game = new FxGameData();
	    FxChessDialog grid = new FxChessDialog(game);
        game.start(StartingGames.FEN_GAMES[0], Players.MANUAL, Players.NOVICE);
		primaryStage.setScene(new Scene(grid));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
