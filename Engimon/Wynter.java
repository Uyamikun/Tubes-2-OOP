package Engimon;
import java.util.*;
public class Wynter extends Engimon{
    public Wynter(){
        super();
        this.name = "Auroth";
        this.species = "Wynter";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Auroth"); // Parent 1 Name
        this.ParentInfo.add("Wynter"); //Species Parent 1
        this.ParentInfo.add("Auroth"); // Parent 2 Name
        this.ParentInfo.add("Wynter"); // Species Parent 2
        
        // Add element 
        this.elements.add("Water");
        this.elements.add("Ice");

        // add skill
        ArrayList<String> watericeElement = new ArrayList<>();
        watericeElement.add("Water");
        watericeElement.add("Ice");
        Skill watericeSkill = new Skill("Cold Embrace", 30, 1, watericeElement);
        this.engimonskill.add(watericeSkill);
    }

    public Wynter(String _name,int _level){
        super(_name,_level);
        this.species = "Wynter";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Auroth"); // Parent 1 Name
        this.ParentInfo.add("Wynter"); //Species Parent 1
        this.ParentInfo.add("Auroth"); // Parent 2 Name
        this.ParentInfo.add("Wynter"); // Species Parent 2
        
        // Add element 
        this.elements.add("Water");
        this.elements.add("Ice");

        // add skill
        ArrayList<String> watericeElement = new ArrayList<>();
        watericeElement.add("Water");
        watericeElement.add("Ice");
        Skill watericeSkill = new Skill("Cold Embrace", 30, 1, watericeElement);
        this.engimonskill.add(watericeSkill);
    }

    // METHOD
    public String getSound(){
        String s = "In cold there is comfort";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }

}
