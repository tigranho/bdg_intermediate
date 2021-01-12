package com.bdg.homework.ArrayList;

import java.util.*;


public class ArrayList {

    private Integer[] array;

    ArrayList(){
        array = new Integer[default_size];
    }
    ArrayList(int ListCapacity){
        if (ListCapacity <= 0){
            System.out.print("ArrayList capacity must be greater than 0: ");
        }
        array = new Integer[ListCapacity];
        capacity = capacity;
    }

    public void add(Integer data){
        if(size == capacity){
            add_capacity();
        }
        array[size] = data;
        ++size;
    }

    public void add_capacity(){
        /*@qwerty*/
        Object[] current = new Object[array.length + (array.length / 2)];
        array = (Integer[]) current;
        /*@qwerty*/
    }

    public void add_at(int data, int index){
        if(index > size){
            return;
        }
        for (int i = size; i >= index; --i) {
            array[i + 1] = array[i];
        }
        array[index] = data;
        ++size;
    }

    public int get_size(){
        return size;
    }

    public Integer get(int index) {
        return array[index];
    }


    private int size = 0;
    private int capacity = 15;
    public static final int default_size = 15;

}
