import java.util.*;

import Engimon.Skill;

public class driver {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Fire");
        al.add("Water");

        Skill S = new Skill("Searing chain", 30, 1, al);
        S.printSkillDetail();

        Ganyu a = new Ganyu();
        a.printDetail();
        System.out.println(a.getSound());
    }

}
