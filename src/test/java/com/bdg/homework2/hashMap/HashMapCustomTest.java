package com.bdg.homework2.hashMap;

import org.junit.Assert;
import org.junit.Test;

public class HashMapCustomTest {
    @Test
    public void sizeTest(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        Assert.assertEquals(0,mapCustom.size());
        mapCustom.put(1,1);
        mapCustom.put(2,2);
        mapCustom.put(3,3);
        Assert.assertEquals(3,mapCustom.size());
        mapCustom.clear();
        Assert.assertEquals(0,mapCustom.size());
    }

    @Test
    public void isEmpty() {
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        Assert.assertTrue(mapCustom.isEmpty());
        mapCustom.put(1,1);
        mapCustom.put(2,2);
        mapCustom.put(3,3);
        mapCustom.clear();
        Assert.assertTrue(mapCustom.isEmpty());
    }

    @Test
    public void clear() {
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        Assert.assertTrue(mapCustom.isEmpty());
        mapCustom.put(1,1);
        mapCustom.put(2,2);
        mapCustom.put(3,3);
        mapCustom.clear();
        Assert.assertEquals(0,mapCustom.size());
    }

    @Test
    public void containsKey(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        mapCustom.put(1,1);
        mapCustom.put(2,2);
        mapCustom.put(3,3);
        Assert.assertTrue(mapCustom.containsKey(1));
        Assert.assertTrue(mapCustom.containsKey(2));
        Assert.assertTrue(mapCustom.containsKey(3));
        mapCustom.clear();
        Assert.assertFalse(mapCustom.containsKey(1));

    }

    @Test
    public  void containsValue(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        mapCustom.put(1,16);
        mapCustom.put(2,28);
        mapCustom.put(3,39);
        Assert.assertTrue(mapCustom.containsValue(28));
        Assert.assertTrue(mapCustom.containsValue(16));
        Assert.assertTrue(mapCustom.containsValue(39));
        mapCustom.clear();
        Assert.assertFalse(mapCustom.containsValue(39));

    }

    @Test
    public void put(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        mapCustom.put(1,16);
        mapCustom.put(2,28);
        mapCustom.put(3,39);
        Assert.assertEquals(16,(long)mapCustom.get(1));
        mapCustom.put(1,17);
        Assert.assertEquals(17,(long)mapCustom.get(1));
        mapCustom.put(4,50);
        Assert.assertEquals(50,(long)mapCustom.get(4));

    }

    @Test
    public  void get(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        mapCustom.put(1,16);
        mapCustom.put(2,28);
        mapCustom.put(3,39);
        Assert.assertEquals(16,(long)mapCustom.get(1));

    }

    @Test
    public void remove(){
        MapCustom<Integer, Integer> mapCustom = new HashMapCustom<>();
        mapCustom.put(1,16);
        mapCustom.put(2,28);
        mapCustom.put(3,39);
        mapCustom.remove(1);
        mapCustom.remove(2);
        mapCustom.remove(3);
        Assert.assertEquals(0,mapCustom.size());

    }






}
