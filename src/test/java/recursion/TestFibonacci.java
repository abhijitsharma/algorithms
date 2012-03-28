package recursion;

import misc.Parenthesis;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestFibonacci {

    @Test
    public void testFibNth() {
        testAll();
    }

    private void testAll() {
        testAll(0, 0l);
        testAll(1, 1l);
        testAll(2, 1l);
        testAll(3, 2l);
        testAll(4, 3l);
        testAll(5, 5l);
        testAll(6, 8l);
        testAll(7, 13l);
        testAll(20, 6765l);
    }

    private static void testAll(int n, long e) {
        testRecursive(n, e);
        testRecursiveMemoize(n, e);
    }

    private static void testRecursive(int n, long e) {
        Fibonacci fib = new Fibonacci();
        long r = fib.fibRecursive(n);
        Assert.assertEquals(e, r);
    }

    private static void testRecursiveMemoize(int n, long e) {
        Fibonacci fib = new Fibonacci();
        long r = fib.fibRecursiveMemoize(n);
        Assert.assertEquals(e, r);
    }
}
