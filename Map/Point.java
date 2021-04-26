package Map;
public class Point {
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int get_x(){
        return this.x;
    }
    public int get_y(){
        return this.y;
    }

    public static Point add(Point p1, Point p2){
        return  new Point((p1.get_x()+p2.get_x()), (p1.get_y()+p2.get_y()));
    }

    private int x;
    private int y;
}
