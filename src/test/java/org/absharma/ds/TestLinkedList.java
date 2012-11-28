package org.absharma.ds;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class TestLinkedList {

    @Test
    public void testLL() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        searchNonExisting(ll, 1);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals(ll.print(), "321");

        searchExisting(ll, 1);
        searchExisting(ll, 2);
        searchExisting(ll, 3);
        searchNonExisting(ll, 4);
    }

    @Test
    public void testLLHead() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals(ll.getHead().data, 3);
        ll.remove(3);
        Assert.assertEquals(ll.getHead().data, 2);
        ll.remove(2);
        Assert.assertEquals(ll.getHead().data, 1);
        ll.remove(1);
        Assert.assertNull(ll.getHead());
        ll.addFirst(1);
        Assert.assertEquals(ll.getHead().data, 1);
        ll.addFirst(2);
        Assert.assertEquals(ll.getHead().data, 2);
    }

    @Test
    public void testLLInsertAfter() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "135");
        ll.addAfter(1, 2);
        Assert.assertEquals(ll.print(), "1235");
        ll.addAfter(3, 4);
        Assert.assertEquals(ll.print(), "12345");
        ll.addAfter(5, 6);
        Assert.assertEquals(ll.print(), "123456");
        ll.addAfter(9, 98);
        Assert.assertEquals(ll.print(), "123456");
        ll.remove(1);
        ll.remove(6);
        Assert.assertEquals(ll.print(), "2345");
        ll.remove(2);
        ll.remove(3);
        ll.remove(4);
        ll.remove(5);
        Assert.assertEquals(ll.print(), "");
    }

    @Test
    public void testLLInsertBefore() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "135");
        ll.addBefore(3, 2);
        Assert.assertEquals(ll.print(), "1235");
        ll.addBefore(5, 4);
        Assert.assertEquals(ll.print(), "12345");
        ll.addBefore(1, 0);
        Assert.assertEquals(ll.print(), "012345");
        ll.addBefore(6, 22);
        Assert.assertEquals(ll.print(), "012345");
    }

    @Test
    public void testLLInsertBeforeV2() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "135");
        ll.addBeforeV2(3, 2);
        Assert.assertEquals(ll.print(), "1235");
        ll.addBeforeV2(5, 4);
        Assert.assertEquals(ll.print(), "12345");
        ll.addBeforeV2(1, 0);
        Assert.assertEquals(ll.print(), "012345");
        ll.addBeforeV2(6, 22);
        Assert.assertEquals(ll.print(), "012345");
        Assert.assertEquals(6, ll.size());
        Assert.assertEquals(6, ll.sizeIter());
    }

    @Test
    public void testLLDelete() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.remove(1);
        Assert.assertEquals(ll.print(), "");
        Assert.assertEquals(0, ll.size());
        Assert.assertEquals(0, ll.sizeIter());
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "1");
        Assert.assertEquals(1, ll.size());
        Assert.assertEquals(1, ll.sizeIter());
        ll.remove(1);
        Assert.assertEquals(ll.print(), "");
        ll.remove(1);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals(2, ll.size());
        Assert.assertEquals(2, ll.sizeIter());
        ll.remove(2);
        Assert.assertEquals(ll.print(), "3");
        Assert.assertEquals(1, ll.size());
        Assert.assertEquals(1, ll.sizeIter());
        ll.remove(11);
        ll.remove(3);
        Assert.assertEquals(ll.print(), "");
        Assert.assertEquals(0, ll.size());
        Assert.assertEquals(0, ll.sizeIter());
    }

    @Test
    public void testLLDeleteVer2() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.removeVer2(1);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "1");
        ll.removeVer2(1);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(2);
        ll.addFirst(3);
        ll.removeVer2(2);
        Assert.assertEquals(ll.print(), "3");
        ll.removeVer2(11);
        ll.removeVer2(3);
        Assert.assertEquals(ll.print(), "");
    }

    @Test
    public void testLLDeleteBoundary() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals(ll.print(), "321");
        ll.remove(5);
        Assert.assertEquals(ll.print(), "321");

        ll.remove(2);
        Assert.assertEquals(ll.print(), "31");
        ll.remove(1);
        Assert.assertEquals(ll.print(), "3");
        ll.remove(3);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "1");
        ll.remove(4);
        Assert.assertEquals(ll.print(), "1");
    }

    @Test
    public void testLLDeleteVer2Boundary() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals(ll.print(), "321");
        ll.removeVer2(5);
        Assert.assertEquals(ll.print(), "321");

        ll.removeVer2(2);
        Assert.assertEquals(ll.print(), "31");
        ll.removeVer2(1);
        Assert.assertEquals(ll.print(), "3");
        ll.removeVer2(3);
        Assert.assertEquals(ll.print(), "");
        ll.addFirst(1);
        Assert.assertEquals(ll.print(), "1");
        ll.removeVer2(4);
        Assert.assertEquals(ll.print(), "1");
    }

    private void searchExisting(LinkedList<Integer> ll, int find) {
        LLNode<Integer> n;
        n = ll.getRecursive(find);
        Assert.assertEquals(n.data, find);
        n = ll.getIter(find);
        Assert.assertEquals(n.data, find);
    }

    private void searchNonExisting(LinkedList<Integer> ll, int find) {
        LLNode<Integer> n;
        n = ll.getRecursive(find);
        Assert.assertNull(n);
        n = ll.getIter(find);
        Assert.assertNull(n);
    }
}
