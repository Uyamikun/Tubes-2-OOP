package Engimon;
import java.util.*;
public class Cyndaquil extends Engimon {
    public Cyndaquil(){
        super();
        this.name = "Cynda";
        this.species = "Cyndaquil";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Cynda");
        this.ParentInfo.add("Cyndaquil");
        this.ParentInfo.add("Cynda");
        this.ParentInfo.add("Cyndaquil");
        // Add element 
        this.elements.add("Fire");

        // add skill
        ArrayList<String> FireElement = new ArrayList<>();
        FireElement.add("Fire");
        Skill FireSkill = new Skill("Chaos Meteor", 30, 1, FireElement);
        this.engimonskill.add(FireSkill);
    }

    public Cyndaquil(String name, int level){
        super(name, level);
        this.species = "Cyndaquil";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Cynda");
        this.ParentInfo.add("Cyndaquil");
        this.ParentInfo.add("Cynda");
        this.ParentInfo.add("Cyndaquil");

        // Add element 
        this.elements.add("Fire");

        // add skill
        ArrayList<String> FireElement = new ArrayList<>();
        FireElement.add("Fire");
        Skill FireSkill = new Skill("Chaos Meteor", 30, 1, FireElement);
        this.engimonskill.add(FireSkill);
    }

    public String getSound(){
        String s = "Burn baby burn";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }
}
