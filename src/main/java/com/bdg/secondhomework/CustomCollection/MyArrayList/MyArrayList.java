package com.bdg.secondhomework.CustomCollection.MyArrayList;

import java.util.ArrayList;

public class MyArrayList {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(2);
        customArrayList.add(5);
        customArrayList.add(4);
        customArrayList.add(2);

        System.out.println(customArrayList.get(2));
        customArrayList.set(2,6);
        System.out.println(customArrayList.get(2));
        customArrayList.clear();
        System.out.println(customArrayList.get(3));











    }
}