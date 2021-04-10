import java.util.*;


public class driver {
    public static void main(String[] args) {

        //Matriks peta
        Map peta = new Map("Map/map.txt");
        ArrayList<ArrayList<Cell>> matriks = peta.getMap();
        for (ArrayList<Cell> ac :matriks){
            for (Cell c : ac){
                c.print();
                System.out.print(" ");
            }
            System.out.println();
        }
        

        //cek GUI
//        FrameUtama objFrameUtama = new FrameUtama();
//        objFrameUtama.setVisible(true);
    }
}
