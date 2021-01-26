package com.bdg.homework2.arrayList;

import  org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayListTest {

    @Test
    public void isEmpty() {
        CustomList<Integer> testList = new CustomArrayList<>();
        Assert.assertTrue(testList.isEmpty());
        testList.add(1);
        Assert.assertFalse(testList.isEmpty());
        testList.remove(0);
        Assert.assertTrue(testList.isEmpty());
        Assert.assertEquals(0, testList.size());

    }

    @Test
    public void add() {
        CustomList<Long> testList = new CustomArrayList<>();
        testList.add(1L);
        testList.add(2L);
        testList.add(4L);
        Assert.assertEquals(1, (long) testList.get(0));
        Assert.assertEquals(2, (long) testList.get(1));
        Assert.assertEquals(4, (long) testList.get(2));

    }

    @Test
    public void get() {
        CustomList<Long> testList = new CustomArrayList<>();
        testList.add(1L);
        testList.add(2L);
        testList.add(4L);
        Assert.assertEquals(2L, (long) testList.get(1));
        Assert.assertEquals(2L, testList.remove(1));
        Assert.assertEquals(4L, (long) testList.get(1));

    }

    @Test
    public void remove() {
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        Exception exception = Assert.assertThrows(IndexOutOfBoundsException.class, () -> testList.get(5));
        Assert.assertEquals(2, testList.remove(1));
        Assert.assertEquals(4,testList.remove(1));
        Assert.assertEquals(1, testList.remove(0));
        Assert.assertTrue( testList.isEmpty());
        Assert.assertNotEquals(1, testList.size());
        Exception exception1 = Assert.assertThrows(IndexOutOfBoundsException.class, () -> testList.get(0));

    }

    @Test
    public void clear() {
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.clear();
        Assert.assertTrue( testList.isEmpty());
        Assert.assertEquals(0, testList.size());

    }

    @Test
    public void size(){
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        Assert.assertEquals(3, testList.size());
        testList.add(5);
        Assert.assertEquals(4, testList.size());
        testList.remove(0);
        Assert.assertEquals(3, testList.size());
        testList.clear();
        Assert.assertEquals(0, testList.size());


    }

    @Test
    public void contains(){
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        Assert.assertTrue(testList.contains(1));
        Assert.assertTrue(testList.contains(2));
        Assert.assertTrue(testList.contains(4));
        testList.remove(0);
        Assert.assertFalse(testList.contains(1));
        Assert.assertTrue(testList.contains(2));

    }

    @Test
    public void set(){
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.set(0,24);
        Assert.assertEquals(24, (long)testList.get(0));
        testList.set(1,25);
        Assert.assertEquals(25, (long)testList.get(1));

    }

    @Test
    public void addBoolean(){
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        Assert.assertEquals(3,testList.size());
        testList.add(0,7);
        Assert.assertEquals(7, (long)testList.get(0));
        Assert.assertEquals(1, (long)testList.get(1));
        Assert.assertEquals(2, (long)testList.get(2));
        Assert.assertEquals(4, (long)testList.get(3));
        Assert.assertEquals(4,testList.size());

    }

    @Test
    public void addAll(){
        CustomList<Integer> testList = new CustomArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        List<Integer> testList1 = new ArrayList<>();
        testList1.add(4);
        testList1.add(5);
        testList1.add(6);
        testList.addAll(testList1);
        Assert.assertEquals(6,testList.size());

    }
}
