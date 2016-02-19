
// -------------------------------------------------------------------------
/**
 *  Coordinate class stores x and y coords
 *
 *  @author pacog94 & silverg
 *  @version Feb 18, 2016
 */

public class Coordinate
{

    private int x;
    private int y;

    /**
     * The constructor for the coord class
     * @param xcord the x cord
     * @param ycord the ycord
     */
    public Coordinate(int xcord, int ycord)
    {
        x = xcord;
        y = ycord;
    }

    /**
     * get the x coord
     * @return the xcord
     */
    public int getX()
    {
        return x;
    }
    /**
     * get the y coord
     * @return the ycord
     */
    public int getY()
    {
        return y;
    }
    /**
     * returns a string of characters
     * @return the string
     */
    public String toString()
    {
        return x + ", " + y;
    }

}
