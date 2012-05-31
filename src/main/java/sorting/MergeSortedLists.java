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
     * @param a sorted list
     * @param b sorted list
     * @return union of sorted lists to yield a sorted union of lists
     */
    public List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();
        int asz = a.size();
        int bsz = b.size();
        int i = 0, j = 0;
        while (i < asz && j < bsz) {
            Integer aa = a.get(i);
            Integer bb = b.get(j);
            if (aa < bb) {
                result.add(aa);
                i++;
            } else if (aa.equals(bb)) {
                result.add(aa);
                result.add(bb);
                i++;
                j++;
            } else {
                result.add(bb);
                j++;
            }
        }

        while (i < asz) {
            result.add(a.get(i++));
        }

        while (j < bsz) {
            result.add(b.get(j++));
        }

        return result;
    }
}
