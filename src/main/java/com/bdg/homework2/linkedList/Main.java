package com.bdg.homework2.linkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedListCustom<Integer> list = new LinkedListCustom<>();
        list.addFirst(1);
        list.add(2);
        list.add(3);
        //System.out.println(list.size());
        list.add(2,15);
        list.add(3,16);
        list.remove(3);
        list.remove(2);

        //list.clear();
       // System.out.println(list.size());
        //list.printList();
        //System.out.println(list.isEmpty());
        //list.printList();
    }
}
