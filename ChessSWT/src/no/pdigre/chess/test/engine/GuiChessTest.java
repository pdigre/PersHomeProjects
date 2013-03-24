package no.pdigre.chess.test.engine;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.swt.Chess;
import no.pdigre.chess.swt.ChessCanvas;
import no.pdigre.chess.swt.ChessDialog;
import no.pdigre.chess.swt.Marking;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.junit.Test;

public class GuiChessTest {

    public class PGN{
        String event;
        String date;
        String site;
        String round;
        String white;
        String black;
        String result;
        String fen;
        String move1;
    }

    @Test
    public void testChess() {
        final Chess chess = new Chess();
        new Thread(){
            
            @Override
            public void run() {
                final PGN[] list = readPGN(FileUtils.stream2lines(getClass().getResourceAsStream("BT2450.pgn")));
                for (final PGN pgn : list) {
                    chess.shell.getDisplay().syncExec(new Runnable() {
                        
                        @Override
                        public void run() {
                            chess.setup(pgn.fen);
                            IPosition pos = chess.dialog.game.position;
                            int bitmap = pos.getBitmap();
                            final int[] board = pos.getBoard();
                            final ArrayList<Marking> markers = ChessDialog.getPiecesThatCanMove(board,bitmap);
                            chess.dialog.canvas.updateCanvas(new PaintListener() {
                                
                                @Override
                                public void paintControl(PaintEvent e) {
                                    ChessCanvas.clearBoard(e);
                                    ChessCanvas.updatePieces(e,board);
                                    ChessCanvas.updateMarkers(e, markers);
                                }
                            });
                        }
                    });
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        chess.runDisplay();
    }

    public PGN[] readPGN(ArrayList<String> lines) {
        ArrayList<PGN> list=new ArrayList<GuiChessTest.PGN>();
        PGN pgn = new PGN();
        list.add(pgn);
        for (String line : lines) {
            if(line.startsWith("[Event ")){
                if(pgn.event!=null){
                    pgn = new PGN();
                    list.add(pgn);
                }
                pgn.event=line.split("\"")[1];
            }
            if(line.startsWith("[Site "))
                pgn.site=line.split("\"")[1];
            if(line.startsWith("[Date "))
                pgn.date=line.split("\"")[1];
            if(line.startsWith("[Round "))
                pgn.round=line.split("\"")[1];
            if(line.startsWith("[White "))
                pgn.white=line.split("\"")[1];
            if(line.startsWith("[Black "))
                pgn.black=line.split("\"")[1];
            if(line.startsWith("[Result "))
                pgn.result=line.split("\"")[1];
            if(line.startsWith("[FEN "))
                pgn.fen=line.split("\"")[1];
            if(line.startsWith("1."))
                pgn.move1=line.substring(2);
            System.out.println("Line:"+line);
        }
        return list.toArray(new PGN[list.size()]);
    }

}
