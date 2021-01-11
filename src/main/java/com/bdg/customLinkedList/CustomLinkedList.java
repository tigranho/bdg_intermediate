package com.bdg.customLinkedList;

import java.util.*;


/**
 * This class is a member of the Java Collections Framework LinkedList.
 * Author: Tigran Iskandaryan
 * Type parameters: <E> – the type of elements in this list
 */

public class CustomLinkedList<E> implements List<E>, Deque<E> {
    /**object who has link to next and prev*/
    Node<E> first;
    /**last object in linkedList*/
    Node<E> last;
    /**count of elements in linkedList*/
    private int size = 0;


    /**Inner class Node*/
    public class Node<E>{
        private E item;
        /**ref for next element in linkedList*/
        private Node<E> next;
        /**ref for previous element in linkedList*/
        private Node<E> prev;

        public Node(Node<E> prev,E element,Node<E> next) {
            this.next = next;
            this.item = element;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }
        public String toString(){
            return "Item = "+ item;
        }
    }

    /**empty linkedList constructor*/
    public CustomLinkedList(){

    }

    /**return count of elements in linkedList*/
    public int size() {
        return size;
    }

    /**return true if linkedList is empty*/
    public boolean isEmpty() {
        return size == 0;
    }

    /**Return true if Object o contains in list*/
    public boolean contains(Object o) {
        Node<E> x = first;
            for (int i = 0; i < size; i++) {
                if(x.item.equals(o)){
                    return true;
                }
                x = x.next;
            }
        return false;
    }


    /**add  element in linkedList on first position*/
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<E>(null,e,f);
        first = newNode;
        if(f == null){
            last = newNode;
        }
        else {
            f.prev = newNode;
        }
        size++;
    }

    /**add  element in linkedList on last position*/
    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l,e,null);
        last = newNode;
        if (l == null){
            first = newNode;
        }
        else {
            l.next = newNode;
        }
        size++;
    }

    /**add  element in linkedList*/
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**remove element from linkedList by object*/
    public boolean remove(Object o) {
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            if(x.equals(o) || x.item.equals(o)){
                if(x.prev == null){
                    removeFirst();
                }
                else if(x.next == null){
                    removeLast();
                }else{

                    Node<E> p = x.prev;
                    Node<E> n = x.next;
                    n.prev = x.prev;
                    p.next = x.next;
                    x = null;
                    size--;
                }
                return true;
            }
            x = x.next;
        }
        return false;
    }

    /**remove element from linkedList by index*/
    public E remove(int index) {
        E e = null;
        try {
            e = get(index);
            remove(e);
        }catch (IllegalArgumentException i){
            throw new IllegalAccessError("Illegal argument exception");
        }
        return e;
    }

    /**remove first element from linkedList*/
    public E removeFirst() {
        Node<E> x = first;
        first = x.next;
        size--;
        return (E)x;
    }

    /**remove last element from linkedList*/
    public E removeLast() {
        Node<E> x = last;
        last = x.prev;
        size--;
        return (E)x;
    }

    /**Delete all objects from list*/
    public void clear() {
        for(int i=0;i<5;i++) {
            remove(i);
        }
        size = 0;
        //first = null;
        //last = null;
    }


    /**Return object from list by index*/
    public E get(int index) {
        Node<E> x;
        if(index < (size >> 1)){
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        else {
            x = last;
            for (int i = size-1; i > index; i--) {
                x = x.prev;
            }
        }
        return (E)x;

    }





    ////////////////////




    public boolean offerFirst(E e) {
        return false;
    }

    public boolean offerLast(E e) {
        return false;
    }



    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
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

    public E set(int index, E element) {

        return null;
    }

    public void add(int index, E element) {

    }
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    public Iterator<E> iterator() {
        return null;
    }

    public Iterator<E> descendingIterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    public E getFirst() {
        return (E)first;
    }

    public E getLast() {
        return (E)last;
    }

    public E peekFirst() {
        return null;
    }

    public E peekLast() {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }
    public void push(E e) {}
    public E pop() {
        return null;
    }
    public E poll() {
        return null;
    }

    public E element() {
        return null;
    }

    public E peek() {
        return null;
    }


    public boolean offer(E e) {
        return false;
    }

    public E remove() {
        return null;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

}

