package no.pdigre.chess.swt;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.fen.StartingGames;

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
        protected void updateBoard() {
            canvas.updateCanvas(new PaintListener() {
            
                @Override
                public void paintControl(PaintEvent e) {
                    ChessCanvas.clearBoard(e);
                    ChessCanvas.updatePieces(e,game.board);
                }
            
            });
        }

        @Override
        protected void updateMarkers() {
            canvas.updateCanvas(new PaintListener() {
            
                @Override
                public void paintControl(PaintEvent e) {
                    ChessCanvas.clearBoard(e);
                    int[] board = game.position.getBoard();
                    int bitmap = game.position.getBitmap();
                    ChessCanvas.updatePieces(e,board);
                    if(game.from == -1){
                        ChessCanvas.updateMarkers(e, getPiecesThatCanMove(board,bitmap));
                    }else {
                        ChessCanvas.updateMarkers(e, getMovesForPiece(board,bitmap,game.from));
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
                        int[] board = game.position.getBoard();
                        int bitmap = game.position.getBitmap();
                        updatePieces(e,board);
                        if(game.from == -1){
                            updateMarkers(e, getPiecesThatCanMove(board,bitmap));
                        }else {
                            updateMarkers(e, getMovesForPiece(board,bitmap,game.from));
                        }
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
                setup(cc.getText());
                game.computeMarkers();
            }

        });
        cc.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = cc.getSelectionIndex();
                if (i < 0)
                    return;
                setup(cc.getText());
                game.computeMarkers();
            }
        });
        shell.open();
        setup(StartingGames.FEN_GAMES[0]);
    }

    public static ArrayList<Marking> getPiecesThatCanMove(int[] board,int bitmap) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        int best = Bitmap.getFrom(moves[0]);
        for (int move : moves) {
            int fr = Bitmap.getFrom(move);
            list.add(new Marking(fr == best ? MarkingType.BestMoveFrom : MarkingType.MoveFrom, fr));
        }
        return list;
    }

    public static ArrayList<Marking> getMovesForPiece(int[] board,int bitmap, int from) {
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        list.add(new Marking(MarkingType.MarkFrom, from));
        for (int move : moves) {
            if (Bitmap.getFrom(move) == from)
                list.add(new Marking(MarkingType.MoveTo, Bitmap.getTo(move), 0));
        }
        return list;
    }


    public void setup(String fen){
        game.setup(new StartGame(fen));
    }
    
}
