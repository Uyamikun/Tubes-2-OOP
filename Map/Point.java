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


    private int x;
    private int y;
}