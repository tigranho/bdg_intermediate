package com.bdg.homework2.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @param <E>
 * @author Ara Chilingaryan
 * This class provides custom implementation of ArrayList
 * Insertion order of objects is maintained.
 * Implementation allows you to store null as well.
 */

public class CustomArrayList<E> implements CustomList<E> {

    // Define INITIAL_CAPACITY, size of elements of custom ArrayList
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};

    /**
     * constructor of custom ArrayList
     */
    public CustomArrayList() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    @Override
    /**
     * add elements in custom/your own ArrayList
     * Method adds elements in ArrayListCustom.
     */
    public void add(E e) {
        if (size == elementData.length) {
            ensureCapacity(); // increase current capacity of list, make it
            // double.
        }
        elementData[size++] = e;
    }

    /**
     * Ensure capacity of custom/your own ArrayList.
     * <p>
     * Method increases capacity of list by making it double.
     */
    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    /**
     * method returns element on specific index.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        // if index is negative or greater than size of size, we throw
        // Exception.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (E) elementData[index]; // return value on index.
    }

    /**
     * remove elements from custom/your own ArrayList method returns
     * <p>
     * removedElement on specific index. else it throws IndexOutOfBoundException
     * if index is negative or greater than size of size.
     */
    public Object remove(int index) {
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

        return removedElement;
    }



    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        //modCount++;
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return this.elementData.length == 0;
    }

    /**
     * @return size of ArrayList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param o
     * @return true if customlist contains o, else returns false
     */
    @Override
    public boolean contains(Object o) {
       for(int i = 0; i < size;i++) {
           if(o.equals(elementData[i])) return true;
       }
        return false;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        // if index is negative or greater than size of size, we throw
        // Exception.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }
    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public boolean add(int index, E element) {
        // if index is negative or greater than size of size, we throw
        // Exception.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        // increase the size of the list if idx reaches the maximum limit
        if(size > elementData.length - 1)
        {
            ensureCapacity();
        }
        if(index < size)
        {
            // Prior to inserting the new element, move all the elements to next positions
            for(int temp = size+1; temp > index; temp--)
            {
                elementData[temp] = elementData[temp-1];
            }

            // insert the element
            elementData[index] = element;

            // as the new element is added, increment the idx value.
            size++;
        }
        else
        {
            // insert the element at the idx position
            elementData[size++] = element;
        }

        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
     * specified collection's Iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if((size + numNew) > this.size() ) {
            ensureCapacity();
        }
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }


}
