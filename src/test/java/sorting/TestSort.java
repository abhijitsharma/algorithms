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
public class TestSort {

    private static void mergeSort(List<Integer> is, List<Integer> expected) {
        MergeSort sort = new MergeSort();
        List<Integer> rs = sort.sort(is);
        Utils.printList(rs);
        Utils.printList(expected);
        System.out.println("--");
        Assert.assertTrue(Utils.listEquals(rs, expected));
    }

    private static void bubbleSort(List<Integer> is, List<Integer> expected) {
        BubbleSort sort = new BubbleSort();
        List<Integer> rs = sort.sort(is);
        Utils.printList(rs);
        Utils.printList(expected);
        System.out.println("--");
        Assert.assertTrue(Utils.listEquals(rs, expected));
    }

    @Test
    public void testSort() {
        testSortAll(null, new ArrayList<Integer>());
        testSortAll(null, null);
        testSortAll(Arrays.asList(1), Arrays.asList(1));
        testSortAll(Arrays.asList(3, 9, 8, 7, 2, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        testSortAll(Arrays.asList(3, 9, 8, 7, 2, 4, 1, 2, 6, 5), Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9));
        testSortAll(Arrays.asList(3, 9, 8, 7, 2, 5, 4, 1, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9));
        testSortAll(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5));
        testSortAll(Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(1, 2, 3, 4, 5));
    }

    private void testSortAll(List<Integer> is, List<Integer> expected) {
        quickSort(is, expected);
        mergeSort(is, expected);
        bubbleSort(is, expected);
    }

    private static void quickSort(List<Integer> is, List<Integer> expected) {
        QuickSort sort = new QuickSort();
        List<Integer> rs = sort.recursiveSort(is);
        Utils.printList(rs);
        Utils.printList(expected);
        System.out.println("--");
        Assert.assertTrue(Utils.listEquals(rs, expected));
    }

}
