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
        ArrayList<SkillItem> listSkill = new ArrayList<SkillItem>();
        listSkill.add(new SkillItem(S));
        listSkill.add(new SkillItem(Sk));
        listSkill.add(new SkillItem(Sp));

        Collections.sort(listSkill);
        Collections.reverse(listSkill);
        for(SkillItem si : listSkill){
            System.out.print(si.printSkillItem());
        }
    }
}
