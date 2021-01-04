package com.bdg.collections.list.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedListIterator<E> implements Iterable<E> {

    private Node first;
    private Node last;
    private int size;

    public CustomLinkedListIterator() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     * Returns:
     * true (as specified by Collection.add(E))
     */

    public boolean add(E item) {
        if (!isEmpty()) {
            Node prev = last;
            last = new Node(item, null);
            prev.next = last;
        } else {
            last = new Node(item, null);
            first = last;
        }
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
     * Parameters:
     * o - element to be removed from this list, if present
     * Returns:
     * true if this list contained the specified element
     */
    public boolean remove(E item) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }
        boolean result = false;
        Node prev = first;
        Node curr = first;
        while (curr.next != null || curr == last) {
            if (curr.data.equals(item)) {
                // remove the last remaining element
                if (size == 1) {
                    first = null;
                    last = null;
                }
                // remove first element
                else if (curr.equals(first)) {
                    first = first.next;
                }
                // remove last element
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                }
                // remove element
                else {
                    prev.next = curr.next;
                }
                size--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.next;
        }
        return result;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    /**
     * Iterator<T> iterator()
     * Returns an iterator over a set of elements of type T.
     * Returns:
     * an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListLinkedIterator();
    }

    private class ListLinkedIterator implements Iterator<E> {
        private Node<E> current = first;


        /**
         * E next()
         * Returns the next element in the iteration.
         * Returns:
         * the next element in the iteration
         * Throws:
         * NoSuchElementException - if the iteration has no more elements
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.data;
            current = current.next;
            return item;
        }

        /**
         * boolean hasNext()
         * Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
         * Returns:
         * true if the iteration has more elements
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * void remove()
         * Removes from the underlying collection the last element returned by this iterator (optional operation). This method can be called only once per call to next().
         * The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
         * Throws:
         * UnsupportedOperationException - if the remove operation is not supported by this iterator
         * IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }


}



