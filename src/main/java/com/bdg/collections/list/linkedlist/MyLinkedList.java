package com.bdg.collections.list.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyLinkedList<T> implements List<T> {
    private int size = 0;

    private class Node {
        private Node prev;
        private Node next;
        private T item;

        Node(T item) {
            this.item = item;
            prev = null;
            next = null;
        }
    }

    private Node firstItem = null;
    private Node lastItem = null;


    @Override
    public boolean isEmpty() {
        return this.firstItem == null;
    }


    /**
     * Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Appends the specified element to the end of this list.
     * This method is equivalent to addLast(E).
     * <p>
     * Specified by:
     * add in interface Collection<E>
     * Specified by:
     * add in interface List<E>
     * e - element to be appended to this list
     * Returns:
     * true (as specified by Collection.add(E))
     */
    @Override
    public boolean add(T data) {
        Node temp = new Node(data);
        if (firstItem == null) {
            firstItem = temp;
        } else {
            lastItem.next = temp;
            temp.prev = lastItem;
        }
        lastItem = temp;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * Specified by:
     * add in interface List<E>
     * Overrides:
     * add in class AbstractSequentialList<E>
     * Parameters:
     * index - index at which the specified element is to be inserted
     * element - element to be inserted
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node item = new Node(element);
            firstItem.prev = item;
            item.next = firstItem;
            firstItem = item;
            size++;
            return;
        }
        if (index >= size) {
            add(element);
        } else {
            Node shiftItem = firstItem;
            Node item = new Node(element);
            while (index-- > 0)
                shiftItem = shiftItem.next;
            Node prevItem = shiftItem.prev;
            prevItem.next = item;
            shiftItem.prev = item;
            item.prev = prevItem;
            item.next = shiftItem;
            size++;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * Specified by:
     * get in interface List<E>
     * Overrides:
     * get in class AbstractSequentialList<E>
     * Parameters:
     * index - index of the element to return
     * Returns:
     * the element at the specified position in this list
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0)
            return null;
        if (index <= 0)
            return firstItem.item;
        if (index > size)
            return lastItem.item;

        Node result = firstItem;
        while (index-- > 0)
            result = result.next;
        return result.item;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * Specified by:
     * remove in interface List<E>
     * Overrides:
     * remove in class AbstractSequentialList<E>
     * Parameters:
     * index - the index of the element to be removed
     * Returns:
     * the element previously at the specified position
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T remove(int index) {
        if (size == 0 || index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node remItem = firstItem;
        while (index-- > 0)
            remItem = remItem.next;
        remItem.prev.next = remItem.next;
        remItem.next.prev = remItem.prev;
        size--;
        return remItem.item;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
     * contains in interface List<E>
     * Overrides:
     * contains in class AbstractCollection<E>
     * Parameters:
     * o - element whose presence in this list is to be tested
     * Returns:
     * true if this list contains the specified element
     */
    @Override
    public boolean contains(Object element) {

        Node cursor = firstItem;

        for (int x = 0; x < size; x++) {
            if (cursor == null) {
                return false;
            } else if (cursor.item == element) {
                return true;
            } else {
                cursor = cursor.next;
            }
        }

        return false;

    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node actviItem = firstItem;

            @Override
            public boolean hasNext() {
                if (actviItem == null) return false;
                return actviItem.next != null;
            }

            @Override
            public T next() {
                if (actviItem == null)
                    return null;
                Node result = actviItem;
                actviItem = result.next;
                return result.item;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T item : this)
            result.append(item).append(" ");
        return result.toString();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return false;
    }

    public boolean copy(Collection<? super T> c) {

        return false;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }


}