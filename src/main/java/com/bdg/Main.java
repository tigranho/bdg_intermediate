package com.bdg;


import CustomDataStructures.CustomArrayList;
import CustomDataStructures.CustomLinkedList;

import java.util.ArrayList;

/**
 * @author Ruzanna
 */


public class Main {
    public static void main(String[] args) {
        //CustomArrayList Testing
        CustomArrayList<Integer> arr = new CustomArrayList<>(2);
        System.out.println("*********************************************");
        System.out.println("Elements are: " + arr);
        System.out.println("Array size is: " + arr.size());
        System.out.println("Number 15 contains in array: " + arr.contains(15));
        System.out.println("*********************************************");
        arr.add(10);
        arr.add(15);
        arr.add(1, 5);
        arr.add(0, 9);
        System.out.println("Elements are: " + arr);
        System.out.println("Array size is: " + arr.size());
        System.out.println("Number 15 contains in array: " + arr.contains(15));
        System.out.println("*********************************************");
        System.out.println("Element successfully removed: " + arr.remove(Integer.valueOf(15)));
        System.out.println("Elements are: " + arr);
        System.out.println("*********************************************");
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(6);
        arr2.add(18);
        arr.addAll(arr2);
        System.out.println("Elements are: " + arr);
        System.out.println("Array size is: " + arr.size());
        System.out.println("*********************************************");
        arr.clear();
        System.out.println("Elements are: " + arr);
        System.out.println("*********************************************");
        arr.addAll(arr2);
        System.out.println("Elements are: " + arr);
        System.out.println("Array size is: " + arr.size());
        System.out.println("*********************************************");
        System.out.println("Element with index 1 is: " + arr.get(1));
        System.out.println("*********************************************");
        System.out.println("Elements are: " + arr);
        System.out.println("Which element is changed: " + arr.set(0, 10));
        System.out.println("Elements are: " + arr);
        System.out.println("*********************************************");


        //CustomLinkedList Testing
        CustomLinkedList<String> ll = new CustomLinkedList<>();
        ll.add("Hello");
        ll.add("Dear");
        ll.add("Friend");
        ll.add("Friend2");
        ll.toPrint();
        System.out.println(ll.size());

        ll.remove("Dear");
        ll.toPrint();
        System.out.println(ll.size());

        ll.remove("Hello");
        ll.toPrint();
        System.out.println(ll.size());
    }
}
