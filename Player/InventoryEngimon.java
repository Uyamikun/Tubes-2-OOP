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
            for(Engimon e : this.getObject()){
                str.append(e.getName() + " / ");
                for(String s : e.getElements()){
                    str.append(s);
                    if(s != e.getElements().get(e.getElements().size()-1)){
                        str.append("-");
                    }
                }
                str.append(" / Lv." + e.getLevel() + "\n");
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
            return true;
        } else{
            return false;
        }
    }
}
