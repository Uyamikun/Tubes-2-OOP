package Player;
import java.util.*;

// CATATAN: - Fungsi switchObj masih ada bug, si obj yang diinput ga ubah, elemen di arraylist objectnya udah keubah
//          - Fungsi lainnya sepertinya udah bisa
//          - Kalo mau nyoba inventory penuh ubah aja atribut maxEl nya
//          - Kelas abstrak ini nanti punya turunan Inventory Engimon dan Inventory SkillItem, nanti yang diinstansiasi itu InventoryEngimon sama InventorySkillItem

abstract class AbstractInventory<T> {
    protected ArrayList<T> object;
    protected int neff;
    protected static final int maxEl = 100;
    protected static int total = 0;

    public AbstractInventory(){
        this.object = new ArrayList<>();
        this.neff = 0;
    }

    public ArrayList<T> getObject(){
        return this.object;
    }

    public int getNeff(){
        return this.neff;
    }

    public static int getMaxEl(){
        return maxEl;
    }

    public static int getTotal(){
        return total;
    }

    public static void addTotal(int i){
        total += i;
    }

    public static void decTotal(int i){
        total -= i;
    }

    public T get(int idx){
        return this.object.get(idx-1); // asumsi index valid
    }

    public boolean switchObj(int idx, T obj){
        if(idx-1 < this.neff){
            T temp = obj;
            obj = this.object.get(idx-1);
            this.object.set(idx-1, temp);
            return true;
        } else{
            return false;
        }
    }

    public boolean setObj(int idx, T obj){
        if(idx-1 < this.neff){
            this.object.set(idx-1, obj);
            return true;
        } else{
            return false;
        }
    }

    abstract String printInventory();

    abstract boolean insert(T obj);
}
