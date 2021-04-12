package Engimon;
import java.lang.reflect.Array;
import java.util.*;
public class driver {
    public static void main(String[] args) {
        //TESTING SKILL
        // ArrayList<String> al = new ArrayList<String>(){{
        //     add("Fire");
        //     add("Water");
        // }};


        // // TEST MAX MASTERY LEVEL
        // Skill S = new Skill("Searing chain", 30, 2, al);
        // Skill Sk = new Skill("Fire gun", 30, 1, al);
        // Skill Sp = new Skill("Earthshock", 30, 3, al);
        //     //S.printSkillDetail();
        // ArrayList<Skill> listSkill = new ArrayList<Skill>();
        // listSkill.add(S);
        // listSkill.add(Sk);
        // listSkill.add(Sp);
        // for(Skill item : listSkill){
        //     System.out.println(item.printSkillDetail());
        // }

        // AFTER GET MAX MASTERY LEVEL
        // Skill maxSkill = Breeding.getMaxMasterySkill(listSkill);
        // System.out.println("AFTER");
        // for(Skill item : listSkill){
        //     System.out.println(item.printSkillDetail());
        // }
        // System.out.println("Maxskill");
        // System.out.println(maxSkill.printSkillDetail());


        // TEST arraylist COPY
        // ArrayList<Skill> newList = new ArrayList<Skill>(listSkill);
        // newList.remove(0);
        // System.out.println("Original");
        // for(Skill item : listSkill){
        //     System.out.println(item.printSkillDetail());
        // }
        // System.out.println("Clone");
        // for(Skill item : newList){
        //     System.out.println(item.printSkillDetail());
        // }

        // TEST CHECKOTHERSKILL exist
        // System.out.println("Check exist");
        // Skill copySearingSkill = new Skill("Searing chain", 30, 2, al);
        // copySearingSkill = Breeding.CheckOtherExist(copySearingSkill, listSkill);
        // System.out.println("Hasil original : ");
        // System.out.println(copySearingSkill.printSkillDetail());
        // System.out.println("Original list ");
        // for(Skill item : listSkill){
        //     System.out.println(item.printSkillDetail());
        // }

        // // TEST INHERIT SKILL
        // ArrayList<String> childElement = new ArrayList<>(){{
        //     add("Fire");
        // }};
        // ArrayList<Skill> ASkill = new ArrayList<Skill>(){{
        //     add(new Skill("Chaos Meteor", 30, 1, new ArrayList<String>(){{
        //         add("Fire");
        //     }}));

            // add(new Skill("Overload", 30, 1, new ArrayList<String>(){{
            //     add("Fire");
            //     add("Electric");
            // }}));

            // add(new Skill("Fissure", 30, 1, new ArrayList<String>(){{
            //     add("Ground");
            // }}));

            // add(new Skill("Tsunami", 30, 1, new ArrayList<String>(){{
            //     add("Water");
            // }}));
        // }};
        // ArrayList<Skill> BSkill = new ArrayList<Skill>(){{
        //     add(new Skill("Chaos Meteor", 30, 2, new ArrayList<String>(){{
        //         add("Fire");
        //     }}));

            // add(new Skill("Tsunami", 30, 1, new ArrayList<String>(){{
            //     add("Water");
            // }}));

            // add(new Skill("Fissure", 30, 1, new ArrayList<String>(){{
            //     add("Ground");
            // }}));
            
       // }};

        // Expected hasil :
        // Childskill = Chaosmeteor level 2, overload level 1, tsunami level 2, fissure lvel 2
        // System.out.println("RESULT Inherit skill : ");
        // ArrayList<Skill> childSkill = Breeding.InheritSkill(childElement, ASkill, BSkill);
        // for(Skill s : childSkill){
        //     System.out.println(s.printSkillDetail());
        // }
        

        // TEST BREEDING 
        
        // 1 element test
        // Cyndaquil p1 = new Cyndaquil("CyndaParent1", 5);
        // Cyndaquil p2 = new Cyndaquil("CyndaParent2", 5);
        // Engimon e =  Breeding.startBreeding(p1, p2);
        // System.out.println(e.printDetail());
        
        // System.out.println("Parent : ");
        // System.out.println(p1.printDetail());
        // System.out.println(p2.printDetail());

        // // Dual element breeeding, expected species Wynter, skill nya unik dari wynter, blasto dan amaura
        // System.out.println("Test breeding 2");
        // Blastoise b = new Blastoise("ToiseBlas",5);
        // Amaura a = new Amaura("Urauraura",5);
        // Engimon e2 =  Breeding.startBreeding(b, a);
        // System.out.println(e2.printDetail());
        
        // System.out.println("Parent : ");
        // System.out.println(b.printDetail());
        // System.out.println(a.printDetail());




        // Skill skiltest = Breeding.getSkillbyElementCode(7);
        // System.out.println(skiltest.printSkillDetail());
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
        // //ELEMENT BEDA ADVANTAGE SAMA HASIL HARUSNYA KEDUA ELEMEN MASUK
        // ArrayList<String> parent5 = new ArrayList<String>(){{add("Fire");}};
        // ArrayList<String> parent6 = new ArrayList<String>(){{add("Electric");}};
        // ArrayList<String> asdfg = Breeding.InheritElements(parent5, parent6);
        // for(String item : asdfg){
        //     System.out.println(item);
        // }
        //xHASIL DAH BENER RANDOM KALAU DI RUN 2x 
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
