

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
                System.out.println(input.nextLine());

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
                System.out.println();
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
}

// Vector<Vector<String>> vector2D = new Vector<Vector<String>>(10);