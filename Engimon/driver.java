package Engimon;
import java.util.*;
public class driver {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Fire");
        al.add("Water");

        Skill S = new Skill("Searing chain", 30, 1, al);
        Skill Sk = new Skill("Fire gun", 30, 1, al);

        S.printSkillDetail();

        // Ganyu a = new Ganyu();
        // a.printDetail();
        // System.out.println(a.getSound());
        ArrayList<Skill> listSkill = new ArrayList<Skill>();
        listSkill.add(S);
        listSkill.add(Sk);


        Blastoise b = new Blastoise();
        Cyndaquil c = new Cyndaquil();
        Amaura a = new Amaura();
        Earthshaker e = new Earthshaker();

        b.printDetail();
        System.out.println();
        c.printDetail();
        System.out.println();
        a.printDetail();
        System.out.println();
        e.printDetail();

        // Blastoise bl = new Blastoise("Quipper", 20);
        // bl.setExp(300);
        // bl.setCumExp(2000);
        // bl.setName("Quippers Nick");
        // bl.printDetail();
    }

}
