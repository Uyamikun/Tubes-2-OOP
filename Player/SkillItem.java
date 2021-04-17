package Player;
import Engimon.*;
import java.util.*;

// CATATAN: - Nanti implement comparablenya di skill item aja, soalnya yang perlu disorting nanti yang skill item
//          - Implementasi learn nanti bisa disesuaikan lagi + ditest

public class SkillItem extends Skill implements Comparable<SkillItem>{
    private int jumlah;

    public SkillItem(Skill skill){
        super(skill);
        this.jumlah = 1;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public void addJumlah(int jumlah){
        this.jumlah += jumlah;
    }

    public int getJumlah(){
        return this.jumlah;
    }

    public String printSkillItem(){
        StringBuilder str = new StringBuilder();
        str.append(this.skillName + " / " + this.basePower + " / ");
        for(String s : this.elements){
            str.append(s);
            if(s != this.elements.get(this.elements.size()-1)){
                str.append("-");
            }
        }
        str.append(" / " + this.jumlah + " item\n");
        return str.toString();
    }

    // Compare for sorting berdasarkan basePower, descendant
    public int compareTo(SkillItem other) {
        return Integer.compare(getBasePower(), other.getBasePower());
    }

    // public bool learn(Engimon e)
    // public boolean learn(Engimon e){
    //     // Cek skill item kompatibel gak sama engimonnya
    //     ArrayList<String> le = new ArrayList<>();
    //     le = e.getElements();
    //     Boolean kompatibel = false;
    //     for(String ite : le){
    //         for(String itesi : this.elements){
    //             if(ite.equals(itesi)){
    //                 kompatibel = true;
    //             }
    //         }
    //     }
    //     if (!kompatibel){
    //         return false;
    //     }
    //     // Cek udah punya skillnya belum
    //     ArrayList<Skill> ls = new ArrayList<>();
    //     ls = e.getEngimonSkill();
    //     for(Skill it : ls){
    //         if(it.getNama() == this.getNama()){
    //             return false;
    //         }
    //     }
    //     // Cek udah penuh atau belum
    //     if (ls.size() == 4){
    //         System.out.println("Skill engimon " + e.getName() + " sudah penuh, silahkan pilih skill yang akan diganti dengan skill " + this.getNama());
    //         int i = 1;
    //         for(Skill it : ls){
    //             System.out.println(i + ". " + it.getNama());
    //             i++;
    //         }
    //         int s;
    //         System.out.print("Pilih no skill yang akan diganti (1 sampai 4): ");
    //         Scanner S=new Scanner(System.in); 
    //         s=S.nextInt();
    //         System.out.println();
    //         int idx = 1;
    //         for(Skill it : ls){
    //             if(idx == s){
    //                 it = this; 
    //                 it.setMasteryLevel(1); // mastery level di set ke 1
    //                 this.jumlah -= 1;
    //             }
    //             idx++;
    //         }
    //         e.setAllSkill(ls);
    //         return true;
    //     } else{
    //         this.setMasteryLevel(1); // set mastery level ke 1
    //         ls.push_back(this);
    //         this.jumlah -= 1;
    //         e.setAllSkill(ls);
    //         return true;
    //     }
    // }
}
