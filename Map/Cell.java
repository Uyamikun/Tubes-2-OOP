import Engimon.*;

public abstract class Cell {
    enum CellType{
        MOUNTAINS, SEA, GRASSLAND, TUNDRA, PLAYER, ACTIVE 
    }
    protected Point posisi;
     protected Engimon engimon;
    protected CellType type;

    public Cell(Point input_posisi){
        this.posisi = input_posisi;
         this.engimon = null;
    }
    public Cell(int input_x, int input_y){
        Point p = new Point(input_x, input_y);
        this.posisi = p;
         this.engimon = null;
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
         return this.engimon != null;
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

}
