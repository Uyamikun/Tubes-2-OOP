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
        Random rand = new Random();
        int x = rand.nextInt(4);
        switch (x) {
            case 0 -> this.engimon = new Pikachu();
            case 1 -> this.engimon = new Earthshaker();
            case 2 -> this.engimon = new KataraToph();
            default -> this.engimon = new Hu_Tao();
        }
    }

    public void paint(Graphics g){
        g.drawImage(Resources.TEXTURES.get(3),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
    }

    public boolean canMove(Engimon e){
        return e.getSpecies().equals("Pikachu") || e.getSpecies().equals("Earthshaker") || e.getSpecies().equals("KataraToph") || e.getSpecies().equals("Hu_Tao");
    }

}
