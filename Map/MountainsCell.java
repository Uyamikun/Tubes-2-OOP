import Engimon.*;

import java.awt.*;
import java.util.Random;

public class MountainsCell extends Cell{
    public MountainsCell(Point p){
        super(p);
        this.type = CellType.MOUNTAINS;
    }
    public MountainsCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.MOUNTAINS;
    }
    public void spawnEngimon() {
        Random rand = new Random();
        int x = rand.nextInt(2);
        switch (x) {
            case 0 -> this.engimon = new Cyndaquil();
            default -> this.engimon = new Hu_Tao();
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(2),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
        g.drawImage(Resources.TEXTURES.get(1),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
    }
}
