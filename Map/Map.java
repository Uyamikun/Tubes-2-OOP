

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Map
{
    private ArrayList<ArrayList<Cell>> map_matrix;
    public Map(String file)
    {
        try {
            // read in the data
            this.map_matrix = new ArrayList<>();
            Scanner input = new Scanner(new File(file));
            int i = 0;
            while(input.hasNextLine())
            {

                ArrayList<Cell> col = new ArrayList<>();
                int j = 0;
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
                    j++;
                    it.next();
                }
                this.map_matrix.add(col);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ArrayList<Cell>> getMap(){
        return this.map_matrix;
    }

    public Cell getCell(int x, int y) {return this.map_matrix.get(x).get(y);}

    public void spawnEngimon(){
        Random rand = new Random();
        Cell c;
        do{
            int x = rand.nextInt(this.map_matrix.size());
            int y = rand.nextInt(this.map_matrix.get(0).size());
            c = this.getCell(x,y);
        }while (c.isBlocked());
        c.spawnEngimon();
        //set level engimon
        //c.getEngimon().setLevel();

    }
}

// Vector<Vector<String>> vector2D = new Vector<Vector<String>>(10);