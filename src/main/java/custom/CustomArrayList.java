package custom;

import java.util.*;

class Main{
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);


      list.remove(2);
        System.out.println(list);

        System.out.println( list.get(0) );
        System.out.println( list.get(1) );


       System.out.println(list.size());
       list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());

    }
}

public    class CustomArrayList<E>  implements List<E> {
    private int size=0;
    private static final  int default_capacity=10;
    private E elements[];
   private Object emp_arr[]= {};

    public CustomArrayList(){
        elements=(E[])new Object[default_capacity];
    }


    public  CustomArrayList( int capacity){
        if(capacity>0){
            elements=(E[])new Object[default_capacity];}
        else if(capacity==0){
            elements=(E[])emp_arr;
        }else{
            throw new IllegalArgumentException("Illegal capasity");
        }
    }



    @Override
    public boolean add(E e) {
        if(size==elements.length){
            ensureCapacity();
        }
        elements[size++] = e;

        return true;
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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        boolean a=indexOf(o)==-1;
        return !a;
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
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (E) item;
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
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

        elements = (E[]) new Object[default_capacity];
        size=0;
    }

    @Override
    public E get(int index) {
        if(index>size || index<0){
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        if(index<0 || index>size) {
            System.out.println("wrong argument");
            return false;
        }
        elements[index] = (E) element;
        return true;
    }

    @Override
    public void add(int index, Object element) {

    }
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override public String toString(){
        String tmp = "{";
        for(Object t :elements){
            if(t==null)
                break;
            tmp+= ""+t.toString()+",";
        }
        tmp+="}";
        return tmp;
    }
}
