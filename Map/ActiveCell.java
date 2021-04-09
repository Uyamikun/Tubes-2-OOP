public class ActiveCell extends Cell{
    public ActiveCell(Point p){
        super(p);
        this.type = CellType.ACTIVE;
    }
    public ActiveCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.ACTIVE;
    }
}
