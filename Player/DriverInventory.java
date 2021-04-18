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
        if(isi.insert(new SkillItem(Sp))){
            System.out.println("Berhasil menyimpan ke dalam inventory");
        } else{
            System.out.println("Gagal menyimpan ke dalam inventory");
        }
        isi.insert(new SkillItem(Sp));
        isi.insert(new SkillItem(Sp));
        isi.removeX(1, 2);

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
        if(ie.insert(e3)){
            System.out.println("Berhasil menyimpan ke dalam inventory");
        } else{
            System.out.println("Gagal menyimpan ke dalam inventory");
        }
        System.out.println(ie.printInventory());
        e4 = ie.switchObj(3, e4);
        e4 = ie.switchObj(1, e4);
        System.out.println(ie.printInventory());
        System.out.println(e4.printDetail());
    }
}
