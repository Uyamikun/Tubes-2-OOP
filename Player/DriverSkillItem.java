package Player;
import java.util.*;
import Engimon.*;

// javac Player/DriverSkillItem.java
// CATATAN: Nanti implement comparablenya di skill item aja, soalnya yang perlu disorting nanti yang skill item

public class DriverSkillItem {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(){{
            add("Fire");
            add("Water");
        }};

        Skill S = new Skill("Searing chain", 31, 2, al);
        Skill Sk = new Skill("Fire gun", 30, 1, al);
        Skill Sp = new Skill("Earthshock", 32, 3, al);
        Skill So = new Skill("Tatap mata ojan", 100, 3, al);
        ArrayList<SkillItem> listSkill = new ArrayList<SkillItem>();
        listSkill.add(new SkillItem(S));
        listSkill.add(new SkillItem(Sk));
        listSkill.add(new SkillItem(Sp));
        listSkill.add(new SkillItem(So));

        Engimon e1 = new Blastoise();

        //System.out.println(e1.printDetail());
        for(int i = 0; i < listSkill.size(); i++){
            if(listSkill.get(i).learn(e1)){
                System.out.println("Berhasil melakukan learn skill item");
            } else{
                System.out.println("Gagal melakukan learn skill item");
            }
        }
        if(listSkill.get(3).learn(e1)){
            System.out.println("Berhasil melakukan learn skill item");
        } else{
            System.out.println("Gagal melakukan learn skill item");
        }

        System.out.println(e1.printDetail());

        Collections.sort(listSkill);
        Collections.reverse(listSkill);
        for(SkillItem si : listSkill){
            System.out.print(si.printSkillItem());
        }
    }
}
