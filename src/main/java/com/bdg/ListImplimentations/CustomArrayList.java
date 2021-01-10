package com.bdg.ListImplimentations;

import java.util.*;

public  class CustomArrayList<T> implements List<T> {
    private int size =0;
    private  T elements [] ;
    private static final int DEFAULT_CAPACITY = 10;


    CustomArrayList(){
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(Object o) {
        if(size==elements.length){
            ensureCapacity();
        }
        elements[size++] = (T) o;
        return true;
    }

    private void ensureCapacity(){
        int newSize = elements.length+10;
        elements = Arrays.copyOf(elements,newSize);
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public boolean isEmpty() {
        if(size<=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0;i<size;i++){
            if(elements[i].equals(o))
                return true;
        }
        return false;
    }


    @Override
    public T get(int index) {
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
            return elements[index];

    }

    @Override
    public Object set(int index, Object element) {
        if(index<0||index>size) {
            System.out.println("wrong argument");
            return false;
        }
        elements[index] = (T) element;
        return true;
    }

    @Override public String toString(){
        String tmp = "{ ";
        for(T t :elements){
            if(t==null)
                break;
            tmp+=t.toString()+", ";
        }
        tmp+="}";
        return tmp;
    }

    @Override
    public T remove(int  index) {
        T removeItem = elements[index];
        for (int i=index;i<size;i++){
            elements[i]=elements[i+1];
        }
        size--;
        return removeItem;
    }
    @Override
    public void clear() {
        size=0;
        elements = (T[]) new Object[DEFAULT_CAPACITY];

    }













    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }



    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }



    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void add(int index, Object element) {

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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }


    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

        Random random = new Random();

        for(int i=0;i<12;i++){
            customArrayList.add(random.nextInt(100));
        }
        System.out.println(customArrayList);
        System.out.println(customArrayList.size);
       // customArrayList.clear();
        System.out.println(customArrayList.contains(15));


    }
}


