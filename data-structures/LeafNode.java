import java.util.LinkedList;

/**
 * 
 */

/**
 * This class takes up to three coordinates and stores it in this node
 * if there is more than three coordinates in the node, will turn
 * into an internal node
 * 
 * @author Eunjee
 *
 */
public class LeafNode implements BinNode {
    private PointLinkedList list;
    /**
     * constructor with empty leaf
     */
    public LeafNode(){
        list = new PointLinkedList();
    }
    /**
     * adds the coordinate to the array
     * @param coor inserted coordinate
     */
    public boolean add(Point coor){
        if(list.length() < 4){
        list.insert(coor);
        return true;
        }
        else {
            return false;
        }
    }
   

    /**
     * gets the current size of the BinNode array
     * @return length of array
     */
    public int getSize() {
        return size;
    }
    
    public boolean isLeaf(){
        return true;
    }
    
}
