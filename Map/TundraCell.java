
public class TundraCell extends Cell{
    public TundraCell(Point p){
        super(p);
        this.type = CellType.TUNDRA;
    }
    public TundraCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.TUNDRA;
    }
}
