package Engimon;
import java.util.*;
public class Breeding {

//================= METHOD ========================
    // Mengembalikan index dari skill yang memiliki mastery level tertinggi
    public static Skill getMaxMasterySkill(ArrayList<Skill> ESkill){
        Skill s = new Skill(ESkill.get(0));
        // for (Skill item : ESkill){
        //     System.out.println(item.printSkillDetail()); 
        // }
        return s;
    }
 
    // ArrayList<Skill> InheritSkill(ArrayList<Skill> ASkill, ArrayList<Skill> BSkill){}
 
    // String getIndex(ArrayList<String> _list, int _i){}
 
    // int getAdvantage(String A, String B); // Mengembalikan advantage A terhadap B
 
    // bool IsElementCompatible(ArrayList<String> ElementA, ArrayList<ArrayList<String>> all); // mengecek apakah list string ada pada combinasi dual yang mungkin
 
    // String CompareElementByAdvantage(String elementA, String elementB);
 
    // ArrayList<String> InheritElements(ArrayList<String> ElementA, ArrayList<String> ElementB);
 
    // Engimon startBreeding(Engimon A, Engimon B);
}
