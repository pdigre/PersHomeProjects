package no.pdigre.chess.swt;

import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.GameData;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ChessDialog {

    public ChessCanvas canvas;

    public GameData game = new GameData() {

        @Override
        protected void updateBoard(final int[] board) {
            canvas.updateCanvas(new PaintListener() {
            
                @Override
                public void paintControl(PaintEvent e) {
                    ChessCanvas.clearBoard(e);
                    ChessCanvas.updatePieces(e,board);
                }
            
            });
        }

        @Override
        protected void updateMarkers(final int[] board,final int bitmap,final Integer ifrom) {
//            final int[] board = game.position.getBoard();
//            final int bitmap = game.position.getBitmap();
//            final Integer ifrom = game.from;
            canvas.updateCanvas(new PaintListener() {
            
                @Override
                public void paintControl(PaintEvent e) {
                    ChessCanvas.clearBoard(e);
                    ChessCanvas.updatePieces(e,board);
                    if(ifrom == -1){
                        ChessCanvas.updateMarkers(e, getPiecesThatCanMove(board,bitmap));
                    }else {
                        ChessCanvas.updateMarkers(e, getMovesForPiece(board,bitmap,ifrom));
                    }
                }
            });
        }
    };

    public ChessDialog(Shell shell) {
        canvas = new ChessCanvas(shell, SWT.None) {

            @Override
            protected void selectSquareEvent(int i) {
                game.clickSquare(i);
                updateCanvas(new PaintListener() {
                
                    @Override
                    public void paintControl(PaintEvent e) {
                        clearBoard(e);
                        updatePieces(e,game.position.getBoard());
                        updateMarkers(e, game.getMarkers());
                    }
                
                });
            }

        };
        
        shell.setLayout(new GridLayout(2, false));
        shell.setSize(500, 350);
        Composite controller = new Composite(shell, SWT.NONE);
        controller.setLayoutData(new GridData());
        final CCombo cc = new CCombo(shell, SWT.BORDER);
        cc.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
        cc.setItems(StartingGames.FEN_GAMES);
        cc.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                game.newGame(cc.getText());
            }

        });
        cc.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                game.newGame(cc.getText());
            }
        });
        shell.open();
        game.newGame(StartingGames.FEN_GAMES[0]);
    }
    
}
