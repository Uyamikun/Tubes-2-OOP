import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Resources {
    //indexing
	public static final byte PLAYER = 0;
	public static final byte MOUNTAIN = 1;
	public static final byte TUNDRA = 2;
	public static final byte GRASS = 3;
	public static final byte SEA = 4;

    //menyimpan buffered image
	public static final HashMap<String, BufferedImage> ROOMS = new HashMap<>();
	public static final ArrayList<BufferedImage> TEXTURES = new ArrayList<>();
}
