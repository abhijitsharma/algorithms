package sorting;

import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public class BubbleSort {

    /**
     * Sort a list of integers
     *
     * @param is list of integers to be sorted
     * @return list of sorted integers
     */
    public List<Integer> sort(List<Integer> is) {
        int size = is == null ? 0 : is.size();

        // number of passes ..
        // first pass sends the max number to right most position
        // second pass sends the second max number to right most position - 1
        for (int i = 0; i < size; i++) {

            // Keep swapping neighbours until you reach the already sorted i - 1 numbers
            // @ the end of the list in ith pass
            for (int j = 0; j < size - i - 1; j++) {
                Integer a = is.get(j);
                Integer b = is.get(j + 1);
                if (a > b) { // swap
                    is.set(j, b);
                    is.set(j + 1, a);
                }
            }
        }
        return is;
    }

}
