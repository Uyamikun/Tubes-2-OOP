import Battle.*;
import Map.*;
import Engimon.*;
import Player.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Load resource dari png
        Loader.load();
        //Matriks peta
        Map peta = new Map("Map/map.txt");
        ArrayList<ArrayList<Cell>> matriks = peta.getMap();

        //To implement: BELUM INPUT NAMA
        //Construct player
        Player p = new Player("Hello world");
        //Set Active Engimon
        //Note peta: memiliki player perlu edit player
//        public Engimon getActive_engimon()
        peta.setPlayer(p);

        //set minimum spawn level
        int level = Math.max(peta.getPlayer().getActive_engimon().getLevel(), peta.getPlayer().getEngimon_as_object().getMaxLevel());
        peta.setMinSpawnLevel(level);

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
