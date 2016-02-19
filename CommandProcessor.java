import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  Does the parsing of strings
 *
 *  @author pacog94 & silverg
 *  @version Feb 3, 2016
 */

public class CommandProcessor
{
    /**
     * the name
     */
    //Fields-------------------------------------------------------------
    String id; //name of rectangle
    /**
     * pos x
     */
    int x; //pos x
    /**
     * pos y
     */
    int y; //pos y
    /**
     * width
     */
    int w; //width
    /**
     * height
     */
    int h; //height


    // ----------------------------------------------------------
    /**
     * Create a new CommandProcessor object.
     * @param file the file being parsed
     * @throws FileNotFoundException if no file
     */
    @SuppressWarnings({ "resource"})

    /**
     *  the database that controls the methods
     */


    //Constructor----------------------------------------------------


    public CommandProcessor(File file) throws FileNotFoundException
    {
        Scanner scan = new Scanner(file);
        String n;
        String[] s = new String[10];
        //Database base = new Database(file);
        Database base = new Database();
        while (scan.hasNextLine())
        {
            n = scan.nextLine();
            s = n.trim().split("\\s+");
            if (s[0].equals("insert"))
            {
                id = s[1].trim();
                x = Integer.parseInt(s[2].trim());
                y = Integer.parseInt(s[3].trim());
                base.insert(id, x, y);
            }
            else if (s[0].equals("remove") && s.length == 2)
            {
                id = s[1].trim();
                base.remove(id);
            }

            else if (s[0] != null && s[0].equals("remove") && s.length == 3)
            {

                x = Integer.parseInt(s[1].trim());
                y = Integer.parseInt(s[2].trim());


                if (x < 0 || y < 0)
                {
                    System.out.println("Point rejected:"
                        + " (" + x + ", " + y + ")");
                }
                else if (x > 1024 || y > 1024)
                {
                    System.out.println("Point rejected:"
                        + " (" + x + ", " + y + ")");
                }
                else if ( w <= 0 || h <= 0)
                {
                    System.out.println("Point rejected:"
                        + " (" + x + ", " + y  + ")");
                }
                else
                {
                    base.remove(x, y);
                }
            }


            else if ( s[0].equals("regionsearch"))
            {
                x = Integer.parseInt(s[1].trim());
                y = Integer.parseInt(s[2].trim());
                w = Integer.parseInt(s[3].trim());
                h = Integer.parseInt(s[4].trim());
                base.regionSearch(x, y, w, h);
            }
            else if (s[0].equals("duplicates"))
            {
                base.duplicates();

            }
            else if (s[0].equals("search"))
            {
                id = s[1].trim();
                base.search(id);
            }
            else if (s[0].equals( "dump"))
            {
                base.dump();
            }
        }

    }

}
