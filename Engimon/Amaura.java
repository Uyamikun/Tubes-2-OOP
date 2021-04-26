package Engimon;
import java.util.*;
public class Amaura extends Engimon {
    public Amaura(){
        super();
        this.name = "Ura";
        this.species = "Amaura";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Ura");
        this.ParentInfo.add("Amaura");
        this.ParentInfo.add("Ura");
        this.ParentInfo.add("Amaura");

        // Add element 
        this.elements.add("Ice");

        // add skill
        ArrayList<String> IceElement = new ArrayList<>();
        IceElement.add("Ice");
        Skill IceSkill = new Skill("Freezing Field", 30, 1, IceElement);
        this.engimonskill.add(IceSkill);
    }

    public Amaura(String name, int level){
        super(name, level);
        this.species = "Amaura";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Ura");
        this.ParentInfo.add("Amaura");
        this.ParentInfo.add("Ura");
        this.ParentInfo.add("Amaura");
        // Add element 
        this.elements.add("Ice");

        // add skill
        ArrayList<String> IceElement = new ArrayList<>();
        IceElement.add("Ice");
        Skill IceSkill = new Skill("Freezing Field", 30, 1, IceElement);
        this.engimonskill.add(IceSkill);
    }

    public String getSound(){
        String s = "When hell freezes over, I’ll start calling it Heaven.";
        return s;
    }

    // @Override
    // public String printDetail(){
    //     StringBuilder str = new StringBuilder();
    //     // str.append(("\"" + this.getSound()+ "\"\n"));
    //     str.append(super.printDetail());
    //     // System.out.println("\"" + this.getSound()+ "\"");
    //     // super.printDetail();
    //     return str.toString();
    // }
}
