package misc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * User: absharma
 * Date: 9/13/12
 */
public class QuadTreeImage {
    public static void main(String[] args) {
        QuadTreeImage image = new QuadTreeImage();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        String image1 = scanner.nextLine();
        String image2 = scanner.nextLine();
        int pixels = image.process(image1, image2);
        System.out.println("There are " + pixels + " black pixels.");
    }

    public int process(String image1, String image2) {
        Node node1 = createTree(image1);
//        System.out.println("node1 = " + score(node1));
        Node node2 = createTree(image2);
//        System.out.println("node2 = " + score(node2));
        Node out = union(node1, node2, null);
//        System.out.println("out = " + score(out));

        return score(out);
    }

    private Node union(Node node1, Node node2, Node result) {
        if (node1 instanceof Parent && node2 instanceof Parent) {
            if (result == null) {
                result = createNode('p');
            } else {
                Node n = createNode('p');
                result = n;
            }
            for (int j = 0; j < 4; j++) {
                Node c = union(node1.children.get(j), node2.children.get(j), result);
                result.children.add(c);
            }
        } else if (node1 instanceof Parent) {
            if(node2.label == 'f')
                result = node2;
            else
                result = node1;
        } else if (node2 instanceof Parent) {
            if(node1.label == 'f')
                result = node1;
            else
                result = node2;
        } else {
            if(node1.label == 'f') {
                result = node1;
            } else if(node2.label == 'f') {
                result = node2;
            } else {
                result = node1;
            }
        }
        return result;
    }

    private int score(Node node) {
        return _score(Arrays.asList(node), 0, 0);
    }

    private Node createTree(String image) {
        curIdx = 0;
        return processNode(image);
    }

    private int _score(List<Node> n, int level, int score) {
        if (n.size() == 0) {
            return score;
        }
        List<Node> next = new ArrayList<Node>();
        for (Node t : n) {
            if (t.label == 'f') {
                score = score + 1024 / (int) Math.pow(4, level);
//                System.out.println(level + ":" + score + " : " + level);
            }

            for (Node c : t.children) {
                next.add(c);
            }
        }
//        System.out.println();
        return _score(next, ++level, score);
    }

    private int curIdx = 0;

    private Node processNode(String image) {
        indent += 4;
//        System.out.println(spaces(indent) + "( " + image.charAt(curIdx) + " : " + curIdx);
        Node node = createNode(image.charAt(curIdx));
        if (node instanceof Parent) {
            for (int i = 0; i < 4; i++) {
                if (curIdx == image.length() - 1) {
                    return node;
                }
                curIdx++;
                Node child = processNode(image);
                node.children.add(child);
            }
        }
//        System.out.print(spaces(indent) + " )\n");
        indent -= 4;
        return node;
    }

    private Node createNode(char c) {
        switch (c) {
            case 'p':
                Parent parent = new Parent();
                parent.label = c;
                return parent;
            case 'f':
            case 'e':
                Pixel pixel = new Pixel();
                pixel.label = c;
                return pixel;
            default:
                throw new IllegalArgumentException("Illegal node " + c);
        }
    }

    private int indent = 0;

    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static abstract class Node {
        public char label;
        public List<Node> children = new ArrayList<Node>();
    }

    private class Parent extends Node {
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{").append(label);
            for (Node child : children) {
                sb.append("\n").append(child);
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private class Pixel extends Node {
        @Override
        public String toString() {
            return "{" + label + "}";
        }
    }

}
