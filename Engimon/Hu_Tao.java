package Engimon;
import java.util.*;

public class Hu_Tao extends Engimon {
    public Hu_Tao(){
        super();
        this.name = "Xin";
        this.species = "Hu_Tao";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Hu_Tao"); //Species Parent 1
        this.ParentInfo.add("Xin"); // Parent 1 Name
        this.ParentInfo.add("Hu_Tao"); // Species Parent 2
        this.ParentInfo.add("Xin"); // Parent 2 Name
        // Add element 
        this.elements.add("Fire");
        this.elements.add("Electric");

        // add skill
        ArrayList<String> fireelectricElement = new ArrayList<>();
        fireelectricElement.add("Fire");
        fireelectricElement.add("Electric");
        Skill fireelectricSkill = new Skill("Overload", 30, 1, fireelectricElement);
        this.engimonskill.add(fireelectricSkill);
    }
    public Hu_Tao(String _name,int _level){
        super(_name, _level);
        this.species = "Hu_Tao";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Hu_Tao"); //Species Parent 1
        this.ParentInfo.add("Xin"); // Parent 1 Name
        this.ParentInfo.add("Hu_Tao"); // Species Parent 2
        this.ParentInfo.add("Xin"); // Parent 2 Name
        // Add element 
        this.elements.add("Fire");
        this.elements.add("Electric");

        // add skill
        ArrayList<String> fireelectricElement = new ArrayList<>();
        fireelectricElement.add("Fire");
        fireelectricElement.add("Electric");
        Skill fireelectricSkill = new Skill("Overload", 30, 1, fireelectricElement);
        this.engimonskill.add(fireelectricSkill);
    }
    // METHOD
    public String getSound(){
        String s = "Their sanity I'll shatter, their dreams of conquest I'll destroy.";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }
}
