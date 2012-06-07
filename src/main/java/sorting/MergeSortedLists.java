package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 5/31/12
 */
public class MergeSortedLists {

    /**
     * Merge sorted lists so that the result is also sorted
     * 
     * @param l1 sorted list
     * @param l2 sorted list
     * @return union of sorted lists to yield l1 sorted union of lists
     */
    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<Integer>();
        int l1sz = l1.size();
        int l2sz = l2.size();
        int i = 0, j = 0;
        while (i < l1sz && j < l2sz) {
            Integer l1Item = l1.get(i);
            Integer l2Item = l2.get(j);
            if (l1Item < l2Item) {
                result.add(l1Item);
                i++;
            } else if (l1Item.equals(l2Item)) {
                result.add(l1Item);
                result.add(l2Item);
                i++;
                j++;
            } else {
                result.add(l2Item);
                j++;
            }
        }

        while (i < l1sz) {
            result.add(l1.get(i++));
        }

        while (j < l2sz) {
            result.add(l2.get(j++));
        }

        return result;
    }
}
