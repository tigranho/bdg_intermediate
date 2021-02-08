package com.bdg.collections.and.map.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    public CustomArrayList<String> customArrayList() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("addElement1");
        list.add("addElement2");
        list.add("addElement3");
        return list;
    }

    @Test
    public void addElement() {
        Assertions.assertTrue(customArrayList().add("addElement1"));
        Assertions.assertTrue(customArrayList().add("addElement1"));
    }

    @Test
    public  void removeElement(){
        Assertions.assertTrue(customArrayList().remove("addElement1"));
        Assertions.assertFalse(customArrayList().remove("removeElement"));
    }

    @Test
    public  void  checkSize(){
        Assertions.assertNotEquals(customArrayList().size(), 0);
        Assertions.assertEquals(customArrayList().size(),3);
    }
    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }
}