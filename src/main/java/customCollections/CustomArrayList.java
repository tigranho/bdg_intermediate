package customCollections;

import java.util.*;

public class CustomArrayList<E> implements List<E> {

    private E[] objects;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;


    CustomArrayList() {
        objects = (E[]) new Object[INITIAL_CAPACITY];
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        for (Object object : objects) {
            if (o.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Object o) {
        if (size == objects.length) {
            grow();
        }
        objects[size++] = (E) o;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        while (c.size() > objects.length) {
            grow();
        }
        Object[] newObjects = c.toArray();
        return true;
    }


    public void clear() {
        objects = null;

    }


    public E get(int index) {
        try {
            return (E) objects[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }

    }


    public E set(int index, E element) {
        if (index >= objects.length) {
            throw new IllegalArgumentException();
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


    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (index >= objects.length) {
            grow();
        }
        Object temp;
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
