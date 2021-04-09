package Engimon;
import java.util.*;

public class KataraToph extends Engimon {
    public KataraToph(){
        super();
        this.name = "Kaldr";
        this.species = "KataraToph";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("KataraToph"); //Species Parent 1
        this.ParentInfo.add("Kaldr"); // Parent 1 Name
        this.ParentInfo.add("KataraToph"); // Species Parent 2
        this.ParentInfo.add("Kaldr"); // Parent 2 Name
        // Add element 
        this.elements.add("Water");
        this.elements.add("Ground");

        // add skill
        ArrayList<String> watergroundElement = new ArrayList<>();
        watergroundElement.add("Water");
        watergroundElement.add("Ground");
        Skill watergroundSkill = new Skill("Watershock", 30, 1, watergroundElement);
        this.engimonskill.add(watergroundSkill);
    }

    public KataraToph(String _name,int _level){
        super(_name, _level);
        this.species = "KataraToph";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("KataraToph"); //Species Parent 1
        this.ParentInfo.add("Kaldr"); // Parent 1 Name
        this.ParentInfo.add("KataraToph"); // Species Parent 2
        this.ParentInfo.add("Kaldr"); // Parent 2 Name
        // Add element 
        this.elements.add("Water");
        this.elements.add("Ground");

        // add skill
        ArrayList<String> watergroundElement = new ArrayList<>();
        watergroundElement.add("Water");
        watergroundElement.add("Ground");
        Skill watergroundSkill = new Skill("Watershock", 30, 1, watergroundElement);
        this.engimonskill.add(watergroundSkill);
    }
    // METHOD
    public String getSound(){
        String s = "The wave breaks the world!";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }

}

