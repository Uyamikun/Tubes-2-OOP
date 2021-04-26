package Map;
import Engimon.*;
import Battle.Battle;
import Player.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Map
{
    private ArrayList<ArrayList<Cell>> map_matrix;
    private Point PlayerPos;
    private  Point ActivePos;
    private  int EngimonCount = 0;
    private  int turnCounter = 0;
    private  final int movementTurn = 5;
    private final Point[] direction = {new Point(0,1), new Point(1,0), new Point(0,-1), new Point(-1, 0)};
    private static int maxEngimon = 10;
    private int minSpawnLevel = 1;
    private static final Random rand = new Random();
    private Player player;

    public Map(String file)
    {
        try {
            // read in the data
            this.map_matrix = new ArrayList<>();
            Scanner input = new Scanner(new File(file));
            int j = 0;
            while(input.hasNextLine())
            {

                ArrayList<Cell> col = new ArrayList<>();
                int i = 0;
                CharacterIterator it = new StringCharacterIterator(input.nextLine());
                while(it.current() != CharacterIterator.DONE)
                {
                    switch (it.current()) {
                        case 'M': 
                            col.add(new MountainsCell(i, j));
                            break;
                        case 'G': 
                            col.add(new GrasslandCell(i, j));
                            break;
                        case 'S': 
                            col.add(new SeaCell(i, j));
                            break;
                        case 'T': 
                            col.add(new TundraCell(i, j));
                            break;
                        default:
                    }
                    i++;
                    it.next();
                }
                this.map_matrix.add(col);
                j++;
            }
            this.PlayerPos = new Point(5,5);
            this.ActivePos = new Point(4,5);
            this.getCell(PlayerPos).setPlayer(true);
            this.getCell(ActivePos).setActive(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ArrayList<Cell>> getMap(){
        return this.map_matrix;
    }

    public Cell getCell(int x, int y) {
        return this.map_matrix.get(y).get(x);
    }

    public Cell getCell(Point p){
        return  getCell(p.get_x(), p.get_y());
    }

    public Cell getCell(Engimon e) {
        for (ArrayList<Cell> ac : this.map_matrix){
            for (Cell c : ac){
                if (c.getEngimon() == e){
                    return c;
                }
            }
        }
        return null;
    }

    public void spawnEngimon(){
        int x = rand.nextInt(this.map_matrix.size());
        int y = rand.nextInt(this.map_matrix.get(0).size());
        while (this.getCell(x,y).isBlocked()){
            x = rand.nextInt(this.map_matrix.size());
            y = rand.nextInt(this.map_matrix.get(0).size());
        }
        Cell c = this.getCell(x,y);
        c.spawnEngimon();
        //set level engimon
        int bound = (int) (minSpawnLevel*1.5);
        int level = rand.nextInt(bound);
        c.getEngimon().setLevel(minSpawnLevel + level);
        c.getEngimon().setLife(1);
        //debug
        System.out.println("Spawned: " + c.getEngimon().getSpecies());
        EngimonCount++;
    }

    public static void setMaxEngimon(int x){
        maxEngimon = x;
    }

    public void setMinSpawnLevel(int x){
        minSpawnLevel = x;
    }

    public int getMinSpawnLevel(){
        return minSpawnLevel;}

    public void removeEngimon(Engimon e){
        Cell C = this.getCell(e);
        C.removeEngimon();
        EngimonCount--;
    }

    public Point getPlayerPos(){
        return PlayerPos;
    }

    public Point getActivePos() {
        return ActivePos;
    }

    public void movePlayer(Point dest) throws Exception{
        Cell c = this.getCell(dest);
        if(!c.isBlocked() || c.isActive()){
            this.getCell(PlayerPos).setPlayer(false);
            c.setPlayer(true);
            moveEngimon(this.getCell(this.getActivePos()), this.getPlayerPos());
            this.getCell(ActivePos).setActive(false);
            this.ActivePos = this.PlayerPos;
            this.getCell(ActivePos).setActive(true);
            this.PlayerPos = dest;
            this.nextTurn();
        }else{
            throw new Exception("Cannot move, there is Engimon");
        }
    }

    public void moveEngimon(Cell c, Point dest){
        Cell c1 = this.getCell(dest);
        if (!c1.isBlocked() && !c1.active && (c1.canMove(c.getEngimon())) || c.isActive()){
            c1.addEngimon(c.getEngimon());
            c.removeEngimon();
        }
    }

    public ArrayList<Cell> getWildCells(){
        ArrayList<Cell> arr = new ArrayList<>();
        for (ArrayList<Cell> ac : this.map_matrix){
            for (Cell c : ac){
                if (c.getEngimon() != null && !c.isActive()){
                    arr.add(c);
                }
            }
        }
        return arr;
    }

    public void moveWildEngimons(ArrayList<Cell> wildCells){
        for (Cell c : wildCells){
            Point p = this.direction[rand.nextInt(4)];
            Point p1 = Point.add(c.getPosisi(), p);
            if (checkBound(p1) && !this.getCell(p1).isBlocked() && !this.getCell(p1).isActive())
            this.moveEngimon(c, p1);
        }
    }

    public boolean checkBound(Point P){
        return P.get_y()>= 0 && P.get_y()<this.map_matrix.size() && P.get_x() >= 0 && P.get_x() < this.map_matrix.get(0).size();
    }
    public void levelUpEngimons(ArrayList<Cell> wildCells){
        if (wildCells != null){
            for (Cell c : wildCells){
                c.getEngimon().changeExp(100);
            }
        }
    }

    public void nextTurn(){
        if (turnCounter == 0){
            ArrayList<Cell> wildCells = this.getWildCells();
            if (wildCells.size()>0) {
                levelUpEngimons(wildCells);
                moveWildEngimons(wildCells);
            }
            if (EngimonCount < maxEngimon){
                this.spawnEngimon();
            }
            turnCounter = movementTurn;
        }else{
            turnCounter--;
        }
    }

    public ArrayList<Engimon> getNearbyEngimon(){
        ArrayList<Engimon> engimons = new ArrayList<>();
        for (Point p : this.direction){
            Point p1 = Point.add(p, this.getPlayerPos());
            if (checkBound(p1)){
                Cell c = getCell(p1);
                if (c.engimon != null && !c.active){
                    engimons.add(c.getEngimon());
                }
            }
        }
        return engimons;
    }

    public void paint(Graphics g){
        for (ArrayList<Cell> ac :this.map_matrix){
            for (Cell c : ac){
                c.paint(g);
                if (c.getEngimon() != null){
                    if (isStronger(c.getEngimon())) {
                        c.paintLevel(g);
                    }
                }
            }
        }
    }

    public void setActiveEngimon(Engimon e){
        this.getCell(this.getActivePos()).addEngimon(e);
    }

    //Set Player
    public void setPlayer(Player player) {
        this.player = player;
        setActiveEngimon(player.getActive_engimon());
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isStronger(Engimon e){
        Engimon active = this.getCell(ActivePos).getEngimon();
        if (active != null) {
            Battle b = new Battle(active, e);
            return b.calculatePowerEnemy() > b.calculatePowerPlayer();
        }else{
            return false;
        }
    }

    public void save(String path) throws Exception{
        File directory = new File(path);
        directory.mkdirs();
        StringBuilder s = new StringBuilder();
        s.append(PlayerPos.get_x());
        s.append(" ");
        s.append(PlayerPos.get_y());
        s.append("\n");
        s.append(ActivePos.get_x());
        s.append(" ");
        s.append(ActivePos.get_y());
        s.append("\n");

        ArrayList<Cell> wildCells = this.getWildCells();
        for (Cell c : wildCells){
            s.append(c.getEngimon().getSpecies());
            s.append(" ");
            s.append(c.getEngimon().getLevel());
            s.append(" ");
            s.append(c.getPosisi().get_x());
            s.append(" ");
            s.append(c.posisi.get_y());
            s.append("\n");
        }

        PrintWriter writer = new PrintWriter(path + "/mapStatus.txt", "UTF-8");
        writer.print(s);
        writer.close();

    }

    public void load(String path){
        try {
            this.setActiveEngimon(null);
            this.getCell(PlayerPos).setPlayer(false);
            this.getCell(ActivePos).setActive(false);
            Scanner input = new Scanner(new File(path + "/mapStatus.txt"));
            String[] Player = input.nextLine().split(" ");
            this.PlayerPos = new Point(Integer.parseInt(Player[0]), Integer.parseInt(Player[1]));
            String[] Active = input.nextLine().split(" ");
            this.ActivePos = new Point(Integer.parseInt(Active[0]), Integer.parseInt(Active[1]));
            this.getCell(PlayerPos).setPlayer(true);
            this.getCell(ActivePos).setActive(true);
            this.setActiveEngimon(player.getActive_engimon());
            while (input.hasNextLine()){
                Engimon eg;
                String[] engimon = input.nextLine().split(" ");
                switch (engimon[0]) {
                    case "Blastoise" :
                        eg = new Blastoise();
                        break;
                    case "Cyndaquil" :
                        eg = new Cyndaquil();
                        break;
                    case "Amaura" :
                        eg = new Amaura();
                        break;
                    case "Earthshaker" :
                        eg = new Earthshaker();
                        break;
                    case "Pikachu" :
                        eg = new Pikachu();
                        break;
                    case "Wynter" :
                        eg = new Wynter();
                        break;
                    case "KataraToph" :
                        eg = new KataraToph();
                        break;
                    case "Hu_Tao" :
                        eg = new Hu_Tao();
                        break;
                    default :
                        eg = null;
                        break;
                }
                if (eg != null){
                    eg.setLevel(Integer.parseInt(engimon[1]));
                    this.getCell(Integer.parseInt(engimon[2]), Integer.parseInt(engimon[3])).addEngimon(eg);
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void initiateBattle(){
        ArrayList<Engimon> engimons= this.getNearbyEngimon();
        //Pilih engimon yang mau dilawan

        //Tampilin status engimon

        //Pi
    }








}

