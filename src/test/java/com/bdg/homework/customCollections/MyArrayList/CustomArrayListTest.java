package com.bdg.homework.customCollections.MyArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {


    @Test
    public void isEmpty() {
        CustomArrayList list = new CustomArrayList();
        Assert.assertTrue(list.isEmpty());
        list.add(1);
        Assert.assertFalse(list.isEmpty());
        list.remove(0);
        Assert.assertTrue(list.isEmpty());

    }

    @Test
    public void size() {
        CustomArrayList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertTrue(list.size() == 4);

        list.remove(0);
        Assert.assertTrue(list.size() == 3);

    }

    @Test
    public void get() {
        CustomArrayList list = new CustomArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Assert.assertTrue( list.get(3)==4);
    }
    public void remove(){
        CustomArrayList list = new CustomArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


    }

}
