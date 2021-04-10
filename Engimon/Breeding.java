package Engimon;
import java.util.*;
public class Breeding {
    //MATRIX ADVANTAGE [FIRE,WATER,ELECTRIC,GROUND,ICE] sama kebawahnya juga gini
    private static Double[][] matrixAdvantage = {{1.0,0.0,1.0,0.5,2.0},{2.0,1.0,0.0,1.0,1.0},{1.0,2.0,1.0,0.0,1.5},{1.5,1.0,2.0,1.0,0.0},{0.0,1.0,0.5,2.0,1.0}};
    private static ArrayList<String> arrayElemenString = new ArrayList<String>(){{add("Fire");add("Water");add("Electric");add("Ground");add("Ice");}};
//================= METHOD ========================

    // Mengembalikan index dari skill yang memiliki mastery level tertinggi
    public Skill getMaxMasterySkill(ArrayList<Skill> ESkill){
        int max = ESkill.get(0).getMasteryLevel();
        int ml;
        Skill s = new Skill(ESkill.get(0));
        for (Skill item : ESkill){
            ml = item.getMasteryLevel();
            if (ml > max)
            {
                max = ml;
                s = item;
            }
        }
        return s;
    }
 
    //MEMBUAT SEBUAH LIST INHERIT SKILL DARI 2 BUAH ARRAY LIST SKILL
    // ArrayList<Skill> InheritSkill(ArrayList<Skill> ASkill, ArrayList<Skill> BSkill){

    // }
 
    // String getIndex(ArrayList<String> _list, int _i){
        
    // }

    //INHERIT ELEMENT
    public int getIndexElement(String elemen){
        return Breeding.arrayElemenString.indexOf(elemen);
    }
        //MENGEMBALIKAN STRING/ELEMENT SESUAI ADVANTAGE
    public String CompareElementByAdvantage(String A, String B){
        int elemen1 = getIndexElement(A);
        int elemen2 = getIndexElement(B);
        Double advantage = Breeding.matrixAdvantage[elemen1][elemen2];
        int result;
        if(advantage>1.0){
            result = elemen1;
        }
        if(advantage < 1.0){
                result = elemen2;
        }
        else{
            Random random = new Random();
            int index = random.nextInt(2);
            if(index == 0) result = elemen1;
            else result = elemen2; 
        }
        return Breeding.arrayElemenString.get(result);
    } 
    
    public Boolean isElementCompatible(ArrayList<String> tempElement, ArrayList<ArrayList<String>> all){
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
    public ArrayList<String> InheritElements(ArrayList<String> ElementA, ArrayList<String> ElementB){
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
        String result;

        if(ElementA.size() == 1 && ElementB.size() == 1){
            tempElement.add(CompareElementByAdvantage(ElementA.get(0), ElementB.get(0)));
        }
        if(ElementA.size() > 1 || ElementB.size() > 1){
            //MEMASUKKAN ELEMENT PARENT KE TEMPORARY LIST ELEMENT
            for(String elA : ElementA){
                for(String elB : ElementB){
                    result = CompareElementByAdvantage(elA, elB);
                    if(!tempElement.contains(result)){
                        tempElement.add(result);
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
                    String hasil = CompareElementByAdvantage(tempElement.get(0), tempElement.get(1));
                    tempElement.clear();
                    tempElement.add(hasil);
                }
            }
        }
        return tempElement;
    }
 
    // public static Engimon startBreeding(Engimon A, Engimon B){
    //     if(A.getLevel() < 4 || B.getLevel() < 4){
    //         //throw Exception; 
    //     }
    //     else{
    //         //LEVEL PARENT BERKURANG 3
    //         A.setLevel(A.getLevel()-3);
    //         B.setLevel(B.getLevel()-3);

    //         //INHERIT SKILL

    //         //INHERIT ELEMENT
        
    //     }
    //     return new Pikachu();
    // }
}
