package Engimon;
import java.util.*;
public class Breeding {
    private static Double[][] matrixAdvantage = {{1.0,0.0,1.0,0.5,2.0},{2.0,1.0,0.0,1.0,1.0},{1.0,2.0,1.0,0.0,1.5},{1.5,1.0,2.0,1.0,0.0},{0.0,1.0,0.5,2.0,1.0}};

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
 
    // ArrayList<Skill> InheritSkill(ArrayList<Skill> ASkill, ArrayList<Skill> BSkill){}
 
    // String getIndex(ArrayList<String> _list, int _i){}
 
    // int getAdvantage(String A, String B); // Mengembalikan advantage A terhadap B
 
    // bool IsElementCompatible(ArrayList<String> ElementA, ArrayList<ArrayList<String>> all); // mengecek apakah list string ada pada combinasi dual yang mungkin
 
    // String CompareElementByAdvantage(String elementA, String elementB);
 
    // ArrayList<String> InheritElements(ArrayList<String> ElementA, ArrayList<String> ElementB);
 
    // Engimon startBreeding(Engimon A, Engimon B);
}
