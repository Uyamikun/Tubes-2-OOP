public class GrasslandCell extends Cell{
    public GrasslandCell(Point p){
        super(p);
        this.type = CellType.GRASSLAND;
    }
    public GrasslandCell(int _x, int _y){
        super(_x, _y);
        this.type = CellType.GRASSLAND;
    }
}
