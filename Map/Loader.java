import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	
	public static void load() {
		try {
            //1 Mountain, 2 Tundra, 3 Grass, 4 Sea
			Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("Resources/player.png")));
            Resources.TEXTURES.add(Resources.MOUNTAIN, ImageIO.read(new File("Resources/mountain.png")));
            Resources.TEXTURES.add(Resources.TUNDRA, ImageIO.read(new File("Resources/tundra.png")));
            Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("Resources/grass.png")));
            Resources.TEXTURES.add(Resources.SEA, ImageIO.read(new File("Resources/sea.png")));
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}