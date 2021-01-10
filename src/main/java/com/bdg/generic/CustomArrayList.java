package com.bdg.generic;

import java.util.*;

public class CustomArrayList<E> implements List<E> {

    private final int defaultSize;
    private E[] array;
    private int size;


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


    private void removeArraySize(E index) {
        int count = 0;
        E[] temp = (E[]) new Object[this.array.length - 1];
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(index)) {
                temp[count++] = this.array[i];
            }
        }
        size -= 1;
        this.array = temp;
    }

    public boolean remove(Object o) {
        if (this.array != null && o != null) {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {
                    this.removeArraySize(array[i]);
                    return true;
                }
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        if (array != null && value != null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.array = null;
    }

    public E get(int index) {
        return array[index];
    }


    public E set(int index, E element) {
        if (array != null && element != null) {
            for (int i = 0; i < this.size; i++) {
                if (size == this.array.length) {
                    this.copy(this.array);
                } else if (index == i) {
                    this.array[index] = element;
                    size++;
                    return element;
                }
            }
        }
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
