package Engimon;
import java.util.*;

public abstract class Engimon implements Comparable<Engimon> {
    private static int numOfEngimon = 0;
    protected int id;
    protected String name;
    protected String species;
    protected int life;
    protected int level;
    protected int exp;
    protected int cumulativeExp;
    ArrayList<String> ParentInfo;// Pasangan parent 1 spesies 1, parent 2 spesies 2
    ArrayList<Skill> engimonskill;
    ArrayList<String> elements;

//================= CTOR DEFAULT && USER DEFINE =======
    public Engimon(){
        this.life = 3;
        this.exp = 0;
        this.cumulativeExp = 0;
        this.level = 1;
        this.id = numOfEngimon;
        numOfEngimon += 1;        
    }
    public Engimon(String name, int level){
        this.name = name;
        this.level = level;
        this.life = 3;
        this.exp = 0;
        this.cumulativeExp = 0;
        this.id = numOfEngimon;
        numOfEngimon += 1;
    }

//================== GETTER SETTER=====================
    // Engimon Name
    public void setName(String _name){
        this.name = _name;
    }
    public String getName(){
        return this.name;
    }
    
    // ID
    public void setID(int _id){
        this.id = _id;
    }
    public int getID(){
        return this.id;
    }

    // Species
    public void setSpecies(String _species){
        this.species = _species;
    }
    public String getSpecies(){
        return this.species;
    }

    // Life
    public void setLife(int newLife){
        this.life = newLife;
    }

    public int getLife(){
        return this.life;
    }

    // Parent Info
    public ArrayList<String> getParentInfo(){
        return this.ParentInfo;
    }
    public void setParentInfo(ArrayList<String> _ParentInfo){
        this.ParentInfo = _ParentInfo;
    }
    
    // Skill
    public ArrayList<Skill> getEngimonSkill(){
        return this.engimonskill;
    }
    public void setAllSkill(ArrayList<Skill> newSkill){
        this.engimonskill.clear();
        this.engimonskill.addAll(newSkill);
    }
        // Jika skill sudah penuh, ganti skill pertama menjadi new SKill
    public void setEngimonSkill(Skill newSkill){
        if (this.engimonskill.size() > 4)
        {
            this.engimonskill.remove(0);
        }
        this.engimonskill.add(newSkill);
    }

    // Elements Getter
    public ArrayList<String> getElements(){
        return this.elements;
    }
    public void setELements(ArrayList<String> newElements){
        this.elements = newElements;
    }

    // Level
    public int getLevel(){
        return this.level;
    }
        // Set level menjadi newlevel
    public void setLevel(int newLevel){
        this.level = newLevel;
    }

    // Experience
    public int getExp(){
        return this.exp;
    }
    public void setExp(int newExp){
        this.exp = newExp;
    }

    // Cumulative Exp
    public int getCumExp(){
        return this.cumulativeExp;
    }
    public void setCumExp(int newexp){
        if(newexp < 0){
            this.cumulativeExp = 0;
        } else{
            this.cumulativeExp = newexp;
        }
    }

    // Override comparator 
    // Sorted descendant
    @Override
    public int compareTo(Engimon other) {
        return Integer.compare(getLevel(), other.getLevel());
    }

//================= METHOD OVERLOAD ====================
    public String printDetail(){ 
        StringBuilder str = new StringBuilder();
        str.append(("\"" + this.getSound()+ "\"\n"));
        str.append("ID : " + this.id + "\n");
        str.append("Nama : " + this.name + "\n");
        str.append("Spesies : " + this.species + "\n");
        str.append("Life : " + this.life + "\n");
        str.append("Level " + this.level + "\n");
        str.append("Exp : " + this.exp + "\n");
        str.append("CumExp : " + this.cumulativeExp + "\n");
        str.append("==========================================" + "\n");
        str.append("Parent 1 : " + this.ParentInfo.get(0)  + "\n");
        str.append("Species 1 : "+ this.ParentInfo.get(1)  + "\n");
        str.append("Parent 2 : " + this.ParentInfo.get(2)  + "\n");
        str.append("Parent 2 : " + this.ParentInfo.get(3)  + "\n");
        str.append("================= SKILL DETAIL ============\n");
        this.engimonskill.forEach((sk) -> str.append(sk.printSkillDetail()));
        str.append("================= Element =================\n");
        this.elements.forEach((element) -> str.append("- " + element + "\n"));
        return str.toString();
        // System.out.println("ID : " + this.id);
        // System.out.println("Nama : " + this.name);
        // System.out.println("Spesies : " + this.species);
        // System.out.println("Life : " + this.life);
        // System.out.println("Level " + this.level);
        // System.out.println("Exp : " + this.exp);
        // System.out.println("CumExp : " + this.cumulativeExp);
        // System.out.println("==========================================");
        // System.out.println("Parent info : ");

        // System.out.println("Parent 1 : " + this.ParentInfo.get(0));
        // System.out.println("Species 1 : "+ this.ParentInfo.get(1));
        // System.out.println("Parent 2 : " + this.ParentInfo.get(2));
        // System.out.println("Species 2 : "+ this.ParentInfo.get(3));
        
        // System.out.println("================= SKILL DETAIL ============");
        // this.engimonskill.forEach((sk) -> sk.printSkillDetail());
        // System.out.println("================= Element =================");
        // this.elements.forEach((element) -> System.out.println("- " + element));

    }
//================= ABSTRACT METHOD ====================
    // Sound
    public abstract String getSound();
}
    