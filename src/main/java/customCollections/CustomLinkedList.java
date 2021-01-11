package customCollections;

import java.util.*;

public class CustomLinkedList<E> implements List<E> {

    private static class Node<E> {

        Node<E> previous;
        Node<E> next;
        E element;

        Node(Node<E> previous, E e, Node<E> next) {
            this.previous = previous;
            this.next = next;
            this.element = e;
        }
    }

    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    public boolean add(E e) {

        Node<E> current = last;
        Node<E> newNode = new Node<>(current, e, null);
        last = newNode;
        if (current == null) {
            first = newNode;
        } else {
            current.next = newNode;
            size++;
        }
        return true;

    }

    E unlink(Node<E> node) {

        E nodeElement = node.element;
        Node<E> next = node.next;
        Node<E> previous = node.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            node.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            node.next = null;
        }

        node.element = null;
        size--;
        return nodeElement;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> ll = first; ll != null; ll = ll.next) {
                if (ll.element == null) {
                    unlink(ll);
                    return true;
                }
            }
        } else {
            for (Node<E> ll = first; ll != null; ll = ll.next) {
                if (o.equals(ll.element)) {
                    unlink(ll);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean addAll(Collection<? extends E> c) {
        try {
            Object[] o = c.toArray();
            for (Object value : o) {
                add((E) value);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return true;
    }


    public void clear() {
        for (Node<E> ll = first; ll != null; ) {
            Node<E> next = ll.next;
            ll.element = null;
            ll.next = null;
            ll.previous = null;
            ll = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    Node<E> getNodeByIndex(int index) {

        Node<E> currentNode;

        if (index < size / 2) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;

            }
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }


    public E get(int index) {
        validateIndex(index);
        return getNodeByIndex(index).element;
    }

    public E set(int index, E element) {
        validateIndex(index);
        Node<E> currentNode = getNodeByIndex(index);
        E oldElement = currentNode.element;
        currentNode.element = element;
        return oldElement;

    }

    public E remove(int index) {
        validateIndex(index);
        return unlink(getNodeByIndex(index));
    }











    @Override
    public void add(int index, E element) {

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
    public boolean containsAll(Collection<?> c) {
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

}
