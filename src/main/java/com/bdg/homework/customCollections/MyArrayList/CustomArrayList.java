package com.bdg.homework.customCollections.MyArrayList;
import java.util.*;
import java.util.function.UnaryOperator;

public class CustomArrayList implements List {

    private static final int DEFAULT_SIZE = 10;
    private int size = 0;
    private Integer[] array;

    public CustomArrayList() {
        array = new Integer[DEFAULT_SIZE];
    }

    public CustomArrayList(int myArrayListCapacity) {
        if (myArrayListCapacity < 0) {
            System.out.println("please make sure that your number is not under 0 ");
        }
        array = new Integer[myArrayListCapacity];
    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            return false;
        for (Integer i : array) {
            if (o.equals(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Integer value) {
        if (value == null)
            return false;
        for (Integer a : array) {
            if (value.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public Integer remove(int index) {
        int temp;
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        temp = array[index];
        array[index] = null;


        for (int i = index; i < size; i++) {

            array[index] = array[index++];
        }
        size--;
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o == array[i]) {
                    array[i] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean add(Object o) {
        if (o == null) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            addCapacity();
        }
        array[size++] = (Integer) o;
        return true;
    }

    private void addCapacity() {
        Object[] current = new Object[array.length + (array.length / 2)];
        array = (Integer[]) current;
    }

    public void add(int index, Object element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addCapacity();
        }

        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = (Integer) element;
        size++;

    }

    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o == array[i]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void replaceAll(UnaryOperator operator) {

    }

    public void sort(Comparator c) {

    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public void clear() {


    }


    public Object set(int index, Object element) {
        return null;
    }


    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public Spliterator spliterator() {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
