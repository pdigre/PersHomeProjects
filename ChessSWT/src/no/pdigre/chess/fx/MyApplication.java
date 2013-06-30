package no.pdigre.chess.fx;

import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.sun.javafx.collections.ObservableListWrapper;

public class MyApplication extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane p=new BorderPane();
		Text t=new Text("Hello FX");
		t.setFont(Font.font("Arial", 60));
		t.setEffect(new DropShadow(2,3,3,Color.RED));
		p.setCenter(t);
		ObservableListWrapper<String> olist = new ObservableListWrapper<String>(Arrays.asList("1,2,3,4".split(",")));
		ComboBox<String> combo=new ComboBox<String>(olist);
		combo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("hi");
			}
		});
		p.setBottom(combo);
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
