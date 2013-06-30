package no.pdigre.chess.swt;

import java.util.EnumMap;

import no.pdigre.chess.engine.fen.PieceType;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class SwtGraphics {

	public static SwtGraphics graphics = new SwtGraphics();
	
	public SwtGraphics() {
        super();
        loadImages(getClass());
    }

    public EnumMap<PieceType, ImageData> imgdatas = new EnumMap<PieceType, ImageData>(
			PieceType.class);

	public EnumMap<PieceType, Image> images = new EnumMap<PieceType, Image>(
			PieceType.class);

	private void loadImages(Class<?> clz) {
		for (PieceType ptype : PieceType.values()) {
			String filename = (ptype.fen > 'Z' ? "b" + ptype.fen + ".gif" : "w"
					+ ptype.fen + ".gif").toLowerCase();
			imgdatas.put(ptype, new ImageData(clz.getClassLoader()
					.getResourceAsStream(filename)));
		}
	}
	
	public Image getImage(int piece, Device device) {
		if (images.isEmpty()) {
			for (PieceType pt : PieceType.values()) {
				images.put(pt, new Image(device,
						imgdatas.get(pt)));
			}
		}
		return images.get(PieceType.types[piece]);
	}


}
