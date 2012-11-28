package org.absharma.ds;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 10/23/12
 */
public class TestDLinkedList {

    @Test
    public void testRemove() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.remove(2);
        Assert.assertEquals("31", ll.toString());
        Assert.assertEquals("13", ll.toStringReverse());
        ll.remove(1);
        Assert.assertEquals("3", ll.toString());
        Assert.assertEquals("3", ll.toStringReverse());
        ll.remove(3);
        Assert.assertEquals("", ll.toString());
        Assert.assertEquals("", ll.toStringReverse());
    }
    
    @Test
    public void testAddFirst() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals("321", ll.toString());
        Assert.assertEquals(1, ll.get(1).data);
        Assert.assertEquals(2, ll.get(2).data);
        Assert.assertEquals(3, ll.get(3).data);
        Assert.assertEquals("321", ll.toString());
        Assert.assertEquals(1, ll.getRec(1).data);
        Assert.assertEquals(2, ll.getRec(2).data);
        Assert.assertEquals("321", ll.toString());
        Assert.assertEquals(3, ll.getRec(3).data);
        Assert.assertNull(ll.get(4));
        Assert.assertEquals("321", ll.toString());
    }

    @Test
    public void testCheckHeadTail() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertNull(ll.head());
        Assert.assertNull(ll.tail());
        Assert.assertEquals(ll.toString(), "");
        ll.addLast(1);
        Assert.assertEquals(1, ll.head().data);
        Assert.assertEquals(1, ll.tail().data);
        ll.addLast(2);
        Assert.assertEquals(1, ll.head().data);
        Assert.assertEquals(2, ll.tail().data);
        ll.addLast(3);
        Assert.assertEquals(1, ll.head().data);
        Assert.assertEquals(3, ll.tail().data);
        Assert.assertEquals("123", ll.toString());
    }

    @Test
    public void testAddBefore() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals("321", ll.toString());
        Assert.assertEquals("123", ll.toStringReverse());
        ll.addBefore(3, 0);
        Assert.assertEquals("0321", ll.toString());
        Assert.assertEquals("1230", ll.toStringReverse());
        ll.addBefore(1, 5);
        Assert.assertEquals("03251", ll.toString());
        Assert.assertEquals("15230", ll.toStringReverse());
        ll.addBefore(6, 7);
        Assert.assertEquals("03251", ll.toString());
        Assert.assertEquals("15230", ll.toStringReverse());
    }

    @Test
    public void testAddAfter() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        Assert.assertEquals("321", ll.toString());
        Assert.assertEquals("123", ll.toStringReverse());
        ll.addAfter(1, 4);
        Assert.assertEquals("3214", ll.toString());
    }

    @Test
    public void testAddLast() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Assert.assertEquals("123", ll.toString());
    }

    @Test
    public void testAddFirstLast() {
        DLinkedList<Integer> ll = new DLinkedList<Integer>();
        Assert.assertEquals(ll.toString(), "");
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addFirst(5);
        ll.addLast(6);
        Assert.assertEquals("531246", ll.toString());
    }

}
