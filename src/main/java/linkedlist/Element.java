package linkedlist;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Element {
    public Element next;
    public Element prev;
    public String s;

    public static Element c(String s) {
        Element e = new Element();
        e.s = s;
        return e;
    }
}
