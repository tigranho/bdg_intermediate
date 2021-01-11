package com.bdg.homework2.arrayList;

public class Main {
    public static void main(String[] args) {
    CustomArrayList<Integer> list = new CustomArrayList<Integer>();
    //Add elements in custom ArrayList
           list.add(1);
           list.add(2);
           list.add(3);
           list.add(4);
           list.add(1);
           list.add(2);

        System.out.println(list.size());
        System.out.println(list.remove(2));// returns removed element
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add(1,3);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
}
}
