import java.util.Scanner;
public class SkillItem extends Skill {
    private int jumlah;
        public SkillItem() {
            super("N/A", 0, 0, Arrays.asList());
            this.jumlah = 0;
        }
        public SkillItem(String nama, int basePower, int masteryLevel, List<String> elements) {
            super(nama, basePower, masteryLevel, elements);
            this.jumlah = 1;
        }

        /*
        SkillItem(const SkillItem& si){
            this.nama = si.getNama();
            this.basePower = si.getBasePower();
            this.masteryLevel = si.getMasteryLevel();
            for(string item : si.elements){
                this.elements.push_back(item);
            }
            this.jumlah = si.jumlah;
        }
        */

        void setJumlah(int jumlah){
            this.jumlah = jumlah;
        }

        void addJumlah(int jumlah){
            this.jumlah += jumlah;
        }

        int getJumlah(){
            return this.jumlah;
        }

        Boolean learn(Engimon e){
            // Cek skill item kompatibel gak sama engimonnya
            List<String> le = e.getElements();
            Boolean kompatibel = false;
            for(String ite : le){
                for(String itesi : this.elements){
                    if(ite.equals(itesi)){
                        kompatibel = true;
                    }
                }
            }
            if (!kompatibel){
                return false;
            }
            // Cek udah punya skillnya belum
            List<Skill> ls = e.getEngimonSkill();
            for(Skill it : ls){
                if(it.getNama() == this.getNama()){
                    return false;
                }
            }
            // Cek udah penuh atau belum
            if (ls.size() == 4){
                System.out.println("Skill engimon " + e.getName() + " sudah penuh, silahkan pilih skill yang akan diganti dengan skill " + this.getNama());
                int i = 1;
                for(Skill it : ls){
                    System.out.println(i + ". " + it.getNama());
                    i++;
                }
                int s;
                System.out.print("Pilih no skill yang akan diganti (1 sampai 4): ");
                Scanner S=new Scanner(System.in); 
                s=S.nextInt();
                System.out.println();
                int idx = 1;
                for(Skill it : ls){
                    if(idx == s){
                        it = this; 
                        it.setMasteryLevel(1); // mastery level di set ke 1
                        this.jumlah -= 1;
                    }
                    idx++;
                }
                e.setAllSkill(ls);
                return true;
            } else{
                this.setMasteryLevel(1); // set mastery level ke 1
                ls.push_back(this);
                this.jumlah -= 1;
                e.setAllSkill(ls);
                return true;
            }
        }
}
