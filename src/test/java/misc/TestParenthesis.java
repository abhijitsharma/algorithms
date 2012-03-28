package misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestParenthesis {
    @Test
    public void testParenthesis() {
        test("()", true);
        test("())", false);
        test("(", false);
        test(")(", false);
        test("((()))", true);
        test("((())", false);
        test("((()))()", true);
        test("())(", false);
    }

    private void test(String s, boolean expected) {
        Parenthesis p = new Parenthesis();
        boolean b = p.matchParenthesis(s);
        Assert.assertEquals(expected, b);
    }

}
