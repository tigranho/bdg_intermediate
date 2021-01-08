package Custom;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class  CustomLinkedList<E>  implements List<E> {

    private static int counter;
    private Node head;

     public  CustomLinkedList(){

     }


      class Node<E> {

        Object data;
        Node<E> next;

        Node(Object dataValue)
        {
            data = dataValue;
            next = null;
        }

        Node(Object dataValue,Node nextValue){
            data=dataValue;
            next=nextValue;
        }

         public Object getData() {
             return data;
         }

         public void setData(Object data) {
             this.data = data;
         }

         public Node<E> getNext() {
             return next;
         }

         public void setNext(Node<E> next) {
             this.next = next;
         }
     }



    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter==0;
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
    public boolean add(E e) {
        return false;
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

    if (index < 0)
            return null;
    Node crunchifyCurrent = null;
		if (head != null) {
        crunchifyCurrent = head.getNext();
        for (int i = 0; i < index; i++) {
            if (crunchifyCurrent.getNext() == null)
                return null;

            crunchifyCurrent = crunchifyCurrent.getNext();
        }
        return (E)crunchifyCurrent.getData();
    }
		return (E)crunchifyCurrent;

}

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        Node crunchifyTemp = new Node(element);
        Node crunchifyCurrent = head;

        if (crunchifyCurrent != null) {
            for (int i = 0; i < index && crunchifyCurrent.getNext() != null; i++) {
                crunchifyCurrent = crunchifyCurrent.getNext();
            }
        }


        crunchifyTemp.setNext(crunchifyCurrent.getNext());
        crunchifyCurrent.setNext(crunchifyTemp);


        incrementCounter();

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

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }
}
