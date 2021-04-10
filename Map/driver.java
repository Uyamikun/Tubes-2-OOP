import java.util.*;


public class driver {
    public static void main(String[] args) {
        ArrayList<Cell> arr = new ArrayList<Cell>();
        arr.add(new SeaCell(0,0));
        arr.add(new PlayerCell(1,1));
        for (Cell c : arr){
            c.print();
        }
        arr.remove(0);
        arr.add(0, new GrasslandCell(2,2));
        for (Cell c : arr){
            c.print();
        }

        //Matriks peta
        Map peta = new Map();
        ArrayList<ArrayList<String>> matriks = peta.getMap();
        

        //cek GUI
        FrameUtama objFrameUtama = new FrameUtama();
        objFrameUtama.setVisible(true);
    }
}
