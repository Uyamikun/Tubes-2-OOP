import Engimon.*;

import java.awt.*;
import java.util.Random;

public class TundraCell extends Cell{
    public TundraCell(Point p){
        super(p);
        this.type = CellType.TUNDRA;
    }
    public TundraCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.TUNDRA;
    }
    public void spawnEngimon() {
        Random rand = new Random();
        int x = rand.nextInt(2);
        switch (x) {
            case 0 -> this.engimon = new Amaura();
            default -> this.engimon = new Wynter();
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(2),this.posisi.get_y()*Tile.SIZE,this.posisi.get_x()*Tile.SIZE,null);
    }
}
