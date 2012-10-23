package misc;

import expr.Expression;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class EquationSolverBackTrack implements EqSolver {
    private static final List<String> operators = Arrays.asList("+", "-", "*");

    public List<String> solve(final List<String> objects, final Integer rhs) {
        Set<List<String>> results = new HashSet<List<String>>();
        for (String operation : operators) {
            _solve(operation, objects, new Stack<String>(), results);
        }
//        System.out.println(results);
        Expression e = new Expression();
        for(List<String> result : results) {
            if(rhs == e.evaluate(e.infixToPostFix(result))) {
                List<String> out = new ArrayList<String>();
                for(int i = 0; i < result.size(); i++) {
                    if(i % 2 != 0) {
                        out.add(result.get(i));
                    }
                }
                return out;
            }
        }
        return null;
    }

    private int indent = 0;

    private int _solve(String op,
                        List<String> numbers,
                        Stack<String> stack,
                        Set<List<String>> results) {
        int cnt = 0;
        indent += 4;
        if (numbers.size() == 0) {
            return cnt;
        }
        String first = numbers.get(0);
        stack.push(first);
        cnt++;
        List<String> rest = new ArrayList<String>();
        for (int i = 1; i < numbers.size(); i++) {
            rest.add(numbers.get(i));
        }
//        System.out.print(spaces(indent) + first);
        if (op != null) {
            stack.push(op);
//            System.out.print(" " + op);
            cnt++;
        }
        if (rest.size() == 1) {
            String e = rest.get(0);
//            System.out.print(" " + e);
            stack.push(e);
            results.add(new ArrayList<String>(stack));
            cnt++;
        }
//        System.out.println();
        for (String operation : operators) {
            if (rest.size() > 1) {
                int n = _solve(operation, rest, stack, results);
                while(--n >= 0) {
                    stack.pop();
                }
            }
        }
        indent -= 4;
        return cnt;
    }

    public static void main(String[] args) {
        EquationSolverBackTrack solver = new EquationSolverBackTrack();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<String> nums = new ArrayList<String>();
        String line = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        for (int i = 0; i < n - 1; i++) {
            nums.add(st.nextToken().trim());
        }
        int result = Integer.parseInt(st.nextToken().trim());
        List<String> out = solver.solve(nums, result);
        StringBuilder sb = new StringBuilder();
        if (out != null) {
            for (String o : out) {
                sb.append(o);
            }
        }
        System.out.println(sb.length() == 0 ? "NO SOLUTION" : sb.toString());
    }

    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
