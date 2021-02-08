package com.bdg;


import customDataStructures.CustomArrayList;
import customDataStructures.CustomHashMap;
import customDataStructures.CustomLinkedList;

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
        System.out.println("************** LINKED LIST ******************");
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.add(25);
        ll.add(30);
        ll.add(15);
        System.out.println("Elements are: " + ll);
        System.out.println("List size is: " + ll.size());
        System.out.println("*********************************************");
        ll.addAll(arr2);
        System.out.println("Elements are: " + ll);
        System.out.println("List size is: " + ll.size());
        System.out.println("*********************************************");
        System.out.println("Element successfully removed: " + ll.remove((Object)6));
        System.out.println("Elements are: " + ll);
        System.out.println("List size is: " + ll.size());
        System.out.println("*********************************************");
        System.out.println("Element of index 4: " + ll.get(4));
        System.out.println("*********************************************");
        System.out.println("Change Element with index 3 to 45: " + ll.set(3, 45));
        System.out.println("Elements are: " + ll);
        System.out.println("List size is: " + ll.size());
        System.out.println("*********************************************");

        //CustomHashMap Testing
        System.out.println("*************** HASH MAP *******************");
        CustomHashMap<Integer, String> hm = new CustomHashMap<>();
        hm.put(1, "January");
        hm.put(2, "February");
        hm.put(3, "March");
        hm.put(4, "March");
        System.out.println(hm);
        hm.replace(4, "March", "April");
        hm.put(5, "May");
        hm.put(6, "June");
        hm.put(7, "July");
        hm.put(8, "August");
        hm.put(9, "September");
        hm.put(10, "October");
        hm.put(11, "November");
        hm.put(12, "December");
        System.out.println(hm);
        hm.clear();
        System.out.println(hm);
        hm.put(1, "January");
        hm.put(2, "February");
        hm.put(3, "March");
        System.out.println(hm);
        System.out.println(hm.size());
        hm.remove(1);
        System.out.println(hm);
        System.out.println(hm.size());
        hm.remove(2);
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.get(3));
        System.out.println("Contains key: 3 -- " + hm.containsKey(3));
        System.out.println("Contains key: 4 -- " + hm.containsKey(4));

        System.out.println("Contains March: " + hm.containsValue("March"));
        System.out.println("Contains march: " + hm.containsValue("march"));
     }
}
