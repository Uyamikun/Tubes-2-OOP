import Engimon.*;

import java.awt.*;
import java.util.Random;

public class GrasslandCell extends Cell{
    public GrasslandCell(Point p){
        super(p);
        this.type = CellType.GRASSLAND;
    }
    public GrasslandCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.GRASSLAND;
    }
    public void spawnEngimon() {

        int x = rand.nextInt(4);
        System.out.println(x);
        switch (x) {
            case 0 : this.engimon = new Pikachu();
                break;
            case 1 : this.engimon = new Earthshaker();
                break;
            case 2 : this.engimon = new KataraToph();
                break;
            default : this.engimon = new Hu_Tao();
                break;
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(3),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
        if (this.engimon!= null){
            this.paintEngimon(g);
            if (this.active){
                this.paintActive(g);
            }
        }
    }

    public boolean canMove(Engimon e){
        return e.getSpecies().equals("Pikachu") || e.getSpecies().equals("Earthshaker") || e.getSpecies().equals("KataraToph") || e.getSpecies().equals("Hu_Tao");
    }

}
