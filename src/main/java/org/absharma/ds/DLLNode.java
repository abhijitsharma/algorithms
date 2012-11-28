package org.absharma.ds;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class DLLNode<T> {
    public T data;
    public DLLNode<T> next;
    public DLLNode<T> prev;

    public DLLNode(T data, DLLNode<T> next, DLLNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "'" + data + "'";
    }
}
