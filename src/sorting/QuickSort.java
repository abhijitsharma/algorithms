package sorting;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class QuickSort {

    /** Other ways of choosing pivot
     *      - take (first + last)/2 or to prevent overflows first + (last - first)/2
     *      - random choice
     * @param is list of integers to be sorted
     * @return list of sorted integers
     */
    public List<Integer> recursiveSort(List<Integer> is) {
        if (is == null || is.size() == 0 || is.size() == 1) { // array of 0/1 elements is sorted
            return is;
        }
        
        int pivot = is.get(is.size() - 1); // last element is the pivot
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> more = new ArrayList<Integer>();

        for (int i = 0; i < is.size() - 1; i++) { // exclude the pivot i.e. the last element
            int value = is.get(i);
            if (value < pivot) { // split into arrays that are less and more than pivot
                less.add(value);
            } else {
                more.add(value);
            }
        }
        // sort the less and more arrays recursively and merge less, pivot and right
        return merge(recursiveSort(less), pivot, recursiveSort(more));
    }

    private List<Integer> merge(List<Integer> a, int b, List<Integer> c) {
        List<Integer> result = new ArrayList<Integer>();
        if (a != null) {
            for (int i : a) {
                result.add(i);
            }
        }
        result.add(b);
        if (c != null) {
            for (int i : c) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testAll();
    }

    private static void testAll() {
        test(null, new ArrayList<Integer>());
        test(null, null);
        test(Arrays.asList(1), Arrays.asList(1));
        test(Arrays.asList(3, 9, 8, 7, 2, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        test(Arrays.asList(3, 9, 8, 7, 2, 5, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9));
        test(Arrays.asList(1,2,3,4,5), Arrays.asList(1,2,3,4,5));
        test(Arrays.asList(5,4,3,2,1), Arrays.asList(1,2,3,4,5));
    }

    private static void test(List<Integer> is, List<Integer> expected) {
        QuickSort qs = new QuickSort();
        List<Integer> rs = qs.recursiveSort(is);
        Utils.printList(rs);
        Utils.printList(expected);
        if (!Utils.listEquals(rs, expected)) {
            throw new RuntimeException("Lists not equal");
        }
    }
}
