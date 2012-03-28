package linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestDoubleLinkList {

    @Test
    public void testAddTraverse() {
        DoubleLinkList dll = new DoubleLinkList();
        dll.add(Element.c("t"));
        dll.add(Element.c("o"));
        dll.add(Element.c("a"));
        dll.add(Element.c("d"));

        List<String> elements = new ArrayList<String>();
        Element curr = dll.head;
        while (curr != null) {
            elements.add(curr.s);
            curr = curr.next;
        }
        Assert.assertEquals(elements.toArray(new String[elements.size()]), new String[] {"t", "o", "a", "d"});

        elements = new ArrayList<String>();
        curr = dll.tail;
        while (curr != null) {
            elements.add(curr.s);
            curr = curr.prev;
        }
        Assert.assertEquals(elements.toArray(new String[elements.size()]), new String[] {"d", "a", "o", "t"});
    }
}
