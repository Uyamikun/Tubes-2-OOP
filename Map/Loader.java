package Map;
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
            //5-12 ENGIMON
			Resources.TEXTURES.add(Resources.BLASTOISE, ImageIO.read(new File("Resources/blastoise.png")));
			Resources.TEXTURES.add(Resources.CYNDAQUIL, ImageIO.read(new File("Resources/cyndaquil.png")));
			Resources.TEXTURES.add(Resources.AMAURA, ImageIO.read(new File("Resources/amaura.png")));
			Resources.TEXTURES.add(Resources.EARTHSHAKER, ImageIO.read(new File("Resources/earthshaker.png")));
			Resources.TEXTURES.add(Resources.PIKACHU, ImageIO.read(new File("Resources/pikachu.png")));
			Resources.TEXTURES.add(Resources.WYNTER, ImageIO.read(new File("Resources/wynter.png")));
			Resources.TEXTURES.add(Resources.KATARATOPH, ImageIO.read(new File("Resources/kataratoph.png")));
			Resources.TEXTURES.add(Resources.HUTAO, ImageIO.read(new File("Resources/hutao.png")));
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}