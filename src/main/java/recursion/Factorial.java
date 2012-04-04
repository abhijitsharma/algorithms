package recursion;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class Factorial {

    /**
     * depth of recursion grows and then all computations happen
     *
     * @param n
     * @return
     */
    public long factorialRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    /**
     * exploit the fact that n! can be calculated as:
     * p = ctr * p
     * ctr = ctr + 1
     * go till ctr exceeds n
     * tail recursive version or iterative
     *
     * @param n
     * @return
     */
    public long factorialIterativeRecursive(int n) {
        return _factorialIterativeRecursive(1, 1, n);
    }

    private long _factorialIterativeRecursive(int ctr, long p, int max) {
        if (max > ctr) {
            return p;
        }
        return _factorialIterativeRecursive(++ctr, p * ctr, max);
    }

    public long factorialIterative(int n) {
        long p = 1;
        for (int ctr = 1; ctr < n; ctr++) {
            p = p * ctr;
        }
        return p;
    }

}
