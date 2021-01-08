package com.bdg.homework.customCollections.MyArrayList;

public class MyArrayList {
    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(1);
        customArrayList.add(1);

        customArrayList.remove(0);
        System.out.println( customArrayList.isEmpty());
        System.out.println( customArrayList.size());
        System.out.println( customArrayList.contains(4));
    }

}
