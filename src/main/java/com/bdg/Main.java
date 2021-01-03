package com.bdg;


import CustomDataStructures.CustomArrayList;

/**
 * @author Ruzanna
 */


public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> arr = new CustomArrayList<>(2);
        System.out.println(arr);
        arr.add(null);
        System.out.println(arr);
    }

}
