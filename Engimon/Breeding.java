package Engimon;
import java.util.*;
public class Breeding {
    //MATRIX ADVANTAGE [FIRE,WATER,ELECTRIC,GROUND,ICE] sama kebawahnya juga gini
    private static Double[][] matrixAdvantage = 
    {
        {1.0,0.0,1.0,0.5,2.0},
        {2.0,1.0,0.0,1.0,1.0},
        {1.0,2.0,1.0,0.0,1.5},
        {1.5,1.0,2.0,1.0,0.0},
        {0.0,1.0,0.5,2.0,1.0}
    };
    private static ArrayList<String> arrayElemenString = new ArrayList<String>(){{add("Fire");add("Water");add("Electric");add("Ground");add("Ice");}};
//================= METHOD ========================

    // Mengembalikan index dari skill yang memiliki mastery level tertinggi
    public static Skill getMaxMasterySkill(ArrayList<Skill> ESkill){
        int max = ESkill.get(0).getMasteryLevel();
        int ml;
        int idx = 0;
        int count = 0;
        Skill s = new Skill(ESkill.get(0));
        for (Skill item : ESkill){
            ml = item.getMasteryLevel();
            if (ml > max)
            {
                idx = count;
                max = ml;
                s = item;
            }
            count += 1;
        }
        // Hapus yang terambil
        ESkill.remove(idx);
        return s;
    }
 
    public static int getElementCode(ArrayList<String> childElement){
        int jumlahElement = childElement.size();
        if(jumlahElement == 1){
            switch (childElement.get(0)) {
                case "Water":
                    return 1;
                case "Fire":
                    return 2;
                case "Ice":
                    return 3;
                case "Ground":
                    return 4;
                case "Electric":
                    return 5;
                default:
                    return 0;
            }
        } else{
            // jumlah element 2
            String firstEl = childElement.get(0);
            String secEl = childElement.get(1);
            if((firstEl.equals("Water") && secEl.equals("Ice")) || (firstEl.equals("Ice") && secEl.equals("Water"))){
                return 6;
            } else if ( (firstEl.equals("Water") && secEl.equals("Ground")) || (firstEl.equals("Ground") && secEl.equals("Water"))){
                return 7;
            } else if ( ((firstEl.equals("Fire") && secEl.equals("Electric"))) || (firstEl.equals("Electric") && secEl.equals("Fire"))){
                return 8;
            } else{
                return 0;
            }
        }
    }

    public static Skill getSkillbyElementCode(int elementCode){
        switch (elementCode) {
            case 1:
                return new Skill("Tsunami", 30,1, new ArrayList<String>(){{
                    add("Water");
                }});
            case 2:
                return new Skill("Chaos Meteor", 30,1, new ArrayList<String>(){{
                    add("Fire");
                }});
            case 3:
                return new Skill("Freezing Field", 30,1, new ArrayList<String>(){{
                    add("Ice");
                }});
            case 4:
                return new Skill("Fissure", 30,1, new ArrayList<String>(){{
                    add("Ground");
                }});
            case 5:
                return new Skill("Thunder God", 30,1, new ArrayList<String>(){{
                    add("Electric");
                }});
            case 6:
                return new Skill("Cold Embrace", 30,1, new ArrayList<String>(){{
                    add("Water");
                    add("Ice");
                }});
            case 7:
                return new Skill("Watershock", 30,1, new ArrayList<String>(){{
                    add("Water");
                    add("Ground");
                }});
            case 8:
                return new Skill("Overload", 30,1, new ArrayList<String>(){{
                    add("Fire");
                    add("Electric");
                }});
            default:
                return new Skill("N/A", 0,0, new ArrayList<String>());
        }
    }

    // Mengecek jika ada yang sama pada list skill lain, mengembalikan skill baru yang mastery level max
    public static Skill CheckOtherExist(Skill original, ArrayList<Skill> other){
        int count = 0;
        int idx = -1;
        for(Skill item : other){
            if(item.getSkillName().equals(original.getSkillName())){
                idx = count;

                if(original.getMasteryLevel() == item.getMasteryLevel()){
                    // Jika mastery level sama maka tambah 1
                    original.setMasteryLevel(original.getMasteryLevel()+1);
                } else if(original.getMasteryLevel() < item.getMasteryLevel()){
                    original.setMasteryLevel(item.getMasteryLevel());
                }
                // Hapus skill yang sama tadi
                other.remove(idx);
                return original;
            }
            count += 1;
        }
        return original;
    }

    //MEMBUAT SEBUAH LIST INHERIT SKILL DARI 2 BUAH ARRAY LIST SKILL
    public static ArrayList<Skill> InheritSkill(ArrayList<String> childElement, ArrayList<Skill> ASkill, ArrayList<Skill> BSkill){
        // Duplicate ASkill dan BSkill
        ArrayList<Skill> newAList = new ArrayList<Skill>(ASkill);
        ArrayList<Skill> newBList = new ArrayList<Skill>(BSkill);
        ArrayList<Skill> childSkill = new ArrayList<>();
        int elementCode = getElementCode(childElement);
        Skill childUniqueSkill = getSkillbyElementCode(elementCode);
    
        // Cek skill unik apakah dimilik oleh parent juga
        int idx = -1;
        int count = 0;
        for(Skill sa : newAList){
            if(childUniqueSkill.IsEqual(sa)){
                if(sa.getMasteryLevel() > 1){
                    childUniqueSkill.setMasteryLevel(sa.getMasteryLevel());
                }
                idx = count;
                break;       
            }
            count += 1;
        }
        // Hapus skill yang sama dengan child unik
        if(idx != -1){
            newAList.remove(idx);
        }

        idx = -1;
        count = 0;
        for(Skill sb : newBList){
            if(childUniqueSkill.IsEqual(sb)){
                if(sb.getMasteryLevel() > childUniqueSkill.getMasteryLevel()){
                    childUniqueSkill.setMasteryLevel(sb.getMasteryLevel());
                } else if(sb.getMasteryLevel() == childUniqueSkill.getMasteryLevel()){
                    childUniqueSkill.setMasteryLevel(sb.getMasteryLevel()+1);
                }
                idx = count;
                break;
            }
            count += 1;
        }
        // Hapus skill yang sama dengan child unik
        if(idx != -1){
            newBList.remove(idx);
        }
        childSkill.add(childUniqueSkill);

        // Ambil skill sampai salah satu habis atau slot penuh
        int code = 0; // kedua A dan B skill max masih null, code = 1 = A null, code = 2 B null
        Skill maxA = new Skill("N/A",0,0, new ArrayList<>()); // inisialisasi saja
        Skill maxB = new Skill("N/A",0,0, new ArrayList<>());
        while(childSkill.size() < 4 && (newAList.size() > 0) && (newBList.size() > 0)){
            if(code == 0){
                maxA = getMaxMasterySkill(newAList);
                maxB = getMaxMasterySkill(newBList); 
            } else if (code == 1){
                maxA = getMaxMasterySkill(newAList);
            } else if( code == 2){
                maxB = getMaxMasterySkill(newBList);
            } else {
                maxA = getMaxMasterySkill(newAList);
                maxB = getMaxMasterySkill(newBList); 
            }
            int masteryLevelA = maxA.getMasteryLevel();
            int masteryLevelB = maxB.getMasteryLevel();

            // Jika skill dipilih sama
            if(maxA.getSkillName().equals(maxB.getSkillName())){
                if(masteryLevelA == masteryLevelB){
                    // Jika mastery level sama maka tambah 1
                    maxA.setMasteryLevel(maxA.getMasteryLevel()+1);
                } else if(masteryLevelA < masteryLevelB){
                    maxA.setMasteryLevel(maxB.getMasteryLevel());
                }
                code = 0;
                childSkill.add(maxA);
            } else if(masteryLevelA >= masteryLevelB){
                // Skill dari A dipilih
                maxA = CheckOtherExist(maxA, newBList);
                code = 1;
                childSkill.add(maxA);
            } else{
                // Skill B dipilih
                maxB = CheckOtherExist(maxB, newAList);
                code = 2;
                childSkill.add(maxB);
            }
        }

        if(childSkill.size() < 4){
            if(code == 1){
                maxB = CheckOtherExist(maxB, newAList);
                childSkill.add(maxB);
            } else if(code == 2){
                maxA = CheckOtherExist(maxA, newBList);
                childSkill.add(maxA);
            } 
        }

        // Jika childSkill belum penuh dan skill dari A atau B masih ada
        while(childSkill.size() < 4 && (newAList.size() > 0) || (newBList.size() > 0) ){
            if(newAList.size() > 0){
                childSkill.add(newAList.get(0));
                newAList.remove(0);
            } else if(newBList.size() > 0){
                childSkill.add(newBList.get(0));
                newBList.remove(0);
            }
        }
        return childSkill;
    }
 

    //INHERIT ELEMENT
    public static int getIndexElement(String elemen){
        return Breeding.arrayElemenString.indexOf(elemen);
    }
        //MENGEMBALIKAN STRING/ELEMENT SESUAI ADVANTAGE
    public static ArrayList<String> CompareElementByAdvantage(String A, String B){
        int elemen1 = getIndexElement(A);
        int elemen2 = getIndexElement(B);
        Double advantage = Breeding.matrixAdvantage[elemen1][elemen2];
        ArrayList<String> result = new ArrayList<String>();
        if(advantage>1.0){
            
            result.add(Breeding.arrayElemenString.get(elemen1));
        }
        if(advantage < 1.0){
            result.add(Breeding.arrayElemenString.get(elemen2));
        }
        else{
            if(A.equals(B)){
                result.add(Breeding.arrayElemenString.get(elemen1));
                
            }else{
                result.add(Breeding.arrayElemenString.get(elemen1));
                result.add(Breeding.arrayElemenString.get(elemen2));
            }
        }
        return result; 
    } 
    
    public static Boolean isElementCompatible(ArrayList<String> tempElement, ArrayList<ArrayList<String>> all){
        Boolean result = false;
        for(ArrayList<String> listElement : all){
            int counter = 0;
            for(String element : listElement){
                if(tempElement.get(0) == element){
                    counter += 1;
                }
                if(tempElement.get(1) == element){
                    counter += 1;
                }
            }
            if(counter == 2) result = true; 
        }
        return result;
    } 
    public static ArrayList<String> InheritElements(ArrayList<String> ElementA, ArrayList<String> ElementB){
        ArrayList<String> first = new ArrayList<String>()
        {
            {
                add("Fire");
                add("Electric");
            }
        };
        ArrayList<String> second = new ArrayList<String>()
        {   {
                add("Water");
                add("Ice");
            }
        };
        ArrayList<String> third = new ArrayList<String>(){
            {
                add("Water");
                add("Ground");
            }
        };
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>(){
            {
                add(first);
                add(second);
                add(third);
            }
        };
        ArrayList<String> tempElement = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        if(ElementA.size() == 1 && ElementB.size() == 1){
            temp = CompareElementByAdvantage(ElementA.get(0), ElementB.get(0));
            for(String item : temp){
                tempElement.add(item);
            }
        }
        if(ElementA.size() > 1 || ElementB.size() > 1){
            //MEMASUKKAN ELEMENT PARENT KE TEMPORARY LIST ELEMENT
            for(String elA : ElementA){
                for(String elB : ElementB){
                    temp = CompareElementByAdvantage(elA, elB);
                    for(String item : temp){
                        if(!tempElement.contains(item)){
                            tempElement.add(item);
                        }
                    }
                    
                }
            }

            // HANDLE SIZE TEMPORARY > 2
            if(tempElement.size() > 2){
                while(tempElement.size() > 1){
                    tempElement.remove(tempElement.size()-1);
                }
            }
            // HANDLE ELEMENTNYA COMPATIBLE TIDAK
            else if(tempElement.size() == 2){
                if(!isElementCompatible(tempElement, all)){
                    ArrayList<String> temphasil = new ArrayList<String>();
                    temphasil = CompareElementByAdvantage(tempElement.get(0), tempElement.get(1));
                    tempElement.clear();
                    for(String item : temphasil){
                        tempElement.add(item);
                    }
                }
            }
        }
        return tempElement;
    }
 
    public static Engimon startBreeding(Engimon A, Engimon B) throws BreedingInvalidException{
        if(A.getLevel() < 4 || B.getLevel() < 4){
            //throw Exception; 
            throw new BreedingInvalidException();
        }
        else{
            //LEVEL PARENT BERKURANG 3 dan cumulative exp berkurang 3 * 100
            A.setLevel(A.getLevel()-3);
            B.setLevel(B.getLevel()-3);
            A.setCumExp(A.getCumExp() - 300);
            B.setCumExp(B.getCumExp() - 300);
            A.setExp(0);
            B.setExp(0);

            //INHERIT ELEMENT
            ArrayList<String> childElement = InheritElements(A.getElements(), B.getElements());

            //INHERIT SKILL
            ArrayList<Skill> childSkill = InheritSkill(childElement, A.getEngimonSkill(), B.getEngimonSkill());

            // PARENT INFO
            ArrayList<String> parentInfo = new ArrayList<>();
            parentInfo.add(A.getName());
            parentInfo.add(A.getSpecies());
            parentInfo.add(B.getName());
            parentInfo.add(B.getSpecies());

            int ChildelementCode = getElementCode(childElement);
            switch (ChildelementCode) {
                case 1:
                // water
                    Blastoise b = new Blastoise();
                    b.setAllSkill(childSkill);
                    b.setParentInfo(parentInfo);
                    return b;
                case 2:
                // fire
                    Cyndaquil c = new Cyndaquil();
                    c.setAllSkill(childSkill);
                    c.setParentInfo(parentInfo);
                    return c;
                case 3:
                // Ice
                    Amaura a = new Amaura();
                    a.setAllSkill(childSkill);
                    a.setParentInfo(parentInfo);
                    return a;
                case 4:
                // Ground
                    Earthshaker e = new Earthshaker();
                    e.setAllSkill(childSkill);
                    e.setParentInfo(parentInfo);
                    return e;
                case 5:
                // Electric
                    Pikachu p = new Pikachu();
                    p.setAllSkill(childSkill);
                    p.setParentInfo(parentInfo);
                    return p;
                case 6:
                // Water/Ice
                    Wynter w = new Wynter();
                    w.setAllSkill(childSkill);
                    w.setParentInfo(parentInfo);
                    return w;
                case 7:
                // Water ground
                    KataraToph kt = new KataraToph();
                    kt.setAllSkill(childSkill);
                    kt.setParentInfo(parentInfo);
                    return kt;
                case 8:
                // Fire electric
                    Hu_Tao ht = new Hu_Tao();
                    ht.setAllSkill(childSkill);
                    ht.setParentInfo(parentInfo);
                    return ht;
                default:
                    return new Pikachu();
            }
        }
    }
}
