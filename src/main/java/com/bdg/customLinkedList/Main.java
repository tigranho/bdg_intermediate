package com.bdg.customLinkedList;


import org.graalvm.compiler.graph.Node;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<Integer>();
        customLinkedList.add(11);
        customLinkedList.add(22);
        customLinkedList.add(33);
        customLinkedList.add(44);
        customLinkedList.add(55);
        System.out.println("Will list contain object = " + customLinkedList.contains(11));
        for (int j = 0; j < customLinkedList.size(); j++) {
            System.out.println(customLinkedList.get(j));
        }
        System.out.println("Remove index = " + customLinkedList.remove(1));
        System.out.println("Was object removed = " + customLinkedList.remove(new Integer(55)));
        for (int j = 0; j < customLinkedList.size(); j++) {
            System.out.println(customLinkedList.get(j));
        }
    }
}
