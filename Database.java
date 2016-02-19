import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  Holds all the Rectangle methods
 *
 *  @author pacog94 & silverg
 *  @version Feb 1, 2016
 */

@SuppressWarnings("unused")
public class Database
{
    //Fields--------------------------------------------------
    /**
     * SkipList
     */
    SkipList<String, Coordinate> list = new SkipList<String, Coordinate>();

    // ----------------------------------------------------------
    /**
     * Create a new Rectangle object.
     */

    //public Database(File file) throws FileNotFoundException
    public Database()
    {
        //Nothing
    }


    /**
     * Creates a rectangle with origin x, y and dimensions w, l labeled by name.
     * Each rectangle can have the same name or dimensions
     * @param name name is the name of the rectangle
     * @param posx origin pos x
     * @param posy origin pos y
     * @param wsize width
     * @param hsize height
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void insert(String name, int posx, int posy)
    {
        if (posx < 0 || posy < 0 || posx  > 1024 || posy > 1024)
        {
            System.out.println("Point rejected: (" + name + ", " + posx +
                ", " + posy + ")");
            return;
        }
        else if (!(Character.isLetter(name.charAt(0))))
        {
            System.out.println("Point rejected: (" + name + ", " + posx +
                ", " + posy + ")");
            return;
        }
        else
        {
            list.insert(new KVPair(name, new Coordinate(posx, posy)));
            System.out.println("Point inserted: (" + name + ", " +
                posx + ", " + posy + ")");
        }
    }


    // ----------------------------------------------------------
    /**
     * Removes the rectangle with this name, if multiple have the same name
     * one of them gets deleted.
     * @param name the rectangle deleted
     */
    public void remove(String name)
    {
        if (!(Character.isLetter(name.charAt(0))))
        {
            System.out.println("Point not removed: (" + name + ")");
        }
        else
        {
            list.remove(name);
        }
    }
    /**
     * Removes the rectangle by the position x, y, w, h,i multiple have the same
     * position one of them gets deleted
     * @param x origin coord x
     * @param y origin coord y
     */
    public void remove(int x, int y)
    {
        list.remove(x, y);
    }
    /**
     * region search
     * @param x origin coord x
     * @param y origin coord y
     * @param w  width
     * @param h  height
     */
    public void regionSearch(int x, int y, int w, int h)
    {
        Rectangle rec = new Rectangle(x, y, w, h);
        if (x <= 0 || y <= 0)
        {
            System.out.println("Point rejected (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
        else
        {
            System.out.println("Points intersecting region (" + x + ", " + y +
                ", " + w + ", " + h + ")");
            list.regionSearch(rec);
        }

    }
    /**
     * region search for intersections

     */
    public void duplicates()
    {

        System.out.println("duplicate points:");
        list.duplicates();
    }
    /**
     * region search for intersections
     * @param name the name
     *
     */
    public void search(String name)
    {
        list.search(name);
    }
    /**
     * region search for intersections
     */
    public void dump()
    {
        list.dump();

    }







}
