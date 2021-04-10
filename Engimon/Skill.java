package Engimon;

import java.util.*;

public class Skill {
    // Atribut
    protected String skillName;
    protected int basePower;
    protected int masteryLevel;
    protected ArrayList<String> elements; // array of element yang boleh mempelajari skill ini

    public Skill(String skillname, int basePower, int masteryLevel, ArrayList<String> NewElements) {
        this.skillName = skillname;
        this.basePower = basePower;
        this.masteryLevel = masteryLevel;
        this.elements = new ArrayList<String>();
        this.elements.addAll(NewElements);
    }

    public Skill(Skill _skill){
        this.skillName = _skill.skillName;
        this.basePower = _skill.basePower;
        this.masteryLevel = _skill.masteryLevel;
        this.elements = new ArrayList<String>();
        this.elements.addAll(_skill.elements);
    }
    
    public String getSkillName(){
        return this.skillName;
    }

    public int getBasePower(){
        return this.basePower;
    }

    public int getMasteryLevel(){
        return this.masteryLevel;
    }

    public void setMasteryLevel(int newMasteryLevel){
        this.masteryLevel = newMasteryLevel;
    }

    public ArrayList<String> getElements(){
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(this.elements);
        return temp;
    }

    public boolean IsEqual (Skill otherSkill){
        return (this.skillName == otherSkill.getSkillName() && this.masteryLevel == otherSkill.getMasteryLevel());
    }
    public String printSkillDetail(){
        StringBuilder str = new StringBuilder();
        str.append("Skill name : " + this.skillName + "\n");
        str.append("Base power : " + this.basePower + "\n");
        str.append("Mastery level : " + this.masteryLevel + "\n");
        str.append("Skill elements : \n");
        this.elements.forEach((element) -> str.append("- " + element + "\n"));
        str.append("\n");
        return str.toString();
        // System.out.println("Skill name : " + this.skillName);
        // System.out.println("Base power : " + this.basePower);
        // System.out.println("Mastery level : " + this.masteryLevel);
        // System.out.println("Skill elements : ");
        // this.elements.forEach((element) -> System.out.println("- " + element));
        // System.out.println();
    }
}

