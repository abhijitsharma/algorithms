package org.absharma.sort;

/**
 * User: absharma
 * Date: 11/28/12
 */
public class SelectionSort {

    public void sort(Comparable[] arr) {
        int n = arr == null ? 0 : arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }

            if (min != i) {
                Comparable temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
