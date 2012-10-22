package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ChessDialog {

    ChessCanvas canvas;

    GameData game = new GameData();


    public ChessDialog(Shell shell) {
        canvas = new ChessCanvas(shell, SWT.None) {

            @Override
            protected ArrayList<Marking> markMovesForPiece() {
                return game.markMovesForPiece();
            }

            @Override
            protected ArrayList<Marking> markPiecesThatCanMove() {
                return game.markPiecesThatCanMove();
            }

            @Override
            protected boolean pickingPiece() {
                return game.from == -1;
            }

            @Override
            protected void selectSquare(int i) {
                if (game.draw_targets[i] != 0) {
                    game.makeMove(i);
                    updateAll();
                } else {
                    game.markToMoves(i);
                    updateAll();
                }
            }

            @Override
            protected int[] getBoard() {
                return game.board;
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
                setup(new StartGame(cc.getText()));
            }

        });
        cc.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                setup(new StartGame(cc.getText()));
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // not
            }
        });
        shell.open();
    }

    public void setup(IPosition startGame) {
        game.setup(startGame);
        canvas.updateBoard();

        new Thread(new Runnable() {

            @Override
            public void run() {
                game.analyzeMarkers();
                canvas.updateMarkers();
            }
        }).run();
    }

}
