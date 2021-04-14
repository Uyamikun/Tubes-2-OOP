import java.util.*;


public class driver {
    public static void main(String[] args) {

        Loader.load();
        //Matriks peta
        Map peta = new Map("Map/map.txt");
        ArrayList<ArrayList<Cell>> matriks = peta.getMap();
        for (ArrayList<Cell> ac :matriks){
            for (Cell c : ac){
                System.out.print(c.getPosisi().get_x() + "," + c.getPosisi().get_y());
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(peta.getMap().get(0).size());
        System.out.println(peta.getMap().size());
        System.out.println(peta.getCell(0,5).getPosisi().get_x());

        //cek GUI
        //Game utama hidden
        PlayerUI playerUI = new PlayerUI(peta);
        FrameUtama objFrameUtama = new FrameUtama(playerUI,peta);
        objFrameUtama.setVisible(false);
        //Main Menu
        FrameMenu objFrameMenu = new FrameMenu(objFrameUtama);
        objFrameMenu.setVisible(true);
    }
}
