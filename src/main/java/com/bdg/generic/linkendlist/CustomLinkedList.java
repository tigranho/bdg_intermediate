package com.bdg.generic.linkendlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<E> implements List<E> {

    private final static int DEFAULT_SIZE = 16;
    private Node tailNode;
    private int size = 0;
    private Node headNode;

    public CustomLinkedList() {
        this.headNode = null;
        this.tailNode = null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean add(E e) {
        Node element = new Node(null, null, e);
        if (headNode == null) {
            headNode = element;
            tailNode = null;
        } else {
            Node n = headNode;
            while (n.next != null) {
                n = n.next;

            }
            n.next = element;
            size++;
            return true;
        }
        return false;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public boolean addAll(Collection<? extends E> c) {
        return false;
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


    static class Node {
        Node next;
        Node prev;
        Object data;

        public Node(Node next, Node prev, Object data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

}
