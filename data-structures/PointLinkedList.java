/**
 * 
 */

/**
 * @author Eunjee
 *
 */
public class PointLinkedList {
    private Node head;
    private Node tail;
    private Node curr;
    private int listSize;

    public PointLinkedList() {
        head = null;
        tail = null;
        curr = null;
        listSize = 0;
    }

    public void clear() {
        curr = tail = null; // Create trailer
        head = null; // Create header
        listSize = 0;
    }

    public boolean insert(Object it) {
        curr.setNext(new Node(curr.getData(), curr.next()));
        curr.setData(it);
        if (tail == curr)
            tail = curr.next(); // New tail
        listSize++;
        return true;
    }

    public boolean append(Object it) {
        tail.setNext(new Node(null));
        tail.setData(it);
        tail = tail.next();
        listSize++;
        return true;
    }

    public Object remove() {
        if (curr == tail)
            return null; // Nothing to remove
        Object it = curr.getData(); // Remember value
        curr.setData(curr.next().getData()); // Pull forward the next element
        if (curr.next() == tail)
            tail = curr; // Removed last, move tail
        curr.setNext(curr.next().next()); // Point around unneeded link
        listSize--; // Decrement element count
        return it; // Return value
    }

    public void moveToStart() {
        curr = head.next();
    } // Set curr at list start

    public void moveToEnd() {
        curr = tail;
    } // Set curr at list end

    public void prev() {
        if (head.next() == curr)
            return; // No previous element
        Node temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr)
            temp = temp.next();
        curr = temp;
    }

    public void next() {
        if (curr != tail)
            curr = curr.next();
    }

    public int length() {
        return listSize;
    } // Return list length

    public int currPos() {
        Node temp = head.next();
        int i;
        for (i = 0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize))
            return false;
        curr = head.next();
        for (int i = 0; i < pos; i++)
            curr = curr.next();
        return true;
    }

    public boolean isAtEnd() {
        return curr == tail;
    }

    public Object getValue() {
        return curr.getData();
    }
}

class Node {
    Node next;
    Object data;

    public Node(Object _data) {
        next = null;
        data = _data;
    }

    public Node(Object object, Node _next) {
        next = _next;
        data = object;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object it) {
        data = it;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node _next) {
        next = _next;
    }
}
