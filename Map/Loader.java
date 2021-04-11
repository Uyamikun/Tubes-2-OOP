import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	
	public static void load() {
		try {
			Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("Resources/player.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}