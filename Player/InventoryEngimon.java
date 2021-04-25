package Player;
import Engimon.*;
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

    public boolean engimonMeninggal(int idx, Engimon e) {
        for(int i = 0; i < this.getNeff(); i++){
            if(i == idx-1){
                Engimon temp = e;
                e = this.object.get(i);
                this.object.set(i,temp);
                for(int j = i; j < this.getNeff()-1; j++){
                    this.object.set(i,this.object.get(i+1));
                }
                this.neff--;
                decTotal(1);
                return true;
            }
        }
        return false;
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

}
