package Map;
import Engimon.*;

import java.awt.*;
import java.util.Random;

public abstract class Cell {
    enum CellType{
        MOUNTAINS, SEA, GRASSLAND, TUNDRA
    }
    protected Point posisi;
    protected Engimon engimon;
    protected CellType type;
    protected boolean player;
    protected  boolean active;
    protected static final Random rand = new Random();

    public Cell(Point input_posisi){
        this.posisi = input_posisi;
         this.engimon = null;
         this.player = false;
         this.active = false;
    }
    public Cell(int input_x, int input_y){
        this.posisi = new Point(input_x, input_y);
        this.engimon = null;
        this.player = false;
        this.active = false;
    }
    public Point getPosisi(){
        return this.posisi;
    }
    public void print(){
        System.out.print(this.type);
    }
    public CellType getType(){
        return this.type;
    }
    public boolean isBlocked(){
         return this.engimon != null || player;
     }
     public boolean isActive(){
        return active;
     }
     public void setPlayer(boolean b){
        this.player = b;
     }
     public void setActive(boolean b){
        this.active = b;
     }
     public void addEngimon(Engimon e){
         this.engimon = e;
     }
     public void removeEngimon(){
         this.engimon = null;
     }
     public Engimon getEngimon(){
         return this.engimon;
     }
     public void spawnEngimon(){
     }
     public void paint(Graphics g){

     }
     public boolean canMove(Engimon e){
        return false;
     }
     public void printEngimon(){
        if (this.engimon != null){
            System.out.print(this.engimon.getSpecies() + " ");
        }else if(this.player){
            System.out.print("P ");
        }
        else{
            System.out.print("no ");
        }
     }

     public void paintEngimon(Graphics g){
//         e.getSpecies().equals("Cyndaquil")
        if (this.engimon.getSpecies().equals("Blastoise")){
            g.drawImage(Resources.TEXTURES.get(5),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Cyndaquil")){
            g.drawImage(Resources.TEXTURES.get(6),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Amaura")){
            g.drawImage(Resources.TEXTURES.get(7),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Earthshaker")){
            g.drawImage(Resources.TEXTURES.get(8),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Pikachu")){
            g.drawImage(Resources.TEXTURES.get(9),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Wynter")){
            g.drawImage(Resources.TEXTURES.get(10),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("KataraToph")){
            g.drawImage(Resources.TEXTURES.get(11),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else if (this.engimon.getSpecies().equals("Hu_Tao")){
            g.drawImage(Resources.TEXTURES.get(12),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
        else {
            g.drawImage(Resources.TEXTURES.get(0),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
            //debug
            //System.out.println("Spawned" + this.engimon.getSpecies());
        }
     }

     public void paintLevel(Graphics g){
         g.drawImage(Resources.TEXTURES.get(13),this.posisi.get_x()*Tile.SIZE,this.posisi.get_y()*Tile.SIZE,null);
     }

     public void paintActive(Graphics g){
         g.drawImage(Resources.TEXTURES.get(14),this.posisi.get_x()*Tile.SIZE+8,this.posisi.get_y()*Tile.SIZE,null);
     }

}
