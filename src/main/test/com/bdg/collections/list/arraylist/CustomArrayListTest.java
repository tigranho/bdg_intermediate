package com.bdg.collections.list.arraylist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListTest {

    CustomArrayList<String> customArrayList;


    @Test(expected = IllegalArgumentException.class)
    public void testCustomArrayListConstructor() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>(-1);
    }

    @Before
    public void init() {
        customArrayList = new CustomArrayList<>();
        customArrayList.add("A");
        customArrayList.add("B");
        customArrayList.add("C");
        customArrayList.add("D");
    }

    @Test
    public void testCustomArrayListInit() {
        assertFalse(customArrayList.isEmpty());
        assertFalse(customArrayList.size() == 0);
    }

    @Test
    public  void testCustomArrayListContain(){
        assertTrue(customArrayList.contains("A"));
    }

    @Test
    public void testCustomArrayListClear() {
        customArrayList.clear();
        assertTrue(customArrayList.isEmpty());
        assertTrue(customArrayList.size() == 0);
    }
    @Test
    public  void testCustomArrayListRemove() {
        assertTrue(customArrayList.remove("A"));
        assertFalse(customArrayList.contains("A"));
    }

        @Test
        public  void testCustomArrayListRemoveIndex(){
            assertEquals("A",customArrayList.remove(0));
            assertFalse(customArrayList.contains("A"));


    }

    @After
    public void clear() {
        customArrayList.clear();
    }

    @Test
    public void testCustomListGet() {

        assertEquals("A", customArrayList.get(0));
        assertEquals("B", customArrayList.get(1));
        assertEquals("C", customArrayList.get(2));
        assertEquals("D", customArrayList.get(3));
    }
}
