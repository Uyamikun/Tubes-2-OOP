package Player;
import Engimon.*;
import java.util.*;

// javac Player/DriverPlayer.java

public class DriverPlayer {
    public static void main(String[] args) {
        Player p = new Player("Hello world");
        // Test display list engimon skill item
        // System.out.println(p.display_list_engimon());
        // System.out.println(p.display_list_skill());

        // Test display info engimon
        // p.display_info_engimon();

        // Test switch engimon
        // p.switch_out_active_engimon();
        // System.out.println(p.display_list_engimon());
        // p.display_info_engimon();

        // Test remove X amount Skill Item
        // p.removeXSkillItem();
        // System.out.println(p.display_list_skill());

        // Test remove engimon
        // p.removeEngimon();
        // System.out.println(p.display_list_engimon());

        // Test interact
        // System.out.println(p.interact());

        // Test rename
        // p.renameEngimon();
        // p.display_info_engimon();

        // Test use skill item
        // p.use_skill();
        // p.display_info_engimon();
        // System.out.println(p.display_list_skill());

        // Test get Help
        System.out.println(p.getHelp());
    }
}
