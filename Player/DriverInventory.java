package Player;
import Engimon.*;
import java.util.*;

// javac Player/DriverInventory.java

public class DriverInventory {
    public static void main(String[] args) {
        InventoryEngimon ie = new InventoryEngimon();
        InventorySkillItem isi = new InventorySkillItem();

        // Skill Item
        ArrayList<String> al = new ArrayList<String>(){{
            add("Fire");
            add("Water");
        }};

        Skill S = new Skill("Searing chain", 31, 2, al);
        Skill Sk = new Skill("Fire gun", 30, 1, al);
        Skill Sp = new Skill("Earthshock", 32, 3, al);
        
        isi.insert(new SkillItem(S));
        isi.insert(new SkillItem(Sk));
        isi.insert(new SkillItem(Sp));
        isi.insert(new SkillItem(Sp));
        isi.insert(new SkillItem(Sp));
        isi.removeX(1, 3);

        // ArrayList<SkillItem> listSkill = isi.getObject();

        // Collections.sort(listSkill);
        // Collections.reverse(listSkill);
        // for(SkillItem si : listSkill){
        //     System.out.print(si.printSkillItem());
        // }

        System.out.println(isi.printInventory());

        // Inventory engimon
        Engimon e1 = new Amaura();
        Engimon e2 = new Blastoise();
        Engimon e3 = new Pikachu();
        Engimon e4 = new Earthshaker();
        ie.insert(e1);
        ie.insert(e2);
        ie.insert(e3);
        System.out.println(ie.printInventory());
        ie.switchObj(3, e4);
        System.out.println(ie.printInventory());
        System.out.println(e4.printDetail());
    }
}
