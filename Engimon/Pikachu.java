package Engimon;
import java.util.*;

public class Pikachu extends Engimon {

    //CTOR DEFAULT
    public Pikachu(){
        super();
        this.name = "PikaPika";
        this.species = "Pikachu";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("PikaPika"); // Parent 1 Name
        this.ParentInfo.add("Pikachu"); //Species Parent 1
        this.ParentInfo.add("PikaPika"); // Parent 2 Name
        this.ParentInfo.add("Pikachu"); // Species Parent 2
        // Add element 
        this.elements.add("Electric");

        // add skill
        ArrayList<String> electricElement = new ArrayList<>();
        electricElement.add("Electric");
        Skill electricSkill = new Skill("Thunder God", 30, 1, electricElement);
        this.engimonskill.add(electricSkill);

    }

    //CTOR USE DEFINE
    public Pikachu(String _name,int _level){
        super(_name, _level);
        this.species = "Pikachu";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Pikachu"); //Species Parent 1
        this.ParentInfo.add("PikaPika"); // Parent 1 Name
        this.ParentInfo.add("Pikachu"); // Species Parent 2
        this.ParentInfo.add("PikaPika"); // Parent 2 Name
        // Add element 
        this.elements.add("Electric");

        // add skill
        ArrayList<String> electricElement = new ArrayList<>();
        electricElement.add("Electric");
        Skill electricSkill = new Skill("Thunder God", 30, 1, electricElement);
        this.engimonskill.add(electricSkill);
    }
    
    // METHOD 
    public String getSound(){
        String s = "Pika?! Pika Pikaa~";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }
}
