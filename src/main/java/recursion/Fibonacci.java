package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class Fibonacci {

    public long fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public long fibRecursiveMemoize(int n) {
        return _fibRecursiveMemoize(n, new HashMap<Integer, Long>());
    }

    private long _fibRecursiveMemoize(int n, Map<Integer, Long> cache) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long i = _fibRecursiveMemoize(n - 1, cache) + _fibRecursiveMemoize(n - 2, cache);
            cache.put(n, i);
            return i;
        }
    }


    public static void main(String[] args) {
        testAll();
    }


    private static void testAll() {
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
        if (r != e) {
            throw new RuntimeException("Unexpected result " + r + " expected " + e);
        }
    }

    private static void testRecursiveMemoize(int n, long e) {
        Fibonacci fib = new Fibonacci();
        long r = fib.fibRecursiveMemoize(n);
        if (r != e) {
            throw new RuntimeException("Unexpected result " + r + " expected " + e);
        }
    }

}
