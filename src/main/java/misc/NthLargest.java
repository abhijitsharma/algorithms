package misc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * User: absharma
 * Date: 5/18/12
 */
public class NthLargest {

    private TreeSet<Integer> allDigits = new TreeSet<Integer>();
    private int start = -1;
    private int n = -1;

    public String getNth(String s, int n) {
        this.n = n;
        start = Integer.parseInt(s);
        int digits = s.length();
        for (int i = 0; i < digits; i++) {
            int j = Integer.parseInt("" + s.charAt(i));
            allDigits.add(j);
        }

        Integer out = process();
        return out == null ? "NONE" : out.toString();
    }

    private int indent = 0;

    private Integer process() {
        List<Integer> result = new ArrayList<Integer>();
        _process(-1, new int[]{-1}, new HashSet<Integer>(), new Stack<Integer>(), result);
        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

    private void _process(
            int currDigit,
            int[] counterHolder,
            Set<Integer> digitsUsed,
            Stack<Integer> stack,
            List<Integer> result) {

        indent += 4;
//        System.out.println(spaces(indent) + "_p " + currDigit);
        if (currDigit != -1) {
            digitsUsed.add(currDigit);
            stack.push(currDigit);
        }

        if (stack.size() == allDigits.size()) { // found a solution
            int r = Integer.parseInt(stackToString(stack));
//            System.out.println(r);
            int counter = counterHolder[0];
            if (r == start) {
                counter = 0;
            }
            if (counter >= 0) {
                if (counter == n) { // result found
//                    System.out.println("r = " + r);
                    result.add(r);
                }
                counter++;
            }
            if (counter != counterHolder[0]) {
                counterHolder[0] = counter;
            }
        }

        if (result.size() == 0) // recurse further only if solution not found
            for (Integer j : allDigits) {
                if (!digitsUsed.contains(j)) {
                    _process(j, counterHolder, digitsUsed, stack, result);
                }
            }
        digitsUsed.remove(currDigit);
        if (!stack.empty())
            stack.pop();
        indent -= 4;
    }

    /*
    123
    132
    213
    231
    312
    321
     */

    private String stackToString(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (Integer j : stack) {
            sb.append(j);
        }
        return sb.toString();
    }

    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NthLargest nthLargest = new NthLargest();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        String firstLine = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String out = nthLargest.getNth(firstLine, n);
        System.out.println(out);
    }
}