package no.pdigre.chess.profile;

import java.util.ArrayList;

public interface IPlayer {

    public enum Players {
        MANUAL(Manual.class),
        MANUALHELP(ManualWithHelp.class),
        NOVICE(Novice.class),
        INTERMEDIATE2(Intermediate2.class),
        INTERMEDIATE(Intermediate.class);

        public static String[] NAMES = getPlayers();

        public Class<?> profile;

        <X extends Player> Players(Class<X> profile) {
            this.profile = profile;
        }

        public Player getInstance() {
            try {
                return (Player) profile.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String[] getPlayers() {
            ArrayList<String> list = new ArrayList<String>();
            for (Players player : Players.values())
                list.add(player.name());
            return list.toArray(new String[list.size()]);
        }
    }

    abstract void run();

    abstract int[] getBitmaps();

    abstract int getScore(int bitmap);

    int clickSquare(int i);

    ArrayList<Marking> getMarkers();
}
