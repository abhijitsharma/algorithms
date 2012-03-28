package sorting;

import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestQuickSort {

    @Test
    public void testQuickSort() {
        testBoth(null, new ArrayList<Integer>());
        testBoth(null, null);
        testBoth(Arrays.asList(1), Arrays.asList(1));
        testBoth(Arrays.asList(3, 9, 8, 7, 2, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        testBoth(Arrays.asList(3, 9, 8, 7, 2, 5, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9));
        testBoth(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5));
        testBoth(Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(1, 2, 3, 4, 5));
    }

    private void testBoth(List<Integer> is, List<Integer> expected) {
        testRecursive(is, expected);
    }

    private static void testRecursive(List<Integer> is, List<Integer> expected) {
        QuickSort qs = new QuickSort();
        List<Integer> rs = qs.recursiveSort(is);
        Utils.printList(rs);
        Utils.printList(expected);
        Assert.assertTrue(Utils.listEquals(rs, expected));
    }

}
