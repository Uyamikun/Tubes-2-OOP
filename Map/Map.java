import java.util.*;
import java.io.*;

public class Map
{
    public static void main(String[] args) {
        try {
            // read in the data
            ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
            Scanner input = new Scanner(new File("map.txt"));
            while(input.hasNextLine())
            {
                Scanner colReader = new Scanner(input.nextLine());
                ArrayList<String> col = new ArrayList<String>();
                while(colReader.hasNext())
                {
                    col.add(colReader.next());
                }
                map.add(col);
            }
            for (ArrayList<String> arg: map)
            {
                for(String arg2:arg)
                {
                    System.out.printf("%s",arg2);
                }
                System.out.printf("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Map()
    {
       
    }
}

// Vector<Vector<String>> vector2D = new Vector<Vector<String>>(10);