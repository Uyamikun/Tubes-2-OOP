package Map;
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
	//engimon
	public static final byte BLASTOISE = 5;
	public static final byte CYNDAQUIL = 6;
	public static final byte AMAURA = 7;
	public static final byte EARTHSHAKER = 8;
	public static final byte PIKACHU = 9;
	public static final byte WYNTER = 10;
	public static final byte KATARATOPH = 11;
	public static final byte HUTAO = 12;
	//fx
	public static final byte HIGH_LEVEL = 13;
	public static final byte ACTIVE_ENGIMON = 14;

    //menyimpan buffered image
	public static final HashMap<String, BufferedImage> ROOMS = new HashMap<>();
	public static final ArrayList<BufferedImage> TEXTURES = new ArrayList<>();
}
