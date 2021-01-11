package com.bdg.generic.list;

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


    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
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

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
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



    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param value element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     )
     */
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


    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
         */
    public void clear() {
        this.array = null;
    }



    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        return array[index];
    }


    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     */
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

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     */
    public void add(int index, E element) {
        if (array != null && element != null) {
            for (int i = 0; i < this.size; i++) {
                if (size == this.array.length) {
                    this.copy(this.array);
                } else if (index == i) {
                    this.array[index] = element;
                    size++;
                }
            }
        }
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position

     */
    public E remove(int index) {
        int count = 0;
        if (this.array != null) {
            E[] temp = (E[]) new Object[this.array.length - 1];
            for (int i = 0; i < size; i++) {
                if (index != i) {
                    temp[count++] = this.array[i];
                }
            }
            size -= 1;
            this.array = temp;
        }

        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param value element to search for
     *
     */
    public int indexOf(Object value) {
        if (this.array != null && value != null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(value)) {
                    return i;
                }
            }
        }
        return 0;
    }


    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
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
