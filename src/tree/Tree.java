package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Tree {
    private TreeNode translate(String s) {
        TreeNode result = null;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(':
                    sb = push(stack, sb);
                    stack.push("(");
                    break;
                case ')':
                    sb = push(stack, sb);
                    List<TreeNode> nodes = new ArrayList<TreeNode>();
                    String i;
                    while (!((i = stack.pop()).equals("("))) {
                        TreeNode child = null;
                        if(!nodeStack.empty() && nodeStack.peek().s.equals(i)) {
                            child = nodeStack.pop();
                        } else {
                            child = TreeNode.create(i);
                        }
                        nodes.add(child);
                    }

                    if (!stack.empty()) {
                        String parent = stack.peek();
                        TreeNode p = TreeNode.create(parent);
                        nodeStack.push(p);
                        for (int j = nodes.size() - 1; j >= 0; j--) {
                            TreeNode node = nodes.get(j);
                            p.children.add(node);
                        }
                        result = p;
                    }
                    break;
                case ',':
                    sb = push(stack, sb);
                    break;
                default:
                    if (!Character.isWhitespace(c))
                        sb.append(c);
            }
        }
        return result;
    }

    private static StringBuilder push(Stack<String> stack, StringBuilder sb) {
        if (sb.length() > 0) {
            String item = sb.toString();
            stack.push(item);
            sb = new StringBuilder();
        }
        return sb;
    }

    public void printTree(TreeNode root, int width) {
        if(root == null) {
            return;
        }
        root.x = width / 2;
        root.y = 0;
        _createTree(root, width);
        System.out.println("\n" + repeat('-',width));
        printTree(root);
        System.out.println("\n" + repeat('-',width));
    }


    public void _createTree(TreeNode p, int width) {
        int num = p.children.size();
        if (num == 0) {
            return;
        }

        int start = p.x - width / 2;
        boolean even= num % 2 == 0;
        int numparts = even ? num + 2 : num + 1;
        int partition = width / numparts;
        int j = 0;
        for (int i = 1; i < numparts; i++) {
            if(even && i == numparts/2) {
                continue;
            }
            TreeNode t = p.children.get(j++);
            t.x = start + partition * i;
            t.y = p.y + 1;
            System.out.print(t.s + "(" + t.x + "," + t.y + ")");
        }

        for (int i = 0; i < num; i++) {
            TreeNode t = p.children.get(i);
            _createTree(t, width/num);
        }
    }

    public void printTree(TreeNode n) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(n);
        int px = 0;
        int py = 0;
        while (!queue.isEmpty()) {
            TreeNode c = queue.remove();
            int sp = 0;
            if (c.y == py) {
                sp = c.x - px;
//                System.out.println(c.y + ":" + px + ":" + c.x + ":" + sp);
            } else {
                System.out.println();
                sp = c.x;
                py = c.y;
            }
            px = c.x;
//            System.out.print(repeat(' ', (sp - c.s.length()/2)) + c.s);
            System.out.print(repeat(' ', (sp - 1)) + c.s);
            for (TreeNode x : c.children) {
                queue.add(x);
            }
        }
    }

    private String repeat(char c, int n) {
//        System.out.println("n = " + n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String seq(int n) {
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for (int i = 0; i < n; i++) {
            sb.append(j++);
            if(j == 10)
                j = 0;
        }
        return sb.toString();
    }

    public void _levelOrder(List<TreeNode> n) {
        if (n.size() == 0) {
            return;
        }
        List<TreeNode> next = new ArrayList<TreeNode>();
        for (TreeNode t : n) {
            System.out.print(t.s + " ");
            for (TreeNode c : t.children) {
                next.add(c);
            }
        }
        System.out.println();
        _levelOrder(next);
    }

    public void bf(TreeNode n) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(n);
        while (!queue.isEmpty()) {
            TreeNode c = queue.remove();
            System.out.println(c.s);
            for (TreeNode x : c.children) {
                queue.add(x);
            }
        }
    }

    public static void main(String[] args) {
        test("(a(b(d,e),c(f,g)))", 100);
        test("(a(b,c,d,e))", 100);
        test("(a(b,c(f,g,j,k),x(r,t,y,u),d(h,i,l,m),e))", 100);
        test("(a(b(d(h,i,j,k,l,m,n),e(t,r)),c(f,g)))", 300);
        test("(a(b(d(h,i,j,k,l,m,n),1(2,3,4,5),e(t,r)),c(f,g)))", 300);
        test("(a(b(d,e),x(1,2,3,4),c(f,g,h,i,j)))", 200);
        test("(a(b(d,e),x(1,2,3,4,5),c(f,g,h,i,j)))", 200);
        test("(a(b(d,e),x(1,2,3,4,5,6,7),c(f,g,h,i,j)))", 200);
        test("(a(b(d,e),x(1,2,3,4,5(z,l,u,y,t),6,7),c(f,g,h,i,j)))", 400);
        test("(a(b,c,d))", 100);
        test("(a(b(d,e),c(f,g,h)))", 100);
        test("(a(b(d,e),c(f,g,h,i,j)))", 100);

        test("(a(b(d,e),x(1,2),c(f,g)))", 100);
        test("(a(b(d,e,f),c(f,g)))", 100);
        test("(a(b(d,e,f),c(g,h,i),d(j,k,l)))", 150);
        testAll(150);
    }

    private static void testAll(int width) {
        test("(a(b(d,e),c(f,g)))", width);
        test("(a(b(d,e,x),c(f,g,y)))", width);
        test("(a)", width);
        test("()", width);
        test("(1(2(4 (8,9), 5 (10,11)), 3(6,7)))", width);
        test("(1(2(4(6(8(10)))),3(5(7(9(11))))))", width);
    }

    private static void test(String s, int width) {
        Tree tree = new Tree();
        TreeNode root = tree.translate(s);
        System.out.println("root = " + root);
        tree.printTree(root, width);
    }
}