package com.bdg.collections.list.linkedlist;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

MyLinkedList<String> myLinkedList;

    @Before
   public void init (){
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add("A");
        myLinkedList.add("B");
        myLinkedList.add("C");
        myLinkedList.add("D");
    }

    @After
    public  void clear(){
        myLinkedList.clear();

    }

    @Test
    public  void testGet() {
        assertEquals("A",myLinkedList.get(0));
        assertEquals("B",myLinkedList.get(1));
        assertEquals("C",myLinkedList.get(2));
        assertEquals("D",myLinkedList.get(3));
    }
    @Test
    public  void testContains(){
        assertTrue(myLinkedList.contains("A"));
        assertFalse(myLinkedList.contains("H"));
    }

    @Test
    public  void testRemove(){
        assertEquals("B",myLinkedList.remove(1));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public  void testIndexOut(){
        myLinkedList.remove(5);
    }

    @Test
    public  void testAddByIndex(){
        myLinkedList.add(0,"a");
        assertEquals("a",myLinkedList.get(0));
    }



    @Test
    public void testIsEmpty() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        assertTrue(myLinkedList.isEmpty());
    }
    @Test
   public void testClear(){
        myLinkedList.clear();
        assertTrue(myLinkedList.isEmpty());
    }




}
