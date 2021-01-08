package com.bdg.homework.customCollections.MyLinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList= new CustomLinkedList();

        customLinkedList.add(0,"a");
        customLinkedList.add(1,"b");
        customLinkedList.add(2,"c");
        customLinkedList.add(3,"d");

        customLinkedList.returnSize();
        customLinkedList.print();

    }
}
