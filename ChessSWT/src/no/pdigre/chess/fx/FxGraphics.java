package no.pdigre.chess.fx;

import java.util.EnumMap;

import javafx.scene.image.Image;
import no.pdigre.chess.engine.fen.PieceType;


public class FxGraphics {
    public static FxGraphics graphics = new FxGraphics();
    
    public FxGraphics() {
        super();
        loadImages(getClass());
    }

    public EnumMap<PieceType, Image> images = new EnumMap<PieceType, Image>(
            PieceType.class);

    private void loadImages(Class<?> clz) {
        for (PieceType ptype : PieceType.values()) {
            String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w"
                    + ptype.fen + ".gif").toLowerCase();
            Image image = new Image(clz.getClassLoader()
                    .getResourceAsStream(filename));
            images.put(ptype, image);
        }
    }
    
    public Image getImage(int piece) {
        return images.get(PieceType.types[piece]);
    }

}
