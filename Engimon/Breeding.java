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
 
    // ArrayList<Skill> InheritSkill(ArrayList<Skill> ASkill, ArrayList<Skill> BSkill){

    // }
 
    // String getIndex(ArrayList<String> _list, int _i){
        
    // }
    int getIndexElement(String elemen){
        return Breeding.arrayElemenString.indexOf(elemen);
    }
    Double getAdvantage(String A, String B){
        int elemen1 = getIndexElement(A);
        int elemen2 = getIndexElement(B);
        return Breeding.matrixAdvantage[elemen1][elemen2];
    } // Mengembalikan advantage A terhadap B
    
    // bool IsElementCompatible(ArrayList<String> ElementA, ArrayList<ArrayList<String>> all); // mengecek apakah list string ada pada combinasi dual yang mungkin
 
    // String CompareElementByAdvantage(String elementA, String elementB);
 
    // ArrayList<String> InheritElements(ArrayList<String> ElementA, ArrayList<String> ElementB);
 
    // Engimon startBreeding(Engimon A, Engimon B);
}
