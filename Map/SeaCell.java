
import Engimon.Blastoise;
import Engimon.Hu_Tao;
import Engimon.Wynter;

import java.awt.*;
import java.util.Random;

public class SeaCell extends Cell{
    public SeaCell(Point p){
        super(p);
        this.type = CellType.SEA;
    }
    public SeaCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.SEA;
    }
    public void spawnEngimon() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        switch (x) {
            case 0 -> this.engimon = new Blastoise();
            case 1 -> this.engimon = new Wynter();
            default -> this.engimon = new Hu_Tao();
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(4),this.posisi.get_y()*Tile.SIZE,this.posisi.get_x()*Tile.SIZE,null);
    }
}
