/**
 * 
 */

/**
 * @author Eunjee
 *
 */
public class InternalNode implements BinNode {

    private BinNode NW;
    private BinNode NE;
    private BinNode SW;
    private BinNode SE;
    private BinNode flyweight;

    public InternalNode() {
        flyweight = null;
        NW = flyweight;
        NE = flyweight;
        SW = flyweight;
        SE = flyweight;

    }

    public boolean isLeaf() {
        return false;
    }

    public void setNW(BinNode node) {
        NW = node;
    }

    public void setNE(BinNode node) {
        NE = node;
    }

    public void setSW(BinNode node) {
        SW = node;
    }

    public void setSE(BinNode node) {
        SE = node;
    }

    public BinNode getNW() {
        return NW;
    }

    public BinNode getNE() {
        return NE;
    }

    public BinNode getSW() {
        return SW;
    }

    public BinNode getSE() {
        return SE;
    }
    public boolean add(Point coor) {
        return false;
    }
    public void insert(Point coor, int depth) {
        int sum = 1024;
        for(int i =0; i<depth; i++) {
            sum /= 2;
        }
        //and some other stuff maybe...
    }
    
}
