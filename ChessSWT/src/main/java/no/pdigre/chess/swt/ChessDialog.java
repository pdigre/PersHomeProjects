package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.PieceType;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ChessDialog {

    ChessCanvas canvas;

    GameData game = new GameData() {

        @Override
        protected void updateBoard() {
            canvas.updateBoard();
        }

        @Override
        protected void updateMarkers() {
            canvas.updateMarkers();
        }
    };

    public ChessDialog(Shell shell) {
        canvas = new ChessCanvas(shell, SWT.None) {

            @Override
            protected void selectSquareEvent(int i) {
                game.clickSquare(i);
                updateAll();
            }

            @Override
            protected String getImage(int i) {
                int type = game.board[i];
                if (type == 0)
                    return null;
                PieceType ptype = PieceType.types[type];
                String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w" + ptype.fen + ".gif")
                    .toLowerCase();
                return filename;
            }

            @Override
            protected ArrayList<Marking> getMarkings() {
                return game.getMarkings();
            }
        };
        shell.setLayout(new GridLayout(2, false));
        shell.setSize(500, 350);
        Composite contoller = new Composite(shell, SWT.NONE);
        contoller.setLayoutData(new GridData());
        final CCombo cc = new CCombo(shell, SWT.BORDER);
        cc.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
        cc.setItems(StartingGames.FEN_GAMES);
        cc.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                game.setup(new StartGame(cc.getText()));
            }

        });
        cc.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                game.setup(new StartGame(cc.getText()));
            }
        });
        shell.open();
        game.setup(new StartGame(StartingGames.FEN_GAMES[0]));
    }

}
