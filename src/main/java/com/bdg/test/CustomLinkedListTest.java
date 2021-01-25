package com.bdg.test;

import com.bdg.secondhomework.CustomCollection.MyLinkedList.CustomLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {


    @Test
    public void testLinkedListSize(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(123);
        Assert.assertTrue(list.size()==1);
    }

    @Test
    public  void testLinkedListAdd(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(345);
        list.add(678);
        list.add(814);
        Assert.assertTrue((list.size()==3));
    }

    @Test
    public void testLinkedListIsEmpty(){
        CustomLinkedList<String> list=new CustomLinkedList<>();
        list.add("asd");
        list.add("qwe");
        Assert.assertFalse(list.isEmpty());

    }



}
