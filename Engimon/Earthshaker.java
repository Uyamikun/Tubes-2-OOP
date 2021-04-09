package Engimon;
import java.util.*;
public class Earthshaker extends Engimon {
    public Earthshaker(){
        super();
        this.name = "ES";
        this.species = "Earthshaker";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Raigor");
        this.ParentInfo.add("Earthshaker");
        this.ParentInfo.add("Raigor");
        this.ParentInfo.add("Earthshaker");
        // Add element 
        this.elements.add("Ground");

        // add skill
        ArrayList<String> GroundElement = new ArrayList<>();
        GroundElement.add("Ground");
        Skill GroundSkill = new Skill("Fissure", 30, 1, GroundElement);
        this.engimonskill.add(GroundSkill);
    }

    public Earthshaker(String name, int level){
        super(name, level);
        this.species = "Earthshaker";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Raigor");
        this.ParentInfo.add("Earthshaker");
        this.ParentInfo.add("Raigor");
        this.ParentInfo.add("Earthshaker");

        // Add element 
        this.elements.add("Ground");

        // add skill
        ArrayList<String> GroundElement = new ArrayList<>();
        GroundElement.add("Ground");
        Skill GroundSkill = new Skill("Fissure", 30, 1, GroundElement);
        this.engimonskill.add(GroundSkill);
    }

    public String getSound(){
        String s = "There may be many earths, but there is only one Earthshaker";
        return s;
    }

    @Override
    public void printDetail(){
        System.out.println("\"" + this.getSound()+ "\"");
        super.printDetail();
    }
}
