package org.absharma.ds;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class LinkedList<T> {
    private LLNode<T> head;

    public void addFirst(T t) {
        LLNode<T> node = new LLNode<T>();
        node.data = t;
        node.next = head;
        head = node;
    }

    public void addAfter(T t, T u) {
        LLNode<T> n = getRecursive(t);
        if (n != null) {
            LLNode<T> node = new LLNode<T>();
            node.data = u;
            node.next = n.next;
            n.next = node;
        }
    }

    public void addBefore(T t, T u) {
        LLNode<T> n = getRecursive(t);

        LLNode<T> node = new LLNode<T>();
        node.data = u;

        if (n != null) {
            LLNode<T> p = getPredecessor(t);
            if (p != null) {
                node.next = p.next;
                p.next = node;
            } else {
                node.next = head;
                head = node; // reset head
            }
        }
    }

    public void addBeforeV2(T t, T u) {
        LLNode<T> p = getPredecessor(t);
        LLNode<T> node = new LLNode<T>();
        node.data = u;

        if (p != null) {
            node.next = p.next;
            p.next = node;
        } else { // No predecessor - If the list is NOT empty - Either t is first or t is missing
            if (head != null && head.data.equals(t)) {
                node.next = head;
                head = node; // reset head
            }
        }
    }

    public int size() {
        return _size(head);
    }

    public int sizeIter() {
        int i = 0;
        LLNode<T> node = head;
        while(node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    private int _size(LLNode<T> node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + _size(node.next);
        }
    }

    public void remove(T t) {
        LLNode<T> n = getRecursive(t);
        if (n != null) {
            LLNode<T> p = getPredecessor(t);
            if (p != null) {
                p.next = n.next;
            } else { // reset head if this was first
                head = n.next;
            }
        }
    }

    public void removeVer2(T t) {
        LLNode<T> p = getPredecessor(t);
        if (p != null) {
            p.next = p.next.next;
        } else { // No predecessor - If the list is NOT empty - Either T is first or T is missing
            if (head != null && head.data.equals(t))
                head = head.next; // reset head
        }
    }

    public LLNode<T> getIter(T t) {
        LLNode<T> node = head;
        while (node != null) {
            if (node.data.equals(t)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public LLNode<T> getPredecessor(T t) {
        return _getPredecessor(head, t);
    }

    private LLNode<T> _getPredecessor(LLNode<T> node, T t) {
        if (node == null || node.next == null) {
            return null;
        } else if (node.next.data.equals(t)) {
            return node;
        } else {
            return _getPredecessor(node.next, t);
        }
    }

    public LLNode<T> getRecursive(T t) {
        return _getRecursive(head, t);
    }

    private LLNode<T> _getRecursive(LLNode<T> node, T t) {
        if (node == null) {
            return null;
        } else if (node.data.equals(t)) {
            return node;
        } else {
            return _getRecursive(node.next, t);
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        LLNode<T> node = head;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
        }
        return sb.toString();
    }
}
