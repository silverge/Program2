
public class BinNode {
private Coordinate coordinate;
private BinNode next;

public BinNode(Coordinate coor, BinNode next){
    coordinate = coor;
    this.next = next;
}

public BinNode(Coordinate coor){
    coordinate = coor;
            next = null;
}

public BinNode getNext() {
    return next;
}
public Coordinate getCoord() {
    return coordinate;
}
}
