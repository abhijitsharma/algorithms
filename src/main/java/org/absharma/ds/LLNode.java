package org.absharma.ds;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class LLNode<T> {
    public T data;
    public LLNode<T> next;

    @Override
    public String toString() {
        return "'" + data + "'";
    }
}
