package linkedlist;

/**
 * User: absharma
 * Date: 3/1/12
 */
public class DoubleLinkList {
    public Element head;
    public Element tail;
    public Element curr;

    public void add(Element e) {
        if(head == null) {
            head = e;
            tail = e;
            curr = head;
        } else {
            insertAfter(curr, e);
            curr = curr.next;
            tail = curr;
        }
    }

    private void insertAfter(Element e, Element n) {
        n.next = e.next;
        n.prev = e;
        if(e.next != null)
            e.next.prev = n;
        e.next = n;
    }

}