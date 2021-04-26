package Engimon;
import java.util.*;
public class Blastoise extends Engimon {
    public Blastoise(){
        super();
        this.name = "Blasto";
        this.species = "Blastoise";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Blasto");
        this.ParentInfo.add("Blastoise");
        this.ParentInfo.add("Blasto");
        this.ParentInfo.add("Blastoise");

        // Add element 
        this.elements.add("Water");

        // add skill
        ArrayList<String> waterElement = new ArrayList<>();
        waterElement.add("Water");
        Skill waterSkill = new Skill("Tsunami", 30, 1, waterElement);
        this.engimonskill.add(waterSkill);
    }

    public Blastoise(String name, int level){
        super(name, level);
        this.species = "Blastoise";
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<String>();
        this.engimonskill = new ArrayList<Skill>();

        // Add parent info
        this.ParentInfo.add("Blasto");
        this.ParentInfo.add("Blastoise");
        this.ParentInfo.add("Blasto");
        this.ParentInfo.add("Blastoise");
        // Add element 
        this.elements.add("Water");

        // add skill
        ArrayList<String> waterElement = new ArrayList<>();
        waterElement.add("Water");
        Skill waterSkill = new Skill("Tsunami", 30, 1, waterElement);
        this.engimonskill.add(waterSkill);
    }

    public String getSound(){
        String s = "Time to test the waters";
        return s;
    }

    // @Override
    // public void printDetail(){
    //     System.out.println("\"" + this.getSound()+ "\"");
    //     super.printDetail();
    // }
}
