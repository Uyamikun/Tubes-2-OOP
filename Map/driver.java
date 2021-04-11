import java.util.*;


public class driver {
    public static void main(String[] args) {

        Loader.load();
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
        System.out.println(peta.getMap().get(0).size());
        System.out.println(peta.getMap().size());

        //cek GUI
        PlayerUI playerUI = new PlayerUI(peta);
        FrameUtama objFrameUtama = new FrameUtama(playerUI,peta);
        objFrameUtama.setVisible(true);
    }
}
