package Map;
import Battle.Battle;
import Engimon.*;

import java.util.*;

public class driver {
    public static void printPeta(ArrayList<ArrayList<Cell>> matriks){
        for (ArrayList<Cell> ac :matriks){
            for (Cell c : ac){
                System.out.println(c.getType());
                System.out.print(" ");
//                c.printEngimon();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Loader.load();
        //Matriks peta
        Map peta = new Map("Map/map.txt");
        ArrayList<ArrayList<Cell>> matriks = peta.getMap();

        printPeta(matriks);

        for (ArrayList<Cell> ac :matriks){
            for (Cell c : ac){
                System.out.print(c.getPosisi().get_x() + "," + c.getPosisi().get_y());
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(peta.getMap().get(0).size());
        System.out.println(peta.getMap().size());
        System.out.println(peta.getCell(3,4).getPosisi().get_x());
        System.out.println(peta.getCell(3,4).getPosisi().get_y());

        peta.setActiveEngimon(new Blastoise());

        //cek Battle
        Hu_Tao e1 = new Hu_Tao("Aoooo",10);
        Wynter e2 = new Wynter("Wynn",5);
        Blastoise p1 = new Blastoise("ToiseBlas",5);
        Amaura p2 = new Amaura("Urauraura",5);

        Battle battle = new Battle(e1,e2);
        System.out.println(battle.calculatePowerPlayer());
        System.out.println(battle.calculatePowerEnemy());
        System.out.println("");

        battle = new Battle(p1,p2);
        System.out.println(battle.calculatePowerPlayer());
        System.out.println(battle.calculatePowerEnemy());
        System.out.println("");

        battle = new Battle(e1,p1);
        System.out.println(battle.calculatePowerPlayer());
        System.out.println(battle.calculatePowerEnemy());
        System.out.println("");

        //cek GUI
        //Game utama hidden
        PlayerUI playerUI = new PlayerUI(peta);
        FrameUtama objFrameUtama = new FrameUtama(playerUI,peta);
        objFrameUtama.setVisible(false);
        objFrameUtama.getObjBoardPanel().requestFocusInWindow();
        //Main Menu
        FrameMenu objFrameMenu = new FrameMenu(objFrameUtama);
        objFrameMenu.setVisible(true);
    }
}
