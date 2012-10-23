package misc;

import expr.Expression;
import permutations.Permutations;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class EquationSolver implements EqSolver {
    private static final List<String> operators = Arrays.asList("+", "-", "*");

    public List<String> solve(final List<String> nums, final Integer rhs) {
        Permutations permute = new Permutations();

        int numSlots = nums.size() - 1;
        List<String> opList = new ArrayList<String>();
        for (int i = 0; i < numSlots; i++) {
            opList.addAll(operators);
        }

        final Expression e = new Expression();
        Permutations.PermutationCallback callback = new Permutations.PermutationCallback() {
            @Override
            public boolean call(List<String> solution) {
                List<String> expr = createExpr(nums, solution);
                int o = e.evaluate(e.infixToPostFix(expr));
                return (o != rhs);
            }
        };
        Set<List<String>> ops = permute.permute(opList, numSlots, callback);

        for (List<String> op : ops) {
            List<String> expr = createExpr(nums, op);
            int o = e.evaluate(e.infixToPostFix(expr));
            if (o == rhs) {
                return op;
            }
        }
        return null;
    }

    private List<String> createExpr(List<String> nums, List<String> op) {
        List<String> expr = new ArrayList<String>();
        Iterator<String> rit = nums.iterator();
        Iterator<String> oit = op.iterator();
        int total = nums.size() + op.size();
        for (int i = 0; i < total; i++) {
            if (i % 2 == 0) {
                expr.add(rit.next());
            } else {
                expr.add(oit.next());
            }
        }
        return expr;
    }

    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
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
        if(out != null) {
            for(String o : out) {
                sb.append(o);
            }
        }
        System.out.println(sb.length() == 0 ? "NO SOLUTION" : sb.toString());
    }
}
