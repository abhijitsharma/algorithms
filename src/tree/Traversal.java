package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Traversal {
    private void inOrder(BinaryNode node, List<Integer> out) {
        if(node.l != null) {
            inOrder(node.l, out);
        }
        System.out.println(node.i);
        out.add(node.i);
        if(node.r != null) {
            inOrder(node.r, out);
        }
    }

    private void preOrder(BinaryNode node, List<Integer> out) {
        System.out.println(node.i);
        out.add(node.i);
        if(node.l != null) {
            preOrder(node.l, out);
        }
        if(node.r != null) {
            preOrder(node.r, out);
        }
    }

    private void postOrder(BinaryNode node, List<Integer> out) {
        if(node.l != null) {
            postOrder(node.l, out);
        }
        if(node.r != null) {
            postOrder(node.r, out);
        }
        System.out.println(node.i);
        out.add(node.i);
    }

    public static void main(String[] args) {
        /*
                    5
                3        7
            2    4    6   8
         */
        BinaryNode root = BinaryNode.
                                c(5).
                                    l(3).
                                        l(2).p.r(4).p.
                                p.
                                    r(7).
                                        l(6).p.r(8).p.
                                p;

        Traversal traversal = new Traversal();

        System.out.println("Pre Order");
        List<Integer> out = new ArrayList<Integer>();
        traversal.preOrder(root, out);

        System.out.println("In Order");
        out = new ArrayList<Integer>();
        traversal.inOrder(root, out);

        System.out.println("Post Order");
        out = new ArrayList<Integer>();
        traversal.postOrder(root, out);
    }

}
