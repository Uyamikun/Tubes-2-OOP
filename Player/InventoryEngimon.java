package Player;
import Engimon.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

// Kalo ada tambahan method untuk khusus inventory engimon tambah disini

public class InventoryEngimon extends AbstractInventory<Engimon> {
    public InventoryEngimon(){
        super();
    }
    
    @Override
    public String printInventory(){
        StringBuilder str = new StringBuilder();
        if(this.object.size() > 0){
            str.append("Anda memiliki " + this.getNeff() + " Engimon di dalam inventory\n");
            str.append("Berikut adalah list engimon yang ada di dalam inventory anda:\n");
            str.append("(No. NamaEngimon / NamaSpesies / ElemenEngimon / LevelEngimon)\n");
            int idx = 1;
            for(Engimon e : this.getObject()){
                str.append(idx + ". " + e.getName() + " / " + e.getSpecies() + " / ");
                for(String s : e.getElements()){
                    str.append(s);
                    if(s != e.getElements().get(e.getElements().size()-1)){
                        str.append("-");
                    }
                }
                str.append(" / Lv." + e.getLevel() + "\n");
                idx += 1;
            }
        } else{
            str.append("Inventory kosong :(\n");
        }
        return str.toString();
    }

    @Override
    public boolean insert(Engimon obj){
        if(getTotal() < getMaxEl()){
            this.object.add(obj);
            this.neff += 1;
            addTotal(1);
            Collections.sort(this.object); // Grouping berdasarkan element dan sorting berdasarkan level dari yang tertinggi ke yang terendah
            return true;
        } else{
            return false;
        }
    }

    public boolean rename(int idx, String name) {
        if(this.isIdxValid(idx)){
            this.object.get(idx-1).setName(name);
            return true;
        } else{
            return false;
        }
    }

    public Engimon engimonMeninggal(int idx) {
        if(idx-1 < this.neff){
            Engimon tempret = this.object.get(idx-1);
            this.object.remove(idx-1);
            return tempret;
        } else{
            return null;
        }
    }

    public boolean switchEngimon(int idx, Engimon e) {
        for(int i = 0; i < this.getNeff(); i++){
            if(i == idx-1){
                Engimon temp = e;
                e = this.object.get(i);
                this.object.set(i,temp);
                return true;
            }
        }
        return false;
    }

    public void setEngimon(int idx, Engimon e) {
        if(idx <= this.neff){
            this.object.set(idx-1,e);
        }
    }

    public boolean stored(Engimon obj) {//mengembalikan true jika object ada di inventory
        int i;
        for(i=0;i<neff;i++)
        {
            if(object.get(i).getID() == obj.getID())
            {
                return true;
            } 
        }
        return false;
    }

    public int getMaxLevel(){
        int max = 1;
        for (Engimon e : object){
            if (e.getLevel() > max){
                max = e.getLevel();
            }
        }
        return max;
    }

    public void save (String path) throws Exception{
        File directory = new File(path);
        directory.mkdirs();
        StringBuilder s = new StringBuilder();
        for (Engimon e : this.object){
            s.append(e.getSpecies() + "\n");
            s.append(e.getName());
            s.append(";");
            s.append(e.getLife());
            s.append(";");
            s.append(e.getLevel());
            s.append(";");
            s.append(e.getExp());
            s.append(";");
            s.append(e.getCumExp());
            s.append(";");
            s.append(e.getParentInfo().get(0));
            s.append(";");
            s.append(e.getParentInfo().get(1));
            s.append(";");
            s.append(e.getParentInfo().get(2));
            s.append(";");
            s.append(e.getParentInfo().get(3));
            s.append(";");
            for (Skill sk : e.getEngimonSkill()){
                s.append(sk.printSkillDetail());
                s.deleteCharAt(s.length()-1);
            }
            s.append("\n");
        }

        PrintWriter writer = new PrintWriter(path + "/Engimons.txt", "UTF-8");
        writer.print(s);
        writer.close();
    }

    public void load(String path){
        try{
            Scanner input = new Scanner(new File(path + "/Engimons.txt"));
            while (input.hasNextLine()) {
                Engimon e = Engimon.makeEngimon(input.nextLine());
                String[] infos = input.nextLine().split(";");
                e.setName(infos[0]);
                e.setLife(Integer.parseInt(infos[1]));
                e.setLevel(Integer.parseInt(infos[2]));
                e.setExp(Integer.parseInt(infos[3]));
                e.setCumExp(Integer.parseInt(infos[4]));
                ArrayList<String> parent = new ArrayList<>();
                for (int i = 5; i <= 8; i++) {
                    parent.add(infos[i]);
                }
                e.setParentInfo(parent);
                for (int i = 9; i < infos.length; i++) {
                    String[] skill = infos[i].split(" / ");
                    String[] elements = infos[3].replaceAll("/", "").split(" ");
                    for (String s : skill){
                        System.out.println(s);
                    }
                    ArrayList<String> el = new ArrayList<>();
                    Collections.addAll(el, elements);
                    e.setEngimonSkill(new Skill(skill[0], Integer.parseInt(skill[1]), Integer.parseInt(skill[2]), el));
                }
                this.insert(e);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
