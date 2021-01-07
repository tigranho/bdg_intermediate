package CustomDataStructures;


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


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override

    public boolean contains(Object o) {
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

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (size != 0 && !(o.getClass().isAssignableFrom(lastNode.element.getClass()))) {
            throw new ClassCastException();
        }
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (o.equals(currentNode.element)) {
                if(currentNode.prevReference == null){
                    firstNode = currentNode.nextReference;
                } else {
                    currentNode.prevReference.nextReference = currentNode.nextReference;
                }
                size--;
                return true;
            }
            currentNode = currentNode.nextReference;
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

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
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

    public void toPrint() {
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.element);
            currentNode = currentNode.nextReference;
        }
    }
}
