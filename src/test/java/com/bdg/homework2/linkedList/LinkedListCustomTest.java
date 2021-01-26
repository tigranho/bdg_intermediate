package com.bdg.homework2.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCustomTest {

    @Test
    public void addFirst(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        linkedListCustom.addFirst(1);
        Assert.assertEquals(1,linkedListCustom.size());
        Assert.assertEquals(1,(long)linkedListCustom.get(0));

    }
    @Test
    public void remove(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        linkedListCustom.addFirst(12);
        linkedListCustom.addFirst(13);
        Assert.assertEquals(2,linkedListCustom.size());
        linkedListCustom.remove(0);
        Assert.assertEquals(13,(long)linkedListCustom.get(0));



    }

    @Test
    public void get(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        linkedListCustom.addFirst(12);
        linkedListCustom.addFirst(13);
        Assert.assertEquals(12,(long)linkedListCustom.get(1));
    }

    @Test
    public void clear(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        linkedListCustom.addFirst(12);
        linkedListCustom.addFirst(13);
        linkedListCustom.clear();
        Assert.assertTrue(linkedListCustom.isEmpty());
    }

    @Test
    public void isEmpty(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        Assert.assertTrue(linkedListCustom.isEmpty());
        linkedListCustom.addFirst(12);
        linkedListCustom.addFirst(13);
        linkedListCustom.clear();
        Assert.assertTrue(linkedListCustom.isEmpty());
    }

    @Test
    public void size(){
        LinkedListCustom<Integer> linkedListCustom = new LinkedListCustom<>();
        Assert.assertEquals(0,linkedListCustom.size());
        linkedListCustom.addFirst(12);
        linkedListCustom.addFirst(13);
        Assert.assertEquals(2,linkedListCustom.size());
    }

}
