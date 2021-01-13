package com.bdg.secondhomework.CustomCollection.MyArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class CustomArrayList<T> implements List<T> {
    private int size = 0;
    private T[] array;
    private static final int CAPACITY = 10;

    CustomArrayList() {
        array = (T[]) new Object[CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : array) {
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public void arraySize(){
        Object[] newArray = new Object[array.length + array.length / 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
    }



    @Override
    public boolean add(Object o) {
        if (size == array.length) {
            arraySize();

        }
        array[size++] = (T) o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
         T[] arr = array;
        for (int j=size,  i = size = 0; i < j; i++)
            arr[i] = null;
    }

    @Override
    public T get(int index) {
        try {
            return (T) array[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public T set(int index, T element) {
        if (index >= array.length) {
            throw new IllegalArgumentException();
        } else {
            array[index] = element;
            return element;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            arraySize();
        }

        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;

    }

    @Override
    public T remove(int index) {
        Object temp = null;
        try {
            temp = array[index];
            array[index] = null;

        } catch (IndexOutOfBoundsException e) {

        }
        return (T) temp;
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
