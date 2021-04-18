package Player;
import Engimon.*;
import java.util.*;

// javac Player/DriverPlayer.java

public class DriverPlayer {
    public static void main(String[] args) {
        Player p = new Player("Hello world");
        System.out.println(p.display_list_engimon());
        System.out.println(p.display_list_skill());
        p.display_info_engimon();
        p.switch_out_active_engimon();
        System.out.println(p.display_list_engimon());
        p.display_info_engimon();
    }
}
