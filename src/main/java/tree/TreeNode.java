package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class TreeNode {
    public final List<TreeNode> children = new ArrayList<TreeNode>();
    public String s;
    public int x = -1;
    public int y = -1;

    public static TreeNode create(String s) {
        TreeNode n = new TreeNode();
        n.s = s;
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(TreeNode n : children) {
            sb.append(n).append(',');
        }
        return s + (children.size() == 0 ? "" :  "(" + sb.toString() + ")") ;
    }
}
