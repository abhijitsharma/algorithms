package org.absharma.ds;

import junit.framework.Assert;
import org.absharma.sort.SelectionSort;
import org.absharma.sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: absharma
 * Date: 11/29/12
 */
public class TestSort {

    private static String[][] stringCases = new String[][]{
            new String[]{"E", "X", "A", "M", "P", "L", "E"},
            new String[]{"U", "O", "I", "E", "A"},
            new String[]{"A", "E", "I", "O", "U"},
            new String[]{"A"},
            new String[]{"foo", "blah"},
    };

    private static String[] stringResults = new String[]{
            "[A, E, E, L, M, P, X]",
            "[A, E, I, O, U]",
            "[A, E, I, O, U]",
            "[A]",
            "[blah, foo]",
    };

    private static Integer[][] intCases = new Integer[][]{
            new Integer[]{},
            new Integer[]{1},
            new Integer[]{3, 2, 1},
            new Integer[]{2, 1, 3},
            new Integer[]{1, 2, 3},
            new Integer[]{1, 2, 1},
            new Integer[]{16, 87, 3, 8, 789, -1, 8888, -99},
    };

    public static String[] intResults = new String[]{
            "[]",
            "[1]",
            "[1, 2, 3]",
            "[1, 2, 3]",
            "[1, 2, 3]",
            "[1, 1, 2]",
            "[-99, -1, 3, 8, 16, 87, 789, 8888]",
    };

    @Test
    public void testSelectionSortOnInts() {
        Sort<Integer> sort = new SelectionSort<Integer>();
        for (int i = 0; i < intCases.length; i++) {
            Integer[] aCase = intCases[i];
            String exp = intResults[i];
            sort.sort(aCase);
            Assert.assertEquals(exp, Arrays.toString(aCase));
        }
    }

    @Test
    public void testSelectionSortOnStrings() {
        Sort<String> sort = new SelectionSort<String>();
        for (int i = 0; i < stringCases.length; i++) {
            String[] aCase = stringCases[i];
            String exp = stringResults[i];
            sort.sort(aCase);
            Assert.assertEquals(exp, Arrays.toString(aCase));
        }
    }
}
