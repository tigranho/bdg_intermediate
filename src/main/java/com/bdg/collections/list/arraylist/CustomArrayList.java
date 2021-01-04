package com.bdg.collections.list.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class CustomArrayList<E> implements List<E> {


    private E[] array;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public CustomArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * Parameters:
     * initialCapacity - the initial capacity of the list
     * Throws:
     * IllegalArgumentException - if the specified initial capacity is negative
     */
    public CustomArrayList(int arrayCapacity) {
        if (arrayCapacity < 0) {
            throw new IllegalArgumentException();
        }
        array = (E[]) new Object[arrayCapacity];

    }

    /**
     * Appends the specified element to the end of this list.
     * Specified by:
     * add in interface Collection<E>
     * Specified by:
     * add in interface List<E>
     * Overrides:
     * add in class AbstractList<E>
     * Parameters:
     * e - element to be appended to this list
     * Returns:
     * true (as specified by Collection.add(E))
     */

    @Override
    public boolean add(E e) {
        if (array.length <= size) {
            addCapacity();
        }
        array[size] = e;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * Specified by:
     * add in interface List<E>
     * Overrides:
     * add in class AbstractList<E>
     * Parameters:
     * index - index at which the specified element is to be inserted
     * element - element to be inserted
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public void add(int index, Object element) {
        if ((index < 0 || index > size())) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            addCapacity();
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = (E) element;

    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * Specified by:
     * set in interface List<E>
     * Overrides:
     * set in class AbstractList<E>
     * Parameters:
     * index - index of the element to replace
     * element - element to be stored at the specified position
     * Returns:
     * the element previously at the specified position
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E set(int index, Object val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index] = (E) val;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * Specified by:
     * get in interface List<E>
     * Specified by:
     * get in class AbstractList<E>
     * Parameters:
     * index - index of the element to return
     * Returns:
     * the element at the specified position in this list
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
     * Specified by:
     * remove in interface List<E>
     * Overrides:
     * remove in class AbstractList<E>
     * Parameters:
     * index - the index of the element to be removed
     * Returns:
     * the element that was removed from the list
     * Throws:
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E e = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        return e;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
     * Specified by:
     * remove in interface Collection<E>
     * Specified by:
     * remove in interface List<E>
     * Overrides:
     * remove in class AbstractCollection<E>
     * Parameters:
     * o - element to be removed from this list, if present
     * Returns:
     * true if this list contained the specified element
     */
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

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
     * Specified by:
     * contains in interface Collection<E>
     * Specified by:
     * contains in interface List<E>
     * Overrides:
     * contains in class AbstractCollection<E>
     * Parameters:
     * o - element whose presence in this list is to be tested
     * Returns:
     * true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (E e : array) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[size] = null;
        }
        size = 0;
    }


    private void addCapacity() {
        Object[] temp = new Object[array.length + (array.length / 2)];
        System.arraycopy(array, 0, temp, 0, size);
        array = (E[]) temp;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("CustomArrayList = " + "[");

        for (int i = 0; i < size; i++) {
            str.append(array[i]).append(",");
        }
        str.append("]");
        return str.toString();
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
    public <T> T[] toArray(T[] ts) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }


}
