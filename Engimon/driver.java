package Engimon;
import java.util.*;
public class driver {
    public static void main(String[] args) {
        //TESTING SKILL
        ArrayList<String> al = new ArrayList<String>();
        al.add("Fire");
        al.add("Water");
        Skill S = new Skill("Searing chain", 30, 1, al);
        Skill Sk = new Skill("Fire gun", 30, 1, al);
            //S.printSkillDetail();
        ArrayList<Skill> listSkill = new ArrayList<Skill>();
        listSkill.add(S);
        listSkill.add(Sk);
        // String stringSk = Sk.printSkillDetail();
        // System.out.println(stringSk);
        Skill a = Breeding.getMaxMasterySkill(listSkill);
        //TESTING SPESIES
        // Blastoise b = new Blastoise();
        // Cyndaquil c = new Cyndaquil();
        // Amaura a = new Amaura();
        // Earthshaker e = new Earthshaker();
        // // b.printDetail();
        // System.out.println();
        // c.printDetail();
        // System.out.println();
        // a.printDetail();
        // System.out.println();
        // e.printDetail();

        // Pikachu p = new Pikachu();
        // Wynter w = new Wynter();
        // KataraToph kt = new KataraToph();
        // Hu_Tao ht = new Hu_Tao();
        
        // String str = p.printDetail();
        // System.out.println(str);
        // System.out.println();
        // w.printDetail();
        // System.out.println();
        // kt.printDetail();
        // System.out.println();
        // ht.printDetail();
        // System.out.println();

        
    }

}
