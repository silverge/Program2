
public class Node {
private Node head;
private Node next;
private KVPair<String, Point> kvpair;

public Node() {
    head = null;
    next = null;
    kvpair = null;
}
public Node(KVPair<String, Point> point) {
    head = null;
    next = null;
    kvpair = point;
}
public KVPair<String, Point> getKVPair() {
    return kvpair;
}
public Node getNext() {
    return next;
}
}
