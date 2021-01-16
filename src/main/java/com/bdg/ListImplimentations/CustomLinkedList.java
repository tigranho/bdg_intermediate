package com.bdg.ListImplimentations;
import java.util.*;

public class CustomLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    private static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value){
            this.value=value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    @Override
    public boolean add(T t) {
        if(head==null){
            this.head = new Node<>(t);
            size++;
            return false;
        }
        Node temp = head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(t));
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        T result[] = (T[]) new Object[size];
        int index = 0;
        Node temp = head ;

        while(temp!=null){
            result[index++] = (T) temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }


    @Override
    public T get(int index) {
        int currentIndex = 0;
        Node temp = head;
        while(temp!=null){
            if(currentIndex == index){
                return (T) temp.getValue();
            }else{
                temp = temp.getNext();
                currentIndex++;
            }

        }
        throw new IllegalArgumentException();
    }

    @Override
    public T remove(int index) {
        int currentIndex = 0;
        Node temp = head;
        while(temp!=null){
            if ((currentIndex+1)==index){
                temp.setNext(temp.getNext().getNext());
                size--;
                break;
            }else{
               temp = temp.getNext();
               currentIndex++;
            }
        }

        return (T) temp.getValue();
    }


    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }



    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }





    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public boolean remove(Object o) {
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
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
