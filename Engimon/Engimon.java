package Engimon;
import java.util.*;

public abstract class Engimon {
    protected static int numOfEngimon = 0;
    protected int id;
    protected String name;
    protected String species;
    protected int level;
    protected int exp;
    protected int cumulativeExp;
    ArrayList<String> ParentInfo;// Pasangan parent 1 spesies 1, parent 2 spesies 2
    ArrayList<Skill> elements;// Elemen yang dimiliki engimon bisa lebih dari 1

    // numOfEngimon++;
    // this->name = "N/A";
    // this->species = "N/A";
    // this->level = 1;
    // this->exp = 0;
    // this->cumulativeExp = 0;
    // this->ParentInfo = make_tuple(make_tuple("N/A", "N/A"), make_tuple("N/A", "N/A"));
    // this->sound = "";

//================= CTOR DEFAULT && USER DEFINE =======
    public Engimon(){
        this.name = name;
        this.species = species;
        this.level = level;
        this.exp = 0;
        this.cumulativeExp = 0;
        this.ParentInfo = new ArrayList<String>();
        this.elements = new ArrayList<Skill>();
        this.id = numOfEngimon;
        numOfEngimon += 1;        
    }
    public Engimon(String name, String species, ArrayList<String> _ParentInfo, ArrayList<Skill> _elements, int level){
        this.name = name;
        this.species = species;
        this.level = level;
        this.exp = 0;
        this.cumulativeExp = 0;
        this.ParentInfo = new ArrayList<String>();
        this.ParentInfo.addAll(_ParentInfo);
        this.elements = new ArrayList<Skill>();
        this.elements.addAll(_elements);
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

    // Parent Info
    public ArrayList<String> getParentInfo(){}
    public void setParentInfo(ArrayList<String> _ParentInfo){}
    
    // Skill
    public ArrayList<Skill> getEngimonSkill(){}
    public void setAllSkill(ArrayList<Skill> newSkill){}
        // Jika skill sudah penuh, ganti skill pertama menjadi new SKill
    public void setEngimonSkill(Skill newSkill){}

    // Elements Getter
    public ArrayList<String> getElements(){}
    public void setELements(ArrayList<String> newElements){}

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


//================= ABSTRACT METHOD ====================
    // Print
    public abstract void printDetail();
    // Sound
    public abstract String getSound();
}
    