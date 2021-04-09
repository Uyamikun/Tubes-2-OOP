public class SeaCell extends Cell{
    public SeaCell(Point p){
        super(p);
        this.type = CellType.SEA;
    }
    public SeaCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.SEA;
    }
}
