package com.bdg.test;

import com.bdg.secondhomework.CustomCollection.MyArrayList.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {
    @Test
    public void testIsEmpty() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Armenia");
        list.add("Germany");
        Assert.assertTrue(list.size() == 2);
    }

    @Test
    public void testSet(){
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Armenia");
        list.add("Germany");
        list.set(1,"Russia");
        Assert.assertEquals("Russia",list.get(1));
    }

    @Test
    public void testGet() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Moscow");
        list.add("Paris");
        Assert.assertEquals("Moscow", list.get(0));

    }

    @Test
    public void testAdd() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(11);
        list.add(111);
        Assert.assertTrue(list.size() == 3);


    }

    @Test
    public void testRemove(){
        CustomArrayList<Integer> list =new CustomArrayList<>();
        list.add(2);
        list.add(23);
        list.remove(1);
        Assert.assertTrue(list.size()==2);

    }

    @Test
    public void testContains() {
        CustomArrayList<Integer> list=new CustomArrayList<>();
        list.add(55);
        list.add(777);
        Assert.assertTrue(list.contains(55));

    }
    @Test
    public void testClear(){
        CustomArrayList<Integer> list =new CustomArrayList<>();
        list.add(12);
        list.add(34);
        list.add(56);
        list.clear();
        Assert.assertTrue(list.size()==0);

    }

}

