package Player;
import java.util.*;

import Engimon.*;

// Method yang udah terimplementasi dan ditest: 
// a. Konstruktor
// b. display_list_engimon
// c. display_list_skill
// d. setActiveEngimon
// e. display_info_engimon
// f. switch_out_active_engimon
// g. removeXSkillItem
// h. removeEngimon
// i. interact
// j. renameEngimon
// k. use_skill
// l. getHelp
// m. chooseBreeding
// n. getFirstSkillEngimon
// 0. breeding

// Method yang harus diimplementasikan
// 1. Menampilkan list command yang tersedia (l)
// 2. Move
// 3. Menampilkan list engimon yang dimiliki (b)
// 4. Menampilkan data lengkap suatu engimon (e)
// 5. Mengecek dan mengganti active engimon (f)
// 6. Menampilkan list skill item (c)
// 7. Menggunakan skill item pada engimon (k)
// 8. Melaksanakan breeding antara 2 engimon (m)
// 9. Melakukan battle
// 10. Membuang X amount skill item (g)
// 11. Melepaskan engimon (h)
// 12. Mengganti nama suatu engimon (j)
// 13. Interaksi dengan active engimon (i)
// 14. Save game

// Method yang belum diimplementasi dan test
// 1. Move
// 2. Battle
// 3. save
// Sisanya sudah ditest :3

public class Player {
    private String nama;
    private Engimon active_engimon;               
    //private Point position;                       
    //private Point position_active_engimon;
    private InventoryEngimon engimon_as_object; 
    private InventorySkillItem skill_as_object;

    public Player() {
        this("Traveler");
    }
    public Player(String nama) {
        this.nama = nama;
        //this.position = new Point(5,5);
        //this.position_active_engimon = new Point(5,4);
        this.active_engimon = new Pikachu();
        this.active_engimon.setLevel(20);
        this.engimon_as_object = new InventoryEngimon();
        this.skill_as_object = new InventorySkillItem();
        // Di bawah ini untuk nyoba driver (uncomment dulu)
        ArrayList<String> al = new ArrayList<String>(){{
            add("Fire");
            add("Water");
        }};
        Skill S = new Skill("Searing chain", 31, 2, al);
        Skill Sk = new Skill("Fire gun", 30, 1, al);
        Skill Sp = new Skill("Earthshock", 32, 3, al);
        Skill So = new Skill("Tatap mata ojan", 100, 3, al);
        this.skill_as_object.insert(new SkillItem(S));
        this.skill_as_object.insert(new SkillItem(Sk));
        this.skill_as_object.insert(new SkillItem(Sp));
        this.skill_as_object.insert(new SkillItem(So));
        this.skill_as_object.insert(new SkillItem(So));
        this.skill_as_object.insert(new SkillItem(So));
        this.skill_as_object.insert(new SkillItem(So));
        Engimon e1 = new Amaura();
        Engimon e2 = new Blastoise();
        Engimon e3 = new Pikachu();
        Engimon e4 = new Earthshaker();
        e1.setLevel(35);
        e2.setLevel(35);
        e3.setLevel(35);
        e4.setLevel(35);
        this.engimon_as_object.insert(e1);
        this.engimon_as_object.insert(e2);
        this.engimon_as_object.insert(e3);
        this.engimon_as_object.insert(e4);
        Engimon e5 = new Earthshaker();
        e5.setLevel(39);
        this.engimon_as_object.insert(e5);
    }

    // public void switch_out_engimon_meninggal() {
    //     if(engimon_as_object.getNeff() != 0){
    //         System.out.println("Berikut adalah daftar engimon yang anda punya: ");
    //         display_list_engimon();
    //         System.out.print("Pilih engimon nomor berapa untuk menggantikan active engimon: ");
    //         int idx;
    //         Scanner S=new Scanner(System.in); 
    //         idx=S.nextInt();
    //         System.out.println("");
    //         if(engimon_as_object.engimonMeninggal(idx, active_engimon)){
    //             System.out.println("Berhasil menggantikan active engimon");
    //         } else{
    //             System.out.println("Gagal menggantikan active engimon");
    //         }
    //     } else{
    //         System.out.println("Anda tidak mempunyai engimon pada inventory");
    //     }
    // }
    
    public void setActiveEngimon(Engimon e) {
        this.active_engimon = e;
    }

    public void removeXSkillItem(){
        System.out.print(this.display_list_skill());
        System.out.print("Pilih skill item mana yang ingin dibuang: ");
        int idx;
        Scanner S = new Scanner(System.in); 
        idx = S.nextInt();
        System.out.print("Pilih berapa jumlah skill item yang akan dibuang: ");
        int x = S.nextInt();
        System.out.println("");
        if(this.skill_as_object.removeX(idx, x)){
            System.out.println("Berhasil membuang skill item :)"); // Jika x > jumlah skill item, skill item tersebut akan dihapus
        } else{
            System.out.println("Gagal membuang skill item :(");
        }
    }

    public void removeEngimon(){
        System.out.print(this.display_list_engimon());
        System.out.print("Pilih engimon mana yang ingin ditelantarkan: ");
        int idx;
        Scanner S = new Scanner(System.in); 
        idx = S.nextInt();
        System.out.println("");
        if(this.engimon_as_object.removeItem(idx)){
            System.out.println("Berhasil menelantarkan engimon :)"); // Jika x > jumlah skill item, skill item tersebut akan dihapus
        } else{
            System.out.println("Gagal menelantarkan engimon :(");
        }
    }

    public String interact(){
        String strret = "[" + this.active_engimon.getName() + "]: " + this.active_engimon.getSound();
        return strret;
    }

    public void renameEngimon(){
        System.out.print(this.display_list_engimon());
        System.out.print("Pilih engimon mana yang ingin diganti namanya: ");
        int idx;
        Scanner S = new Scanner(System.in); 
        idx = S.nextInt();
        S.nextLine();
        System.out.print("Masukkan nama baru: ");
        String nama = S.nextLine();
        System.out.println("");
        if(this.engimon_as_object.rename(idx, nama)){
            System.out.println("Berhasil mengganti nama engimon :)"); // Jika x > jumlah skill item, skill item tersebut akan dihapus
        } else{
            System.out.println("Gagal mengganti nama engimon :(");
        }
    }

    public String getHelp(){
        StringBuilder str = new StringBuilder();
        str.append("----HELP----\n");
        str.append("1. 'w, a, s, d' untuk bergerak.\n");
        str.append("2. 'battle' untuk melakukan battle dengan musuh terdekat.\n");
        str.append("3. 'listengimon' untuk menampilkan list engimon yang ada di inventory.\n");
        str.append("4. 'info' untuk menampilkan data lengkap dari suatu engimon.\n");
        str.append("5. 'switch' untuk mengecek dan mengganti active engimon.\n");
        str.append("6. 'listskill' untuk menampilkan list skill item yang ada di inventory.\n");
        str.append("7. 'useskill' untuk menggunakan skill item pada suatu engimon.\n");
        str.append("8. 'breed' untuk melakukan breeding antara 2 engimon.\n");
        str.append("9. 'removex' untuk membuang X amount skill item di inventory.\n");
        str.append("10. 'removee' untuk melepaskan engimon.\n");
        str.append("11. 'rename' untuk mengganti nama suatu engimon di inventory.\n");
        str.append("12. 'interact' untuk berinteraksi dengan active engimon.\n");
        str.append("13. 'save' untuk melakukan save game.\n");
        str.append("14. 'help' untuk menampilkan perintah apa saja yang tersedia.\n");
        return str.toString();
    }

    // public void move(Map map, char direction) {
    //     // Di map belum ada getter untuk posisi player dan active engimon
    //     Point P1 = new Point(0,1);
    //     Point P2 = new Point(1,0);
    //     Point P3 = new Point(0,-1);
    //     Point P4 = new Point(-1,0);
    //     try{
    //         if (direction == 'W' || direction == 'w')
    //         {
    //             map.movePlayer(Point.add(map.getPlayerPosition()+P3));
    //         }
    //         else if (direction == 'A' || direction == 'a')
    //         {
    //             map.movePlayer(Point.add(map.getPlayerPosition()+P4));
    //         }
    //         else if (direction == 'S' || direction == 's')
    //         {
    //             map.movePlayer(Point.add(map.getPlayerPosition()+P1));
    //         }
    //         else if (direction == 'D' || direction == 'd')
    //         {
    //             map.movePlayer(Point.add(map.getPlayerPosition()+P2));
    //         } else{
    //             System.out.println("Input direction tidak valid");
    //         }
    //     } catch(mapException m){};
    //     this.position = map.getPlayerPosition();
    //     this.position_active_engimon = map.getActiveEngimonPosition();
    //     //map.print();
    // }

    public Engimon getActive_engimon() {
        return active_engimon;
    }

    public void setActive_engimon(Engimon active_engimon) {
        this.active_engimon = active_engimon;
    }

    public InventoryEngimon getEngimon_as_object() {
        return engimon_as_object;
    }

    public InventorySkillItem getSkill_as_object() {
        return skill_as_object;
    }

    public String display_list_engimon() {
        return this.engimon_as_object.printInventory();
    }

    public void display_info_engimon() {
        int idx;
        System.out.print("Pilih engimon mana yang ingin anda lihat infonya: \n" + "1. Active Engimon\n" + "2. Engimon di inventory\n" + "Pilih (1/2): ");
        Scanner S = new Scanner(System.in); 
        idx = S.nextInt();
        System.out.println("");
        if(idx == 1){
            System.out.println(this.active_engimon.printDetail());
        } else{
            System.out.print(this.display_list_engimon());
            if(this.engimon_as_object.getNeff() > 0){
                System.out.print("Pilih engimon nomor berapa yang ingin anda lihat infonya: ");
                int idx1 = S.nextInt(); // Asumsi input valid
                System.out.println("");
                System.out.println(this.engimon_as_object.get(idx1).printDetail());
            }
        }
    }
    public String get_active_engimon() {
        return this.active_engimon.getName();
    }
    public void switch_out_active_engimon() {
        if(this.engimon_as_object.getNeff() != 0){
            System.out.print(this.display_list_engimon());
            System.out.print("Pilih engimon nomor berapa yang akan ditukar: ");
            int idx;
            Scanner S = new Scanner(System.in); 
            idx = S.nextInt();
            System.out.println("");
            // Menukar active engimon akan selalu berhasil jika idx valid
            if(this.engimon_as_object.isIdxValid(idx)){
                this.active_engimon = this.engimon_as_object.switchObj(idx, this.active_engimon);
                System.out.println("Berhasil menukar active engimon\n");
            } else{
                System.out.println("Gagal menukar active engimon\n");
            }
        } else{
            System.out.println("Anda tidak mempunyai engimon pada inventory, tidak dapat menukar active engimon :(");
        }
    }
    public String display_list_skill() {
        return this.skill_as_object.printInventory();
    }

    public void use_skill() {
        if(this.skill_as_object.getNeff() == 0){
            System.out.println("Anda tidak mempunyai skill item di inventory :(");
        } else{
            System.out.print(this.display_list_skill());
            System.out.print("Pilih nomor skill item yang ingin anda gunakan pada suatu engimon: ");
            int idxSI;
            Scanner S=new Scanner(System.in); 
            idxSI = S.nextInt();
            System.out.print("Pilih engimon mana yang ingin anda gunakan skill item: \n1. Active Engimon\n2. Engimon di inventory\nPilih nomor (1/2): ");
            int idxE;
            idxE = S.nextInt();
            System.out.println("");
            if(idxE == 1){
                Engimon temp = this.active_engimon;;
                if(this.skill_as_object.learnSkill(idxSI, temp)){
                    this.setActiveEngimon(temp);
                    System.out.println("Berhasil melakukan learn skill item ^_^");
                } else{
                    System.out.println("Gagal melakukan learn skill item :{ ");
                }
            } else if(idxE == 2){
                System.out.print(this.display_list_engimon());
                System.out.print("Pilih engimon nomor berapa yang ingin anda lakukan learn skill item: ");
                idxE = S.nextInt(); // Asumsi index valid
                System.out.println("");
                Engimon temp = this.engimon_as_object.get(idxE);
                if(this.skill_as_object.learnSkill(idxSI, temp)){
                    this.engimon_as_object.setObj(idxE, temp);
                    System.out.println("Berhasil melakukan learn skill item ^_^");
                } else{
                    System.out.println("Gagal melakukan learn skill item :{ ");
                }   
            }  
        }
    }

    public void breeding(Engimon e1, Engimon e2, int idx1, int idx2) {
        try
        {
            Engimon Child = Breeding.startBreeding(e1, e2);
            System.out.println("Selamat anda mendapatkan anak: ");
            System.out.println(Child.printDetail());
            System.out.print("Ingin memberi nama child?(Y/N): ");
            char choice;
            String name;
            Scanner S=new Scanner(System.in); 
            choice=S.next().charAt(0);
            S.nextLine();
            if(choice == 'Y')
            {
                System.out.print("Masukkan nama child: ");
                name = S.nextLine();
                Child.setName(name);
            }
            this.engimon_as_object.setObj(idx1, e1);
            this.engimon_as_object.setObj(idx2, e2);
            if(this.engimon_as_object.insert(Child)){
                System.out.println("Berhasil menyimpan anak engimon ke Inventory :)");
            } else{
                System.out.println("Maaf inventory anda penuh :(");
                System.out.print("Ingin menelantarkan engimon di Inventory? (Y/N): ");
                choice=S.next().charAt(0);
                S.nextLine();
                if(choice == 'Y'){
                    this.removeEngimon();
                    if(this.engimon_as_object.insert(Child)){
                        System.out.println("Berhasil menyimpan anak engimon ke Inventory :)");
                    }
                } else{
                    System.out.println("Menelantarkan anak engimon karena tidak diinginkan :(");
                }
            }
        }
        catch(BreedingInvalidException e){}
    }

    // Get First Skill from Engimon, buat dapetin skill item kalau menang battle
    public SkillItem getFirstSkillEngimon(Engimon e){
        ArrayList<Skill> ls = e.getEngimonSkill();
        return new SkillItem(ls.get(0));
    }

    // public SkillItem random_generator_skill(List<String> element) {
    //     ArrayList<SkillItem> list_of_skill = new ArrayList<SkillItem>();
    //     Skill tsunami_s = new Skill("Tsunami",120,1,Arrays.asList("Water"));
    //     Skill fireball_s = new Skill("FireBall",120,1,Arrays.asList("Fire"));
    //     Skill freezing_s = new Skill("Freezing field",120,1,Arrays.asList("Ice"));
    //     Skill fissure_s = new Skill("Fissure",120,1,Arrays.asList("Ground"));
    //     Skill thunder_s = new Skill("Thunder God",120,1,Arrays.asList("Electric"));
    //     Skill cold_s = new Skill("Cold Embrace",150,1,Arrays.asList("Water","Ice"));
    //     Skill watershock_s = new Skill("Watershock",150,1,Arrays.asList("Water","Ground"));
    //     Skill overload_s = new Skill("Overload",150,1,Arrays.asList("Fire","Electric"));
    //     SkillItem tsunami = new SkillItem(tsunami_s);
    //     SkillItem fireball = new SkillItem(fireball_s);
    //     SkillItem freezing = new SkillItem(freezing_s);
    //     SkillItem fissure = new SkillItem(fissure_s);
    //     SkillItem thunder = new SkillItem(thunder_s);
    //     SkillItem cold = new SkillItem(cold_s);
    //     SkillItem watershock = new SkillItem(watershock_s);
    //     SkillItem overload = new SkillItem(overload_s);
    //     list_of_skill.add(tsunami);
    //     list_of_skill.add(fireball);
    //     list_of_skill.add(freezing);
    //     list_of_skill.add(fissure);
    //     list_of_skill.add(thunder);
    //     list_of_skill.add(cold);
    //     list_of_skill.add(watershock);
    //     list_of_skill.add(overload);
    //     for (SkillItem it : list_of_skill)
    //     {
    //         if(it.getElements() == element)
    //         {
    //             return it;
    //         }
    //     }
    // }
    // public void battle(Map map, bool run) {
    //     Point P1 = new Point(0, 1);
    //     Point P2 = new Point(1, 0);
    //     Point P3 = new Point(0, -1);
    //     Point P4 = new Point(-1, 0);
    //     List<Point> LP = new List<Point>();
    //     LP.push_back(map.getPlayerPosition() + P1);
    //     LP.push_back(map.getPlayerPosition() + P2);
    //     LP.push_back(map.getPlayerPosition() + P3);
    //     LP.push_back(map.getPlayerPosition() + P4);
    //     List<Engimon> LE = new List<Engimon>();
    //     for(Point pi : LP){
    //         if(pi.get_x()>=0 && pi.get_y()>=0 && pi.get_x()<=map.getMatriksSizex()-1 && pi.get_y() <= map.getMatriksSizey()-1){
    //             if(!(pi == this.position_active_engimon)){
    //                 Engimon etemp = new Engimon();
    //                 etemp = map.GetCell(pi).getEngimon();
    //                 if (etemp != nullptr){
    //                     LE.push_back(etemp);
    //                 }
    //             }
    //         }
    //     }
        
    //     if(LE.size()>0){
    //         if(LE.size() > 1){
    //             System.out.println("Terdapat " + LE.size() + " engimon musuh disekitar");
    //             int i = 1;
    //             for(Engimon e:LE){
    //                 System.out.println("[" + i + "] " + e.getName());
    //                 e.printDetail();
    //                 i++;
    //             }
    //             System.out.print("Pilih engimon nomor berapa yang ingin dilawan: ");
    //             int idx;
    //             Scanner S=new Scanner(System.in); 
    //             idx=S.nextInt();// Asumsi input selalu valid
    //             i = 1;
    //             for(Engimon e:LE){
    //                 if(i == idx){
    //                     System.out.println("Anda akan melawan engimon " + e.getName());
    //                     e.printDetail();
    //                     Battle b = new Battle(this.active_engimon, e);
    //                     System.out.println("Power level player: " + b.calculatePowerPlayer());
    //                     System.out.println("Power level enemy: " + b.calculatePowerEnemy());
    //                     if(b.calculatePowerPlayer() >= b.calculatePowerEnemy()){
    //                         System.out.println("You win ^_^");
    //                         System.out.print("Apakah anda ingin memasukkan engimon musuh ke dalam inventory? (Y/N) ");
    //                         String c;
    //                         c = S.nextLine();
    //                         System.out.println();
    //                         if(c.equals("Y") || c.equals("y")){
    //                             if (this.getTotalInventory() < this.engimon_as_object.getMaxCapacity()){
    //                                 if(this.engimon_as_object.insert(e)){
    //                                     System.out.println("Berhasil menyimpan engimon " + e.getName() + " ke dalam inventory");
    //                                 } else{
    //                                     System.out.println("Gagal menyimpan engimon " + e.getName() + " ke dalam inventory");
    //                                 }
    //                             } else{
    //                                 System.out.println("Inventory penuh");
    //                             }
                                
    //                         } else{
    //                             System.out.println("Tidak menyimpan engimon ke inventory");
    //                         }
    //                         this.active_engimon.setCumExp(this.active_engimon.getCumExp() + 25);
    //                         if (this.active_engimon.getExp() + 25 >= 100){
    //                             this.active_engimon.setLevel(this.active_engimon.getLevel() + 1);
    //                             this.active_engimon.setExp((this.active_engimon.getExp() + 25)%100);
    //                         } else{
    //                             this.active_engimon.setExp(this.active_engimon.getExp() + 25); // add exp statis 25
    //                         }
    //                         map.removeEngimon(e);
    //                     } else{
    //                         System.out.println("You lose :(");
    //                         System.out.println("Engimon anda meninggal dunia");
    //                         if(this.engimon_as_object.getNeff() != 0){
    //                             this.switch_out_engimon_meninggal();
    //                         } else{
    //                             System.out.println( "Anda tidak punya engimon didalam inventory terpaksa anda kalah :(((");
    //                             run = false;
    //                         }
    //                     }
    //                     break;
    //                 } else{
    //                     i++;
    //                 }
    //             }
    //         } else{
    //             for(Engimon e:LE){
    //                     System.out.println("Anda akan melawan engimon " + e.getName());
    //                     e.printDetail();
    //                     Battle b = new Battle(this.active_engimon, e);
    //                     System.out.println("Power level player: " + b.calculatePowerPlayer());
    //                     System.out.println("Power level enemy: " + b.calculatePowerEnemy());
    //                     if(b.calculatePowerPlayer() >= b.calculatePowerEnemy()){
    //                         System.out.println("You win ^_^");
    //                         System.out.print("Apakah anda ingin memasukkan engimon musuh ke dalam inventory? (Y/N) ");
    //                         String c;
    //                         c = S.nextLine();
    //                         System.out.println();
    //                         if(c.equals("Y") || c.equals("y")){
    //                             if (this.getTotalInventory() < this.engimon_as_object.getMaxCapacity()){
    //                                 if(this.engimon_as_object.insert(e)){
    //                                     System.out.println("Berhasil menyimpan engimon " + e.getName() + " ke dalam inventory");
    //                                 } else{
    //                                     System.out.println("Gagal menyimpan engimon " + e.getName() + " ke dalam inventory");
    //                                 }
    //                             } else{
    //                                 System.out.println("Inventory penuh");
    //                             }
                                
    //                         } else{
    //                             System.out.println("Tidak menyimpan engimon ke inventory");
    //                         }
    //                         this.active_engimon.setCumExp(this.active_engimon.getCumExp() + 25);
    //                         if (this.active_engimon.getExp() + 25 >= 100){
    //                             this.active_engimon.setLevel(this.active_engimon.getLevel() + 1);
    //                             this.active_engimon.setExp((this.active_engimon.getExp() + 25)%100);
    //                         } else{
    //                             this.active_engimon.setExp(this.active_engimon.getExp() + 25); // add exp statis 25
    //                         }
    //                         map.removeEngimon(e);
    //                     } else{
    //                         System.out.println("You lose :(");
    //                         System.out.println("Engimon anda meninggal dunia");
    //                         if(this.engimon_as_object.getNeff() != 0){
    //                             this.switch_out_engimon_meninggal();
    //                         } else{
    //                             System.out.println( "Anda tidak punya engimon didalam inventory terpaksa anda kalah :(((");
    //                             run = false;
    //                         }
    //                 }
    //             }
    //         }
    //     } else{
    //         System.out.println("Battle tidak dapat dilakukan karena tidak ada engimon musuh di dekat anda");
    //     }
    // }

    // public void insertSkillItem(SkillItem si) {
    //     if (this.getTotalInventory() < this.engimon_as_object.getMaxEl()){
    //         this.skill_as_object.insert(si);
    //     } else{
    //         System.out.println("Inventory anda penuh");
    //     }
    // }
    
    //tambahan untuk breeding
    public void chooseBreeding() {
        Engimon e1;
        Engimon e2;
        if(this.engimon_as_object.getNeff() >= 2)
        {
            System.out.println(this.display_list_engimon());
            System.out.print("Pilih engimon 1 untuk melakukan breeding: ");
            int idx1, idx2;
            Scanner S=new Scanner(System.in); 
            idx1 = S.nextInt();
            System.out.print("Pilih engimon 2 untuk melakukan breeding: ");
            idx2 = S.nextInt();
            System.out.println("");
            if(idx1 != idx2 && idx1 >= 1 && idx1 <= this.engimon_as_object.getNeff() && idx2 >= 1 && idx2 <= this.engimon_as_object.getNeff())
            {
                e1 = this.engimon_as_object.get(idx1);
                e2 = this.engimon_as_object.get(idx2);
                this.breeding(e1,e2,idx1,idx2);
            } 
            else
            {
               System.out.println("Nomor engimon yang anda masukkan tidak valid :("); 
            }
        }
        else
        {
            System.out.println("Anda tidak mempunyai cukup engimon di Inventory :(");
        }
    
    }
}