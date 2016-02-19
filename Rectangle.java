
// -------------------------------------------------------------------------
/**
 *  Rectangle properties
 *
 *  @author Paco
 *  @version Feb 3, 2016
 */

public class Rectangle
{
    //Field-------------------------------------------------------------
    private int x;
    private int y;
    private int w;
    private int h;

    // ----------------------------------------------------------
    /**
     * Create a new Rectangle object.
     * @param xp xpos
     * @param yp ypos
     * @param wp width
     * @param hp height
     */
    public Rectangle(int xp, int yp, int wp, int hp)
    {
        x = xp;
        y = yp;
        w = wp;
        h = hp;
    }

    //Methods-----------------------------------------------------------
   /**
    * Get x value of rect
    * @return x value
    */
    public int getX()
    {
        return x;
    }
    /**
     * Get y value of rect
     * @return y value
     */
    public int getY()
    {
        return y;
    }
    /**
     * Get width
     * @return w width
     */
    public int getW()
    {
        return w;
    }
    /**
     * Get height
     * @return h height
     */
    public int getH()
    {
        return h;
    }
    /**
     * concatenates strings together.
     * @return toString
     */
    public String toString()
    {
        return x + ", " + y + ", " + w + ", " + h;
    }

}
