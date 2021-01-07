package com.bdg.custom_collections;

import java.util.*;

/**
 * @param <E>
 * @author Artur
 * This class provides custom implementation of ArrayList
 * Insertion order of objects is maintained.
 * Implementation allows you to store null as well.
 */

class ArrayListCustom<E> implements List<E> {
    // Define DEFAULT_CAPACITY, size of elements of custom ArrayList
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elementData = {};

    /**
     * Constructor of custom ArrayList.
     */
    public ArrayListCustom() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListCustom(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    /**
     * Returns the number of elements in this ArrayListCustom.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this ArrayListCustom contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this ArrayListCustom contains the specified element.
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (E e : (E[]) elementData) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
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

    /**
     * Add elements in custom own ArrayListCustom.
     * Method adds elements in ArrayListCustom.
     */
    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
        return true;
    }

    /**
     * Ensure capacity of custom own ArrayListCustom.
     * Method increases capacity of ArrayListCustom by making it double.
     */
    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    /**
     * Removes the first occurrence of the specified element from this ArrayListCustom, if it is present.
     */
    @Override
    public boolean remove(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o == elementData[i]) {
                    elementData[i] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
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

    /**
     * Removes all of the elements from this ArrayListCustom.
     */

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    /**
     * Method returns element on specific index.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (E) elementData[index];
    }

    /**
     * Replaces the element at the specified position in this ArrayListCustom with the specified element.
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) (elementData[index] = (E) element);
        }
    }

    /**
     * Inserts the specified element at the specified position in this ArrayListCustom.
     */
    @Override
    public void add(int index, E element) {
        if (index > size || index < 0)
            if (size == elementData.length) {
                ensureCapacity();
            }
        for (int i = size; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        size++;
        elementData[index] = (E) element;
    }

    /**
     * Remove elements from custom own ArrayListCustom method returns
     * removedElement on specific index. else it throws IndexOutOfBoundException
     * If index is negative or greater than size of size.
     */
    @Override
    public E remove(int index) {
        // if index is negative or greater than size of size, we throw
        // Exception.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--; // reduce size of ArrayListCustom after removal of element.

        return (E) removedElement;
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
