
// -------------------------------------------------------------------------
/**
 *  Comparable class
 *
 *  @author Paco
 *  @version Feb 1, 2016
 * @param <K> The key
 * @param <E> The other object
 */

public class KVPair<K extends Comparable<K>, E>
               implements Comparable<KVPair<K, E>>
{
    //Fields----------------------------------------------------------
    /**
     * The object we want to compare
     */
    K theKey;
    /**
     * The other object were comparing to
     */
    E theVal;
    /**
     *
     */
    //Constructor----------------------------------------------------
    /**
     * an instance of the comparison
     * @param k is the key
     * @param v is the value
     */
    KVPair(K k, E v)
    {
        theKey = k;
        theVal = v;
    }

    // Compare KVPairs
    /**
     * compares the  the object to the objects key
     * @param it object being compared
     * @return an integer if its equal or less or greater
     */
    public int compareTo(KVPair<K, E> it)
    {
        return theKey.compareTo(it.key());
    }
    // ----------------------------------------------------------

    /**
     * Getter for the key value
     * @return the key
     */
    public K key()
    {
        return theKey;
    }
    /**
     * Getter for the value
     * @return the value
     */
    public E value()
    {
        return theVal;
    }
    /**
     * A concatenate tool to string key and value.
     * @return string of key and value
     */
    public String toString()
    {
        return theKey.toString() + ", " + theVal.toString();
    }

}
