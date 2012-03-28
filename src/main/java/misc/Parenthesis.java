package misc;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Parenthesis {
    public static void main(String[] args) {
        test("()", true);
        test("())", false);
        test("(", false);
        test(")(", false);
        test("((()))", true);
        test("((())", false);
        test("((()))()", true);
        test("())(", false);
    }

    private static void test(String s, boolean expected) {
        Parenthesis p = new Parenthesis();
        boolean b = p.matchParenthesis(s);
        if(b != expected) {
            throw new RuntimeException("Expected " + expected + " got " + b);
        }
    }

    public boolean matchParenthesis(String s) {
        int n = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')
                n++;
            if(c == ')')
                n--;
            if(n < 0) {
                return false;
            }
        }
        return n == 0;
    }

    //todo
    public boolean matchParenthesisStackBased(String s) {
        return true;
    }
}
