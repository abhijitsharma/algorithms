package sorting;

import java.util.ArrayList;
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

    //todo
    public List<Integer> iterativeSort(List<Integer> is) {
        return null;
    }

    //todo
    public List<Integer> inplaceSort(List<Integer> is) {
        return null;
    }

}
