package misc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * User: absharma
 * Date: 10/11/12
 */
public class PartitionPalindromes {
    public static void main(String[] args) {
        PartitionPalindromes obj = new PartitionPalindromes();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        obj.data = scanner.nextLine();
        int min = obj.generatePartitions();
        System.out.println(min);

    }

    private String data;

    private boolean validPartitions(String s) {
        int index = 0;
        boolean matches = true;
        for (int i = 0; i < s.length(); i++) {
            int size = Integer.parseInt("" + s.charAt(i));
            boolean status = isPalindrome(data, index, size);
//                System.out.println("status = " + status);
            index = index + size;
            if (!status) {
                matches = false;
                break;
            }
        }
        return matches;
    }

    private int generatePartitions() {
        List<Integer> nos = new ArrayList<Integer>();
        int n = data.length();
        for (int i = 0; i < n; i++) {
            nos.add(i + 1);
        }
        int[][] numMaxFreq = new int[nos.size()][2];
        for (int i = 0; i < nos.size(); i++) {
            int no = nos.get(i);
            int q = n / no;
            numMaxFreq[i][0] = no;
            numMaxFreq[i][1] = q;
        }

        Callback cb = new Callback() {
            private int data;

            public int getData() {
                return data;
            }

            @Override
            public void call(int cuts) {
//                System.out.println("cuts = " + cuts);
                data = cuts;
            }
        };
        c(numMaxFreq.length - 1, numMaxFreq, new Stack<Integer>(), cb, Arrays.asList(true));
        return cb.getData();
    }

    private interface Callback {
        int getData();
        void call(int cuts);
    }

    private int indent = 0;

    private void c(int row,
                   int[][] numMaxFreq,
                   Stack<Integer> stack,
                   PartitionPalindromes.Callback callback,
                   List<Boolean> boolHolder) {
        boolean goOn = boolHolder.get(0);
        indent += 4;
        if (row == -1)
            return;
        for (int j = numMaxFreq[row][1]; j >= 0; j--) {
//            System.out.println(spaces(indent) + numMaxFreq[row][0] + " * " + j);
            stack.push(j);
            if (stack.size() == numMaxFreq.length) { // a combination
                int value = value(stack);
                if (value == data.length()) { // a valid combination
                    Stack<Integer> copy = new Stack<Integer>();
                    copy.addAll(stack);
                    //ss
                    String out = pstack1(copy);
//                    System.out.println("out = " + out);
                    Set<String> permutations = permutations(out);
                    for (String sol : permutations) {
//                        System.out.println("----");
                        boolean matches = validPartitions(sol);
//                        System.out.println("----");
//                        System.out.println(sol + " : " + matches);
                        if (matches) {
//                            System.out.println(sol + " : " + matches);
                            if (callback != null) {
                                callback.call(sol.length() - 1);
                                boolHolder.set(0, false);
                            }
                            break;
                        }
                    }
                    //ss
                }
            }
            if (goOn)
                c(row - 1, numMaxFreq, stack, callback, boolHolder);
            if (!stack.empty())
                stack.pop();
            indent -= 4;
        }
    }

    private int value(Stack<Integer> stack) {
        int value = 0;
        int j = stack.size() - 1;
        for (int i : stack) {
            value = value + i * (j + 1);
            j--;
        }
        return value;
    }


    private String pstack1(Stack<Integer> stack) {
        int k = stack.size() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            for (int j = 0; j < i; j++) {
                sb.append(k + 1);
            }
            k--;
        }
        return sb.toString();
    }

    private void pstack(Stack<Integer> stack) {
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private Set<String> permutations(String s) {
        Set<String> out = new TreeSet<String>();
        _permutations("", s, out);
        return out;
    }

    private void _permutations(String prefix, String s, Set<String> set) {
        int N = s.length();
        if (N == 0) {
//            System.out.println("prefix = " + prefix);
            set.add(prefix);
        } else {
            for (int i = 0; i < N; i++)
                _permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N), set);
        }

    }

    private boolean isPalindrome(String s, int start, int size) {
//        System.out.println("s = " + s + " " + start + " " + size);
        s = s.substring(start, start + size);
//        System.out.println("s = " + s);
        int length = s.length();
        String reverse = "";
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + s.charAt(i);

        return s.equals(reverse);
    }

    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
