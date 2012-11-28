package org.absharma.ds;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class DLinkedListSentinel<T> {
    private final DLLNode<T> head;

    public DLinkedListSentinel() {
        head = new DLLNode<T>(null, null, null);
        head.next = head;
        head.prev = head;
    }

    public void addFirst(T t) {
        insertBefore(t, head.next);
    }

    public void addLast(T t) {
        insertBefore(t, head);
    }

    private void insertBefore(T t, DLLNode<T> node) {
        DLLNode<T> newNode = new DLLNode<T>(t, node, node.prev);
        node.prev.next = newNode;
        node.prev = newNode;
    }


    public void addBefore(T t, T u) {
    }

    public void addAfter(T t, T u) {
    }

    public void remove(T t) {
    }

    public DLLNode<T> get(T t) {
        DLLNode<T> node = head.next;
        while (node != head) {
            if(node.data.equals(t))
                return node;
            node = node.next;
        }
        return null;
    }

    public DLLNode<T> getRec(T t) {
        return null;
    }

    private DLLNode<T> _getRec(DLLNode<T> node, T t) {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLLNode<T> node = head.next;
        while (node != head) {
            sb.append(node.data);
            node = node.next;
        }
        return sb.toString();
    }

}
