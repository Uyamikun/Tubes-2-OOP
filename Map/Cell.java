import Engimon.*;

import java.awt.*;

public abstract class Cell {
    enum CellType{
        MOUNTAINS, SEA, GRASSLAND, TUNDRA
    }
    protected Point posisi;
    protected Engimon engimon;
    protected CellType type;
    protected boolean player;
    protected  boolean active;

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

}
