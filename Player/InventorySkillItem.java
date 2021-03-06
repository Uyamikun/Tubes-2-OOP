package Player;
import Engimon.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

// Kalo ada tambahan method yang khusus untuk inventory skill item tambah disini

public class InventorySkillItem extends AbstractInventory<SkillItem> {
    public InventorySkillItem(){
        super();
    }

    public int getTotalSkillItem(){
        int tot = 0;
        for(SkillItem si: this.getObject()){
            tot += si.getJumlah();
        }
        return tot;
    }

    @Override
    public String printInventory(){
        StringBuilder str = new StringBuilder();
        if(this.object.size() > 0){
            str.append("Anda memiliki " + this.getNeff() + " jenis Skill Item, dengan total item sebanyak " + this.getTotalSkillItem() + " item\n");
            str.append("Berikut adalah list skill item yang anda miliki:\n");
            str.append("(No. NamaSkill / BasePower / Element / TotalItem)\n");
            int idx = 1;
            for(SkillItem si : this.getObject()){
                str.append(idx + ". " + si.printSkillItem());
                idx += 1;
            }
        } else{
            str.append("Inventory kosong :(\n");
        }
        return str.toString();
    }

    @Override
    public boolean insert(SkillItem obj){
        if(getTotal() < AbstractInventory.getMaxEl()){
            boolean done = false;
            boolean sama = false;
            int i = 0;
            while(i < this.neff && !sama){
                if(this.object.get(i).getSkillName().equals(obj.getSkillName())){
                    this.object.get(i).addJumlah(1);
                    this.object.set(i, this.object.get(i));
                    addTotal(1);
                    done = true;
                    sama = true;
                } else{
                    i++;
                }
            }
            if(!sama){
                obj.setJumlah(1);
                this.object.add(obj);
                this.neff += 1;
                addTotal(1);
                Collections.sort(this.object); // Sorting berdasarkan base power dari yang tertinggi ke yang terendah
                Collections.reverse(this.object);
                done = true;
            }
            return done;
        } else{
            return false;
        }
    }

    public boolean removeX(int idx, int x){
        if(idx-1 < this.neff){
            if(this.object.get(idx-1).getJumlah() - x > 0){
                this.object.get(idx-1).addJumlah(x * -1);
                this.object.set(idx-1, this.object.get(idx-1));
                addTotal(x * -1);
                return true;
            } else{
                int temp = this.object.get(idx-1).getJumlah();
                this.object.remove(idx-1);
                addTotal(temp * -1);
                this.neff -= 1;
                return true;
            }
        } else{
            return false;
        }
    }

    public boolean learnSkill(int idx, Engimon e){
        if(this.isIdxValid(idx)){
            if(this.object.get(idx-1).learn(e)){
                this.removeX(idx, 1);
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }

    public void save (String path) throws Exception{
        File directory = new File(path);
        directory.mkdirs();
        StringBuilder s = new StringBuilder();
        for (SkillItem sk : this.object){
            s.append(sk.printSkillItem());
            s.delete(s.length()-6, s.length()-1);
            //s.append("\n");
        }

        PrintWriter writer = new PrintWriter(path + "/Skills.txt", "UTF-8");
        writer.print(s);
        writer.close();
    }

    public void load(String path){
        try {
            Scanner input = new Scanner(new File(path + "/Skills.txt"));
            while (input.hasNextLine()) {
                String[] infos = input.nextLine().split(" / ");
                for (int i = 0; i < Integer.parseInt(infos[3]);i++){
                    String[] elements = infos[2].split("-");
                    ArrayList<String> el = new ArrayList<>();
                    Collections.addAll(el, elements);
                    this.insert(new SkillItem(new Skill(infos[0], Integer.parseInt(infos[1]), 1, el)));
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
