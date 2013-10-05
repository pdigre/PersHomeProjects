package no.pdigre.chess.fx;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.pdigre.chess.profile.IPlayer.Players;

import com.sun.javafx.collections.ObservableListWrapper;

public class FxChess extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane grid=new GridPane();
		ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();
        cols.add(new ColumnConstraints(320));
        cols.add(new ColumnConstraints(80));
        ObservableList<RowConstraints> rows = grid.getRowConstraints();
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(160));
        rows.add(new RowConstraints(40));
        Canvas canvas=new Canvas();
        canvas.setWidth(300);
        canvas.setHeight(300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREY);
        gc.fillRect(100, 100, 90, 90);
        grid.add(canvas,0,0,1,4);
        grid.add(createLabel("White"), 1, 0);
        grid.add(createCombo("MANUAL"),1,1);
        grid.add(createLabel("Black"), 1, 2);
        grid.add(createCombo("NOVICE"),1,3);
		primaryStage.setScene(new Scene(grid));
		primaryStage.show();
	}

    public ComboBox<String> createCombo(String txt) {
        ObservableListWrapper<String> olist = new ObservableListWrapper<String>(Arrays.asList(Players.NAMES));
		ComboBox<String> combo=new ComboBox<String>(olist);
		combo.setValue(txt);
		combo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("hi");
			}
		});
        return combo;
    }

    public Text createLabel(String lbl) {
        Text t=new Text(lbl);
		t.setFont(Font.font("Arial", 10));
		t.setEffect(new DropShadow(2,3,3,Color.RED));
        return t;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
