package sorting;

import utils.Utils;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

    }

    private static void testAll() {
        
    }

    private static void test(int[] is, int[] expected) {
        QuickSort qs = new QuickSort();
        int[] rs = qs.recursiveSort(is);
        Utils.printIntArray(rs);
        Utils.printIntArray(expected);
        if(!Utils.intArrayEquals(rs, expected)) {
            throw new RuntimeException("Arrays not equal");
        }
    }

    public int[] recursiveSort(int[] is) {
        if(is == null || is.length == 0) {
            
        }

        return
    }

    private int[] merge(int[] a, int[] b , int[] c) {
        
    }
}
