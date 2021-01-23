package com.bdg.test;

import customCollections.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CustomArrayListTest {

    @Test
    public void testArrayListInit() {
        CustomArrayList<String> arrayList = new CustomArrayList<>();
        Assert.assertTrue(arrayList.isEmpty());
        Assert.assertEquals(0, arrayList.size());

    }
    @Test
    public void testArrayListSize(){
        CustomArrayList<String> arrayList = new CustomArrayList<>();
        arrayList.add("test");
        Assert.assertNotEquals(0, arrayList.size());
    }

    @Test
    public void testIsEmpty(){
        CustomArrayList<String> arrayList = new CustomArrayList<>();
        arrayList.add("test");
        Assert.assertNotEquals(0, arrayList.size());
    }

    @Test
    public void testContains(){
        CustomArrayList<String> arrayList = new CustomArrayList<>();
        arrayList.add("test");
        Assert.assertTrue(arrayList.contains("test"));

    }

    @Test
    public void testAdd(){
        CustomArrayList<String> arrayList = new CustomArrayList<>();

        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");

        Assert.assertTrue(arrayList.contains("test3"));
        Assert.assertEquals("test3", arrayList.get(2));

        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test3");
        arrayList.add("test11");

        Assert.assertEquals("test11", arrayList.get(10));

    }

    @Test
    public void testClear() {
        CustomArrayList<String> arrayList = new CustomArrayList<>();

        arrayList.add("test");
        arrayList.add("test");
        arrayList.add("test");

        arrayList.clear();
        Assert.assertTrue(arrayList.size() == 0);

    }

    @Test
    public void testGet() {
        CustomArrayList<String> arrayList = new CustomArrayList<>();

        arrayList.add("test1");
        arrayList.add("test2");

        Assert.assertEquals("test2", arrayList.get(1));
    }

    @Test
    public void testSet() {
        CustomArrayList<String> arrayList = new CustomArrayList<>();

        arrayList.set(1, "test1");
        arrayList.set(4, "test2");
        Assert.assertEquals("test2", arrayList.get(4));
    }

    @Test
    public void testRemove() {
        CustomArrayList<String> arrayList = new CustomArrayList<>();

        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");

        arrayList.remove(1);

        Assert.assertEquals("test3", arrayList.get(1));


    }

}
