package expr;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class TestExpression {

    @Test
    public void testExpr() {
        Expression e = new Expression();
        List<String> out = e.infixToPostFix(Arrays.asList("8", "-", "5", "*", "2"));
        int result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);


        out = e.infixToPostFix(Arrays.asList("8", "+", "5", "*", "2", "-", "9"));
        result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);

        out = e.infixToPostFix(Arrays.asList("2", "-", "2", "+", "2"));
        result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);

        out = e.infixToPostFix(Arrays.asList("2", "+", "2", "-", "2"));
        result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);

        out = e.infixToPostFix(Arrays.asList("2", "-", "2", "+", "2"));
        result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);

        out = e.infixToPostFix(Arrays.asList("2", "+", "2", "-", "2"));
        result = e.evaluate(out);
        System.out.println("out = " + out + " result = " + result);
    }
}
