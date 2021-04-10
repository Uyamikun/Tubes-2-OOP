package Engimon;
import java.util.*;
public class driver {
    public static void main(String[] args) {
        //TESTING SKILL
        // ArrayList<String> al = new ArrayList<String>();
        // al.add("Fire");
        // al.add("Water");
        // Skill S = new Skill("Searing chain", 30, 1, al);
        // Skill Sk = new Skill("Fire gun", 30, 1, al);
        //     //S.printSkillDetail();
        // ArrayList<Skill> listSkill = new ArrayList<Skill>();
        // listSkill.add(S);
        // listSkill.add(Sk);
        // String stringSk = Sk.printSkillDetail();
        // System.out.println(stringSk);
        // Skill k = Breeding.getMaxMasterySkill(listSkill);
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
        // p.setLevel(5);
        // w.setLevel(5);
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

        
       // TEST SORTING
        // Blastoise b = new Blastoise();
        // b.setLevel(10);
        // Cyndaquil c = new Cyndaquil();
        // c.setLevel(15);
        // Amaura a = new Amaura();
        // a.setLevel(7);
        // Earthshaker e = new Earthshaker();
        // e.setLevel(13);
        // List<Engimon> listEngimon = new ArrayList<>();
        // listEngimon.add(b);
        // listEngimon.add(c);
        // listEngimon.add(a);
        // listEngimon.add(e);
        // Collections.sort(listEngimon);

        // for(Engimon engi : listEngimon){
        //     System.out.println(engi.getName());
        // }
        
        // TEST SKILL SORT
        // S.setBasePower(70);
        // Sk.setBasePower(40);
        // listSkill.add(S);
        // listSkill.add(Sk);
        // Collections.sort(listSkill);
        // // Supaya ascendant
        // Collections.reverse(listSkill);
        // for(Skill skill : listSkill){
        //     System.out.println(skill.getSkillName());
        // }
            
        //TEST INHERIT ELEMENT
        //ELEMENT SAMA HASILNYA SAMA KAYAK PARENT
        // ArrayList<String> parent1 = new ArrayList<String>(){{add("Fire");}};
        // ArrayList<String> parent2 = new ArrayList<String>(){{add("Fire");}};
        // ArrayList<String> asd = Breeding.InheritElements(parent1, parent2);
        // for(String item : asd){
        //     System.out.println(item);
        // }
        // //HASIL DAH BENER
        // //===============
        // //ELEMENT BEDA ADVANTAGE BEDA JUGA HASIL HARUSNYA ADVANTAGE YANG LEBIH TINGGI
        // ArrayList<String> parent3 = new ArrayList<String>(){{add("Fire");}};
        // ArrayList<String> parent4 = new ArrayList<String>(){{add("Water");}};
        // ArrayList<String> asdf = Breeding.InheritElements(parent3, parent4);
        // for(String item : asdf){
        //     System.out.println(item);
        // }
        // //HASIL DAH BENER
        // //=============
        // //ELEMENT BEDA ADVANTAGE SAMA HASIL HARUSNYA RANDOM
        // ArrayList<String> parent5 = new ArrayList<String>(){{add("Fire");}};
        // ArrayList<String> parent6 = new ArrayList<String>(){{add("Electric");}};
        // ArrayList<String> asdfg = Breeding.InheritElements(parent5, parent6);
        // for(String item : asdfg){
        //     System.out.println(item);
        // }
        //HASIL DAH BENER RANDOM KALAU DI RUN 2x 
        // ArrayList<String> parent7 = new ArrayList<String>(){{add("Fire");add("Electric");}};
        // ArrayList<String> parent8 = new ArrayList<String>(){{add("Water");}};
        // ArrayList<String> asdfgh = Breeding.InheritElements(parent7, parent8);
        // for(String item : asdfgh){
        //     System.out.println(item);
        // }
        // ArrayList<String> parent9 = new ArrayList<String>(){{add("Fire");add("Electric");}};
        // ArrayList<String> parent10 = new ArrayList<String>(){{add("Water");add("Ice");}};
        // ArrayList<String> asdfghj = Breeding.InheritElements(parent9, parent10);
        // for(String item : asdfghj){
        //     System.out.println(item);
        // }
    }

}
