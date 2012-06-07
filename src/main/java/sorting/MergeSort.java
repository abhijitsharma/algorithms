package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class MergeSort {

    private MergeSortedLists merger = new MergeSortedLists();

    /**
     * Sort a list of integers
     *
     * @param is list of integers to be sorted
     * @return list of sorted integers
     */
    public List<Integer> sort(List<Integer> is) {
        int size = (is == null) ? 0 : is.size();
        if (size <= 1) { // array of 0/1 elements is sorted
            return is;
        }

        int mid = size / 2;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        for (int i = 0; i < mid; i++) {
            l1.add(is.get(i));
        }
        for (int i = mid; i < size; i++) {
            l2.add(is.get(i));
        }
        return merger.merge(sort(l1), sort(l2));
    }
    
}
