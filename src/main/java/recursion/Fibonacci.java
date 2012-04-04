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

    public long fibIterativeRecursive(int n) {
        return _fibIterativeRecursive(1, 0, n);
    }

    private long _fibIterativeRecursive(int lst, int secLst, int n) {
        if (n == 0) {
            return secLst;
        }
        return _fibIterativeRecursive((lst + secLst), lst, --n);
    }

    public long fibIterative(int n) {
        int secLst = 0;
        int lst = 1;
        for (int i = 1; i <= n;i++) {
            int tmp = lst + secLst;
            secLst = lst;
            lst = tmp;
        }
        return secLst;
    }
}
