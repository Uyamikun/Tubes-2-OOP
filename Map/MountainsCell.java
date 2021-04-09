
public class MountainsCell extends Cell{
    public MountainsCell(Point p){
        super(p);
        this.type = CellType.MOUNTAINS;
    }
    public MountainsCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.MOUNTAINS;
    }
}
