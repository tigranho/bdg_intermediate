package com.bdg.generic;

import java.util.*;

public class CustomArrayList<E> implements List<E> {

    private E[] array;
    private int size;
    private int defaultSize;


    public CustomArrayList() {
        this.defaultSize = 16;
        this.array = (E[]) new Object[this.defaultSize];
    }

    public CustomArrayList(int defaultSize) {
        this.defaultSize = defaultSize;
        this.array = (E[]) new Object[this.defaultSize];
    }


    public boolean add(E e) {
        if (this.array != null) {
            if (size == array.length) {
                this.copy(this.array);
            }
            array[size++] = e;
            return true;
        }
        return false;
    }

    private void copy(E[] array) {
        E[] copyArray = Arrays.copyOf(array, array.length + 10);
        this.array = copyArray;
    }


    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean remove(Object o) {
        if (this.array!=null && o!=null){

        }
        return false;
    }


    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public void clear() {

    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }


    public E remove(int index) {
        return null;
    }


    public Iterator<E> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
