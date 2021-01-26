package com.bdg.collections;

import java.util.*;


public class CustomLinkedList<E> implements List<E> {
    private final static int DEFAULT_SIZE = 16;
    private Node<E> tailNode;
    private int size = 0;
    private Node<E> headNode;


    static class Node<E> {
        Node<E> next;
        Node<E> prev;
        Object data;

        public Node(Node<E> next, Node<E> prev, Object data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;

    public CustomLinkedList() {
        this.headNode = null;
        this.tailNode = null;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to .
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(E e) {
        Node<E> element = new Node<>(null, null, e);
        if (headNode == null) {
            headNode = element;
            tailNode = null;
        } else {
            Node<E> n = headNode;
            while (n.next != null) {
                n = n.next;
            }
            n.next = element;
            size++;
            return true;
        }
        return true;
    }

    /**
     * Returns the number of elements in this list.
     * Returns:
     * the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            Object[] o = c.toArray();
            for (Object value : o) {
                add((E) value);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return true;
    }


    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public E remove(int index) {
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}

