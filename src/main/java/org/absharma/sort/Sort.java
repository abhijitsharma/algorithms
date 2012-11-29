package org.absharma.sort;

/**
 * User: absharma
 * Date: 11/29/12
 */
public interface Sort<T extends Comparable<T>> {

    void sort(T[] arr);

}
