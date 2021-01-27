package com.bdg.collections.map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomHashMapTest {

    CustomHashMap<Integer, String> customHashMap;


    @Before
    public void init() {
        customHashMap = new CustomHashMap<>();
        customHashMap.put(1, "A");
        customHashMap.put(2, "B");
        customHashMap.put(3, "C");
        customHashMap.put(4, "D");
    }

    @After
    public void clear() {
        customHashMap.clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomArrayListConstructor() {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>(-1);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(customHashMap.isEmpty());
    }

    @Test
    public void testGet() {
        assertEquals("A", customHashMap.get(1));
        assertEquals("B", customHashMap.get(2));
        assertEquals("C", customHashMap.get(3));
        assertEquals("D", customHashMap.get(4));
    }


    @Test
    public void remove() {
        assertEquals("A", customHashMap.remove(1));
    }

    @Test
    public void testClear() {
        customHashMap.clear();
        assertTrue(customHashMap.isEmpty());
    }


}
