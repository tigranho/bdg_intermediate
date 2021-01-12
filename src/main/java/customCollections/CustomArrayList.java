package customCollections;

import java.util.*;

/**
 * Resizable-array implementation of the List interface.
 * Not synchronized.
 * @param <E> the type of elements in this list which is instance of Object class
 * @author Tigran
 */
public class CustomArrayList<E> implements List<E> {

    private E[] objects;
    private int size = 0;

    private static final int INITIAL_CAPACITY = 10;


    public CustomArrayList() {
        objects = (E[]) new Object[INITIAL_CAPACITY];
    }

    public CustomArrayList(int initialSize){
        if (initialSize > 0){
            this.objects = ((E[])new Object[initialSize]);
        }else if (initialSize == 0){
            this.objects = ((E[]) new Object[INITIAL_CAPACITY]);
        }else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns number of elements in the list.
     * @return size.
     */
    public int size() {
        return size;
    }


    /**
     * Checks if lise is empty or not.
     * @return {@code true} if list has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Checks if list contains given param
     * @param o element presence of which is to be checked
     * @return {@code true} if list contains param.
     */
    public boolean contains(Object o) {
        for (Object object : objects) {
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Appends given param to the end of the list.
     * @param o element to be appended
     * @return true (as specified by {@link Collection.add})
     */
    public boolean add(Object o) {
        if (size == objects.length) {
            grow();
        }
        objects[size++] = (E) o;
        return true;
    }

    /**
     * Appends all of the given collections' elements to the end of the list
     * @param c collection that contains elements to be appended
     * @return if the list has ben changed after the call
     * @throws NullPointerException if the given collection is null
     */
    public boolean addAll(Collection<? extends E> c) {
        if (c == null ){
            throw new NullPointerException();
        }
        if (c.size() > objects.length) {
            grow();
        }
        Object[] newObjects = c.toArray();
        return true;
    }


    /**
     * Removes all the elements from the list and makes it empty.
     */
    public void clear() {

        for (int i = 0; i <size ; i++) {
            objects[i] = null;
            size = 0;
        }

    }

    /**
     * Returns element in the given index.
     * @param index the index of the element to be returned.
     * @return element at the given param.
     * @throws IndexOutOfBoundsException if {@code index>size || index<0}
     */
    public E get(int index) {
        try {
            return (E) objects[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * Replaces the element in given position with specified element.
     * @param index - index of the element to be replaced.
     * @param element - element to be placed in given position.
     * @return element that had been replaced.
     * @throws IndexOutOfBoundsException if {@code (index>=objects.length || index<0)}
     */
    public E set(int index, E element) {
        if (index >= objects.length || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            objects[index] = element;
            return element;
        }
    }

    private void grow() {

        Object[] newObjects = new Object[objects.length + objects.length / 2];
        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = objects[i];
        }
        objects = (E[]) newObjects;
        newObjects = null;
    }


    /**
     * Inserts given element at specified position. Shifts the element
     * currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     * @param index - index where given element is be placed.
     * @param element - element to be placed.
     * @throws IndexOutOfBoundsException if {@code (index<0 || index>=size)}
     */
    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newObjects = new Object[objects.length];
        for (int i = 0; i < objects.length; i++) {
            if (index > i) {
                newObjects[i] = objects[i];
            } else if (index == i) {
                newObjects[index] = element;
            } else {
                newObjects[i] = objects[i - 1];
            }
            objects = (E[]) newObjects;
        }

    }

    /**
     * Removes element at given position and shifts next(if any)
     * and all subsequent elements to the left (subtracts one from their indicies)
     * @param index - position of the element to be removed
     * @return - element that has been removed
     * @throws IndexOutOfBoundsException if {@code (index >= objects.length)}
     */
    public E remove(int index) {

        Object dummy;

        if (index >= objects.length) {
            throw new IndexOutOfBoundsException();
        } else if (index == objects.length - 1) {
            dummy = objects[index];
            objects[index] = null;
        } else {
            dummy = objects[index];
            for (int i = index; i < objects.length; i++) {
                objects[index] = objects[index + 1];
            }
        }
        return (E) dummy;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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

}
