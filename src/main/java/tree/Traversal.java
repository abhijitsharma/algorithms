package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Traversal {
    public void inOrder(BinaryNode node, List<Integer> out) {
        if(node.l != null) {
            inOrder(node.l, out);
        }
        System.out.println(node.i);
        out.add(node.i);
        if(node.r != null) {
            inOrder(node.r, out);
        }
    }

    public void preOrder(BinaryNode node, List<Integer> out) {
        System.out.println(node.i);
        out.add(node.i);
        if(node.l != null) {
            preOrder(node.l, out);
        }
        if(node.r != null) {
            preOrder(node.r, out);
        }
    }

    public void postOrder(BinaryNode node, List<Integer> out) {
        if(node.l != null) {
            postOrder(node.l, out);
        }
        if(node.r != null) {
            postOrder(node.r, out);
        }
        System.out.println(node.i);
        out.add(node.i);
    }


}
