package Map;
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
        int x = rand.nextInt(2);
        System.out.println(x);
        switch (x) {
            case 0 : this.engimon = new Amaura();
                break;
            default : this.engimon = new Wynter();
                break;
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(2),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
        if (this.engimon!= null){
            this.paintEngimon(g);
            if (this.active){
                this.paintActive(g);
            }
        }
    }

    public boolean canMove(Engimon e){
        return e.getSpecies().equals("Amaura") || e.getSpecies().equals("Wynter");
    }
}
