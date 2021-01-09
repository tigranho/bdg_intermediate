package com.bdg.costomArrayList;
import java.util.*;

/**
 * This class is a member of the Java Collections Framework.
 * Author: Tigran Iskandaryan
 * Type parameters: <E> – the type of elements in this list
 */

public class CustomArrayList<E> implements List<E> {
    /** create Object[] array link*/
    private  Object[] elementData ;
    /** default capacity of array */
    private static final int DEFAULT_CAPACITY = 10;
    /** count of elements in array */
    private int size=0;
    /** max count of elements in array */
    private int maxCapacity;

    /**
     * Constructs an empty list with the specified initial capacity.
     * Params: initialCapacity – the initial capacity of the list
     * Throws: IllegalArgumentException – if the specified initial capacity is negative
     * */
    public CustomArrayList(int initialCapacity) {
        if(initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = new Object[DEFAULT_CAPACITY];
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity : " + initialCapacity);
        }
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     * */
    public CustomArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Return size of array
     * */
    public int size() {
        return size;
    }

    /**
     * Return true if size == 0
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return true if array contain this object
     * */
    public boolean contains(Object o) {
        for (Object object: elementData
             ) {
            if(o.equals(object)){
                return true;
            }
        }
        return false;

    }


    /**
     * return max capacity of array
     * */
    private int maxCapacity(){
       return maxCapacity = elementData.length - 5;
    }


    /**
     * grow() create new array with [elementData.length+DEFAULT_CAPACITY] size
     * */
    private void grow(){
        Object[] newElementData = new Object[elementData.length+DEFAULT_CAPACITY];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        //newElementData = elementData.clone();
        elementData = newElementData;
    }


    /**
     * growWithDefaultCapacity() create new array with [elementData.length+DEFAULT_CAPACITY] size
     * */
    private void grow(int capacity){
        Object[] newElementData = new Object[elementData.length+DEFAULT_CAPACITY+capacity];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

    /**
     * add(Object o) method,,,It's return true if object was add
     * */
    public boolean add(Object o) {
        if(size == maxCapacity()) {
            grow();
        }
        elementData[size] = o;
        ++size;
        return true;
    }




    /**Add collection in list*/
    public boolean addAll(Collection c) {
        if(c.size() >= maxCapacity()-size) {
            grow(c.size());
        }
        Object[] a = c.toArray();
        System.arraycopy(a,0,elementData,a.length,a.length);
        return true;
    }


    /**Clear all elements from list*/
    public void clear() {
        elementData = null;
    }


    /**Return object from list by index*/
    public E get(int index) {
        try{
            return (E)elementData[index];
        }
        catch (IllegalArgumentException i){
             throw new IllegalArgumentException("Dont find this index");
        }
    }

    /**Set object in list by index*/
    public Object set(int index, Object element) {
        if(index < elementData.length){
             elementData[index] = element;
             return element;
        }
        else{
            throw new IllegalArgumentException("Dont find this index");
        }
    }


    /**Remove object from list by index*/
    public E remove(int index) {
        Object temp = null;
        try{
           temp =  elementData[index];
           elementData[index] = null;

        }
        catch (IllegalArgumentException i){
             System.out.println("Dont find this index");
        }
        return (E) temp;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }
    public boolean remove(Object o) {
        return false;
    }
    public Object[] toArray(Object[] a) {
        return null;
    }

    public Iterator<E> iterator() {

        return null;
    }
    public void add(int index, Object element) {

    }
    public boolean addAll(int index, Collection c) {
        return false;
    }
    public Object[] toArray() {
        return new Object[0];
    }
}
