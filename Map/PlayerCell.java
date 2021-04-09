public class PlayerCell extends Cell{
    public PlayerCell(Point p){
        super(p);
        this.type = CellType.PLAYER;
    }
    public PlayerCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.PLAYER;
    }
    public boolean isBlocked(){
        return true;
    }

}
