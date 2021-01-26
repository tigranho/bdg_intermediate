package customDataStructures;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<E> implements List<E> {

    private static class Node<E> {

        Node<E> prevReference;
        Node<E> nextReference;
        E element;

        Node(Node prevReference, Node nextReference, E e) {
            this.prevReference = prevReference;
            this.nextReference = nextReference;
            element = e;

        }

    }

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
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
     * Appends the specified element to the end of this list.
     *
     * @param a element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(E a) {
        if (a == null) {
            throw new NullPointerException();
        }
        Node<E> currentNode = lastNode;
        Node<E> node = new Node<>(currentNode, null, a);
        lastNode = node;
        if (currentNode == null) {
            firstNode = node;
        } else {
            currentNode.nextReference = node;
        }
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null || c.contains(null)) {
            throw new NullPointerException();
        }
        Object[] o = c.toArray();
        for (int i = 0; i < o.length; i++) {
            add((E) o[i]);
        }
        return true;
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
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            Node<E> nextNode = currentNode.nextReference;
            currentNode.prevReference = null;
            currentNode.nextReference = null;
            currentNode = nextNode;
        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = firstNode;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.nextReference;
            }
        } else {
            currentNode = lastNode;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prevReference;
            }
        }
        return currentNode;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).element;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<E> currentNode;
        E oldElement;
        checkIndex(index);
        currentNode = getNodeByIndex(index);
        oldElement = currentNode.element;
        currentNode.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {

    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> currentNode = getNodeByIndex(index);
        currentNode.prevReference.nextReference = currentNode.nextReference;
        currentNode.nextReference.prevReference = currentNode.prevReference;
        size--;
        return currentNode.element;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (size != 0 && !(o.getClass().isAssignableFrom(lastNode.element.getClass()))) {
            throw new ClassCastException();
        }

        int index = 0;
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(o)) {
                return index;
            }
            index++;
            currentNode = currentNode.nextReference;
        }
        return -1;
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            str.append("LinkedList is Empty");
        } else {
            Node currentNode = firstNode;
            while (currentNode != null) {
                str.append(currentNode.element);
                str.append(" ");
                currentNode = currentNode.nextReference;
            }
        }
        return str.toString();
    }
}
