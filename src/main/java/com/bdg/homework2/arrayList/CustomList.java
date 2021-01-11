package com.bdg.homework2.arrayList;

import java.util.Collection;

public interface CustomList<E> {
     /**
      * add elements in custom/your own ArrayList
      * Method adds elements in ArrayListCustom.
      */
     void add(E e);

     /**
      * remove elements from custom/your own ArrayList method returns
      * <p>
      * removedElement on specific index. else it throws IndexOutOfBoundException
      * if index is negative or greater than size of size.
      */
     Object remove(int index);

     /**
      * method returns element on specific index.
      */
     E get(int index);

     /**
      * Removes all of the elements from this list.  The list will
      * be empty after this call returns.
      */
     void clear();
     /**
      * Returns {@code true} if this list contains no elements.
      *
      * @return {@code true} if this list contains no elements
      */
     boolean isEmpty();
     /**
      * Returns the number of elements in this list.  If this list contains
      * more than {@code Integer.MAX_VALUE} elements, returns
      * {@code Integer.MAX_VALUE}.
      *
      * @return the number of elements in this list
      */
     int size();

     /**
      * @param o
      * @return true if customlist contains o, else returns false
      */
     boolean contains(Object o);

     /**
      * Replaces the element at the specified position in this list with
      * the specified element.
      *
      * @param index   index of the element to replace
      * @param element element to be stored at the specified position
      * @return the element previously at the specified position
      * @throws IndexOutOfBoundsException {@inheritDoc}
      */
     E set(int index, E element);// the same method as replace


     /**
      * Appends all of the elements in the specified collection to the end of
      * this list, in the order that they are returned by the
      * specified collection's Iterator.  The behavior of this operation is
      * undefined if the specified collection is modified while the operation
      * is in progress.  (This implies that the behavior of this call is
      * undefined if the specified collection is this list, and this
      * list is nonempty.)
      *
      * @param c collection containing elements to be added to this list
      * @return <tt>true</tt> if this list changed as a result of the call
      * @throws NullPointerException if the specified collection is null
      */
     boolean addAll(Collection<? extends E> c);


     /**
      * Inserts the specified element at the specified position in this
      * list. Shifts the element currently at that position (if any) and
      * any subsequent elements to the right (adds one to their indices).
      *
      * @param index index at which the specified element is to be inserted
      * @param element element to be inserted
      * @throws IndexOutOfBoundsException {@inheritDoc}
      */
     boolean add(int index, E element);


}
