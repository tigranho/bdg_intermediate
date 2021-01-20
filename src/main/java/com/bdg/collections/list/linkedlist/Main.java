package com.bdg.collections.list.linkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("A");
        myLinkedList.add("B");
        myLinkedList.add("C");
        myLinkedList.add("D");
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));

        System.out.println(myLinkedList.toString());
    }
}
