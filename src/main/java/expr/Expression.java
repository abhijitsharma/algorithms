package expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class Expression {

    private static final List<String> operators = Arrays.asList("+", "-", "*");

    public int evaluate(List<String> expr) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : expr) {
            if (operators.contains(s)) {
                Integer i2 = stack.pop();
                Integer i1 = stack.pop();
                stack.push(result(s, i1, i2));
            } else {
                Integer i = Integer.parseInt(s);
                stack.push(i);
            }
        }
        return stack.pop();
    }

    private int result(String op, Integer i1, Integer i2) {
        switch (op.charAt(0)) {
            case '-':
                return i1 - i2;
            case '+':
                return i1 + i2;
            case '*':
                return i1 * i2;
        }
        throw new IllegalArgumentException("Operator " + op);
    }

    public List<String> infixToPostFix(List<String> expr) {
        List<String> out = new ArrayList<String>();
        Stack<String> opStack = new Stack<String>();
        for (String s : expr) {
            if (operators.contains(s)) {
                while (opStack.size() > 0) {
                    String top = opStack.peek();
                    if (_isHigher(top, s)) {
                        top = opStack.pop();
                        out.add(top);
                    } else {
                        break;
                    }
                }
                opStack.push(s);
            } else {
                Integer.parseInt(s);
                out.add(s);
            }
//            System.out.println(out);
//            System.out.println(opStack);
        }
        while (opStack.size() > 0) {
            out.add(opStack.pop());
        }
        return out;
    }

    private int precedence(String op) {
        switch (op.charAt(0)) {
            case '-':
            case '+':
                return 1;
            case '*':
                return 3;
        }
        throw new IllegalArgumentException("Operator " + op);
    }

    private boolean _isHigher(String lop, String rop) {
        int lp = precedence(lop);
        int rp = precedence(rop);
        if(lp == rp) {
            return true;
        }
        return lp > rp;
    }
}
