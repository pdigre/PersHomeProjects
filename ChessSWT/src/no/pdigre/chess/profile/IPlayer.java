package no.pdigre.chess.profile;

import java.util.ArrayList;


public interface IPlayer {

    abstract void run();

    abstract int[] getBitmaps();
    
    abstract int getScore(int bitmap);

    int clickSquare(int i);

    ArrayList<Marking> getMarkers();
}
