package org.absharma.ds;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class DLinkedList<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;

    public DLLNode<T> head() {
        return head;
    }

    public DLLNode<T> tail() {
        return tail;
    }

    public void addFirst(T t) {
        DLLNode<T> node = new DLLNode<T>(t, head, null);
        node.data = t;
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            head = node; // move head
        }
    }

    public void addLast(T t) {
        DLLNode<T> node = new DLLNode<T>(t, null, tail);
        node.data = t;
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node; // move tail
        }
    }

    public void addBefore(T t, T u) {
        DLLNode<T> n = get(t);
        if (n != null) {
            DLLNode<T> node = new DLLNode<T>(u, n, n.prev);
            if (n.prev != null) {
                n.prev.next = node;
            }
            n.prev = node;
            if (n == head) { // if n was head reset
                head = node;
            }
        }
    }

    public void addAfter(T t, T u) {
        DLLNode<T> n = get(t);
        if (n != null) {
            DLLNode<T> node = new DLLNode<T>(u, n.next, n);
            if (n.next != null) {
                n.next.prev = node;
            }
            n.next = node;
            if (n == tail) { // if n was tail reset
                tail = node;
            }
        }
    }

    public void remove(T t) {
        DLLNode<T> n = get(t);
        if (n != null) {
            if(n.next != null)
                n.next.prev = n.prev;
            if(n.prev != null)
                n.prev.next = n.next;
            if(n == head) { // if n was head reset
                head = n.next;
            }
            if(n == tail) { // if n was tail reset
                tail = n.prev;
            }
        }
    }

    public DLLNode<T> get(T t) {
        DLLNode<T> n = head;
        while (n != null) {
            if (n.data.equals(t)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    public DLLNode<T> getRec(T t) {
        return _getRec(head, t);
    }

    private DLLNode<T> _getRec(DLLNode<T> node, T t) {
        if (node == null) {
            return null;
        } else if (node.data.equals(t)) {
            return node;
        } else {
            return _getRec(node.next, t);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLLNode<T> node = head;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
        }
        return sb.toString();
    }

    public String toStringReverse() {
        StringBuilder sb = new StringBuilder();
        DLLNode<T> node = tail;
        while (node != null) {
            sb.append(node.data);
            node = node.prev;
        }
        return sb.toString();
    }

}
