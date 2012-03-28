package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestTraversal {

    @Test

    public void testTraversal() {
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
