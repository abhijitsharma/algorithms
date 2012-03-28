package linkedlist;

import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestDoubleLinkList {

    @Test
    public void testBuild() {
        DoubleLinkList dll = new DoubleLinkList();
        dll.add(Element.c("t"));
        dll.add(Element.c("o"));
        dll.add(Element.c("a"));
        dll.add(Element.c("d"));
        Element curr = dll.head;
        while (curr != null) {
            System.out.println("curr.s = " + curr.s);
            curr = curr.next;
        }

        curr = dll.tail;
        while (curr != null) {
            System.out.println("curr.s = " + curr.s);
            curr = curr.prev;
        }
    }
}
