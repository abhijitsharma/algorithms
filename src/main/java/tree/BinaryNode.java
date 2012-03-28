package tree;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class BinaryNode {
    public int i = -1;
    public BinaryNode l;
    public BinaryNode r;
    public BinaryNode p;

    public static BinaryNode c(int i) {
        BinaryNode n = new BinaryNode();
        n.i = i;
        return n;
    }

    public BinaryNode l(int v) {
        l = c(v);
        l.p = this;
        return l;
    }

    public BinaryNode r(int v) {
        r = c(v);
        r.p = this;
        return r;
    }
}
