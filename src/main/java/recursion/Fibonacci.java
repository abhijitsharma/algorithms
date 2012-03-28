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
}
