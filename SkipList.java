
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import student.testingsupport.SystemIOUtilities;
// -------------------------------------------------------------------------
/**
 *  The Data Structure used to organize the rectangles
 *
 *  @author Paco
 *  @version Feb 1, 2016
 * @param <K> The key
 * @param <E> the value
 */
//Make this a private data member of the SkipList object

@SuppressWarnings("unused")
public class SkipList<K extends Comparable<K>, E>
{

    //Skip List Field------------------------------------------------------
    /**
     * random number generator
     */
    private Random rnd;
    /**
     * the head variable
     */
    private SkipNode<K, E> head;
    /**
     * the level of the node (height)
     */
    private int level;
    /**
     * Skip node head
     */
    private int size;

    //Skip List Constructor------------------------------------------------

    /**
     * instance of skiplist
     */
    public SkipList()
    {
        head = new SkipNode<K, E>(null, 0);
        rnd = new student.TestableRandom();
        level = 0;
        size = 0;
    }




    //Skip List Method-------------------------------------------------------
    //Setter/Getters------------------------
    /**
     * (DONE)
     * Random level
     * @return lev the level
     */
    int randomLevel()
    {
        int lev;
        int na = 0;
        for (lev = 0; rnd.nextInt(2) == 0; lev++)
            na++; //Do nothing
        return lev;
    }

    /**
     * adjust the level and head
     * @newLevel new highest level
     */
    private void adjustHead(int newLevel)
    {
        SkipNode<K, E> oldhead = head;
        head = new SkipNode<K, E>(null, newLevel);
        for (int i = level; i >= 0; i--)
        {
            head.forward[i] = oldhead.forward[i];
        }
        for (int i = level + 1; i <= newLevel; i++)
        {
            head.forward[i] = null;
        }
        this.level = newLevel;

    }

    /**
     * set Random number
     */

    /**
     * get the length of the array node
     * @return level of the array node
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * get size of the list
     * @return size of the list
     */
    public int getSize()
    {
        return size;
    }

    //---------------------------------------------------------------------
    /**
     * Insert a KVPair into the skip list
     * @param it the item being added
     * @return returns if the insert was successful or not.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean insert(KVPair<K, E> it)
    {

        int newLevel = randomLevel();
        Comparable<K> k = it.key();
        if ( level < newLevel)
        {
            adjustHead(newLevel);
        }
        //Generic array allocation
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipList.
            SkipNode.class, level + 1);
        SkipNode x = head; //Start at header node
        for (int i = level; i >= 0; i--)
        {
            //Find insert position
            while ((x.forward[i] != null) && (k.compareTo((K)(x.forward[i]).

                element().key()) > 0))
            {
                x = x.forward[i];
            }
            update[i] = x;
            //Track end at level i
        }

        x = new SkipNode(it, newLevel);
        for (int i = newLevel; i >= 0; i--)
        {
            //Splice into list
            x.forward[i] = update[i].forward[i]; //Who x points to
            update[i].forward[i] = x; //Who y points to
        }
        size++;         //Increment dictionary size
        return true;
    }


    /**
     * For testing purposes, insert that has a fixed newLevel
     * @param it object
     * @param newLevel the new level being inserted
     * @return true if inserted
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean insertLevel(KVPair<K, E> it, int newLevel)
    {

        Comparable<K> k = it.key();
        adjustHead(newLevel);
        //Generic array allocation
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipList.
            SkipNode.class, level + 1);
        SkipNode x = head; //Start at header node
        for (int i = level; i >= 0; i--)
        {
            //Find insert position
            while ((x.forward[i] != null) && (k.compareTo((K)(x.forward[i]).

                element().key()) > 0))
            {
                x = x.forward[i];
            }
            update[i] = x;
            //Track end at level i
        }

        x = new SkipNode(it, newLevel);
        for (int i = newLevel; i >= 0; i--)
        {
            //Splice into list
            x.forward[i] = update[i].forward[i]; //Who x points to
            update[i].forward[i] = x; //Who y points to
        }
        System.out.println("Rectangle inserted: (" + it.toString() + ")");
        size++;         //Increment dictionary size
        return true;
    }


    //Return the (first) matching element if one exists, null otherwise
    // ----------------------------------------------------------
    /**
     * search for a kv pair with this name
     * @param key the object name
     *
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void search(Comparable<K> key)
    {
        boolean found = false;
        SkipNode x = head; //Dummy header node
        for (int i = level; i >= 0; i--)  // For each level...
        {
            while ((x.forward[i] != null) && (key.compareTo((K)x.forward[i].
                element().key()) > 0))
            {
                x = x.forward[i];  //Move to actual record, if it exists
            }
        }
        x = x.forward[0];
        while ((x != null) && (key.compareTo((K)
            x.element().key()) == 0 ))
        {
            System.out.println("(" + x.element().key() +
                ", " + x.element().value().toString());
            x = x.forward[0];
            found = true;
        }

        if (found != true)
        {
            System.out.println("Rectangle not found: " + key);
        }

    }



    /**
     *  Returns all nodes values and their pointers
     */
    @SuppressWarnings("rawtypes")
    public void dump()
    {
        SkipNode x = head;
        int depth = level + 1;
        System.out.println("SkipList dump: ");
        System.out.println("Node has depth " + (depth) +
            ", Value (null)");
        while (x.forward[0] != null)//Traverses through the size of SkipList
        {
            depth = x.level() + 1;
            System.out.println("Node has depth " + (x.forward[0].level() + 1) +
                ", Value (" + x.forward[0].element().key() + ", " +
                x.forward[0].element().value().toString() + ")");
            x = x.forward[0];
        }

        System.out.println("SkipList size is: " + size);

    }

    /**
     * Region search
     * @param rec rectangle as the scope
     */

    @SuppressWarnings("rawtypes")
    public void regionSearch(Rectangle rec)
    {
        int x = rec.getX();
        int y = rec.getY();
        int w = rec.getW();
        int h = rec.getH();
        int boundW = x + w;
        int boundH = y + h;
        SkipNode he = null;
        for (he = head.forward[0]; he != null; he = he.forward[0])
        {
            if (he.element() != null)
            {
                int curx = ((Rectangle) he.element().value()).getX();
                int cury = ((Rectangle) he.element().value()).getY();
                int curw = ((Rectangle) he.element().value()).getW();
                int curh = ((Rectangle) he.element().value()).getH();
                if (curx < boundW && ((curx + curw) > x) && cury < boundH
                    && (cury + curh) > y)
                {
                    System.out.println(he.element().toString());
                }
            }
        }
    }
    /**
     * Intersection of two or more rectangles
     */
    @SuppressWarnings({ "rawtypes" })
    public void duplicates()
    {
        SkipNode hd = null; //rectangles being compared
        SkipNode hd2 = null; //rectangle being checked


        if (head.forward[0] == null)
        {
            return;
        }
        for (hd = head.forward[0]; hd != null; hd = hd.forward[0])
        {
            //Boundaries of first Rectangle
            int x = ((Rectangle) hd.element().value()).getX();
            int y = ((Rectangle) hd.element().value()).getY();
            int w = ((Rectangle) hd.element().value()).getW();
            int h = ((Rectangle) hd.element().value()).getH();
            int boundW = x + w;
            int boundH = y + h;
            for (hd2 = head.forward[0]; hd2 != null;
                hd2 = hd2.forward[0])
            {
                if (hd2 != hd)
                {

                    //Boundaries of second Rectangle
                    int nextx = ((Rectangle) hd2.element().value()).getX();
                    int nexty = ((Rectangle) hd2.element().value()).getY();
                    int nextw = ((Rectangle) hd2.element().value()).getW();
                    int nexth = ((Rectangle) hd2.element().value()).getH();
                    //Compare conditions for pairs
                    if (nextx < boundW && ((nextx + nextw) > x) &&
                        nexty < boundH && (nexty + nexth) > y)
                    {
                        System.out.println("(" + hd.element().toString()
                            + " | " +
                            hd2.element().toString() + ")");
                    }
                }
            }
        }

    }


    /**
     *  Deletes nodes, if duplicates delete all
     *  @param key name being deleted
     *  @return if deleted
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean remove(Comparable<K> key)
    {
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipList.
            SkipNode.class, level + 1);
        SkipNode x = head;
        for (int i = level; i >= 0; i--)
        {
            while ((x.forward[i] != null) && (key.compareTo((K)
                x.forward[i].element().key()) > 0 ))
            {
                x = x.forward[i];
            }
            update[i] = x;
        }
        x = x.forward[0];
        if (x != null && (key.compareTo((K)x.element().key()) == 0))
        {
            System.out.println("Rectangle removed (" + x.element().toString()
                + ")");
            for (int j = level; j >= 0; j--)
            {
                if (update[j].forward[j] == x)
                {
                    update[j].forward[j] = x.forward[j]; //update is predecessor
                }
            }
            size--;
            return true;
        }
        else
        {
            System.out.println("Rectangle not removed (" + key + ")");
            return false;
        }

    }

    /**
     *  Deletes nodes, if duplicates delete all
     *  @param x x coord
     *  @param y y coord
     *  @return if deleted
     */
    @SuppressWarnings({ "rawtypes" })
    public boolean remove(int x, int y)
    {
        String s = (x + ", " + y);
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipList.
            SkipNode.class, level + 1);
        SkipNode cur = null;
        for (cur = head.forward[0]; cur != null; cur = cur.forward[0])
        {
            if (!(s.equals(cur.element().value().toString())))
            {
                for (int i = cur.level(); i >= 0; i--)
                {
                    update[i] = cur;
                }
            }
            else
            {
                break; //found an equal object
            }
        }
        if (update[0] == null)
        {

            System.out.println("Rectangle not removed (" + x + ", " + y + ")");
            return false;
        }
        cur = update[0].forward[0];
        if (cur != null && s.equals(cur.element().value().toString()))
        {
            System.out.println("Rectangle removed (" + cur.element()
                .toString() + ")");
            for (int j = level; j >= 0; j--)
            {
                if (update[j] != null)
                {
                    if (update[j].forward[j] == cur)
                    {
                        update[j].forward[j] = cur.forward[j];
                        //update is predecessor
                    }
                }
            }
            size--;
            return true;
        }
        else
        {
            System.out.println("Rectangle not removed (" + x + ", " + y + ")");
            return false;
        }

    }




    //Skip Node Class-----------------------------------------------------
    @SuppressWarnings("hiding")
    private class SkipNode<K extends Comparable<K>, E>
    {


        //Skip Node Field--------------------------------------------
        /**
         * the value of the node
         */
        private KVPair<K, E> t;
        /**
         * the array of skipNodes
         */
        private SkipNode<K, E> [] forward;



        //Skip Node Constructor-----------------------------------------------
        /**
         * Creates a SkipNode constructor
         * @param it  the value of the node
         * @param level current level skip node
         */

        @SuppressWarnings("unchecked")
        public SkipNode(KVPair<K, E> it,  int level)
        {
            forward = (SkipNode<K, E>[])Array.newInstance(SkipNode.class,
                level + 1);
            for (int i = 0; i < level; i++)
            {
                forward[i] = null;
            }
            t = it;

        }

        //Skip Node Methods--------------------------------------------------
        /**
         * gets the value of the node
         * @return element the value of the node
         */
        private KVPair<K, E> element()
        {
            return t;
        }
        /**
         * gets the level of the skipNode
         */
        private int level()
        {
            return forward.length - 1;
        }

    }

}




