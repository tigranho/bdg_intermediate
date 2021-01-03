package com.bdg;


import CustomDataStructures.CustomArrayList;

/**
 * @author Ruzanna
 */


public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> arr = new CustomArrayList<Integer>(2);
        System.out.println(arr);
        arr.add(10);
        arr.add(15);
        arr.add(5);
        System.out.println(arr);
        System.out.println(arr.contains(7));
        System.out.println(arr);
        arr.remove((Object) 15);
        System.out.println(arr);
    }

}
