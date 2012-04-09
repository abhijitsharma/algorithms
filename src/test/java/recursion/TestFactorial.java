package recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestFactorial {

    @Test
    public void testFactorial() {
        testAll();
    }

    private void testAll() {
        testAll(1, 1l);
        testAll(2, 2l);
        testAll(3, 6l);
        testAll(4, 24l);
    }

    private static void testAll(int n, long e) {
        testRecursive(n, e);
        testIterativeRecursive(n, e);
        testIterative(n, e);
    }

    private static void testIterative(int n, long e) {
        Factorial f = new Factorial();
        long r = f.factorialIterative(n);
        Assert.assertEquals(e, r);
    }

    private static void testIterativeRecursive(int n, long e) {
        Factorial f = new Factorial();
        long r = f.factorialIterativeRecursive(n);
        Assert.assertEquals(e, r);
    }

    private static void testRecursive(int n, long e) {
        Factorial f = new Factorial();
        long r = f.factorialRecursive(n);
        Assert.assertEquals(e, r);
    }
}
