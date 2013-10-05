package no.pdigre.chess.fx;

import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import no.pdigre.chess.profile.IPlayer.Players;

import com.sun.javafx.collections.ObservableListWrapper;


public class FxChessDialog extends GridPane{

    public FxChessDialog(FxGameData game) {
        super();
        ObservableList<ColumnConstraints> cols = getColumnConstraints();
        cols.add(new ColumnConstraints(270));
        cols.add(new ColumnConstraints(80));
        ObservableList<RowConstraints> rows = getRowConstraints();
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(40));
        rows.add(new RowConstraints(110));
        rows.add(new RowConstraints(40));
        FxChessCanvas canvas = new FxChessCanvas(game);
        add(canvas,0,0,1,5);
        add(createLabel("White"), 1, 0);
        add(createCombo("MANUAL"),1,1);
        add(createLabel("Black"), 1, 2);
        add(createCombo("NOVICE"),1,3);
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

}
