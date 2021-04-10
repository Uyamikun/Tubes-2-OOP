import java.util.*;
import java.io.*;

public class Map
{
    private ArrayList<ArrayList<String>> map_matrix;
    public Map()
    {
        try {
            // read in the data
            this.map_matrix = new ArrayList<ArrayList<String>>();
            Scanner input = new Scanner(new File("map_matrix.txt"));
            while(input.hasNextLine())
            {
                Scanner colReader = new Scanner(input.nextLine());
                ArrayList<String> col = new ArrayList<String>();
                while(colReader.hasNext())
                {
                    col.add(colReader.next());
                }
                this.map_matrix.add(col);
            }
            // for (ArrayList<String> arg: this.map_matrix)
            // {
            //     for(String arg2:arg)
            //     {
            //         System.out.printf("%s",arg2);
            //     }
            //     System.out.printf("\n");
            // }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ArrayList<String>> getMap(){
        return this.map_matrix;
    }
}

// Vector<Vector<String>> vector2D = new Vector<Vector<String>>(10);