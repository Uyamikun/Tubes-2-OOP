package Engimon;
import java.util.*;

public class Ganyu extends Engimon {
    public Ganyu(){
        this.name = "Ganyu is my wife";
        this.species = "Ganyu";
        this.level = 0;
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>(); 
    }
    public void printDetail(){
        System.out.print("Name : ");
        System.out.println(this.name);
        System.out.print("Species : ");
        System.out.println(this.species);
    }

    public String getSound(){
        return "Shigoto wa Mada Owatte masen, yusunde ii desuka?\n";
    }

    public static void main(String[] args){
        Ganyu a = new Ganyu();
        a.printDetail();
        System.out.println(a.getSound());
    }
}
