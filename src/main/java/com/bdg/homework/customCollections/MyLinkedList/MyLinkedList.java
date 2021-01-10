package com.bdg.homework.customCollections.MyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList= new CustomLinkedList();

       customLinkedList.addFirst("something");
		System.out.println(customLinkedList);
	
		Iterator itr = customLinkedList.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}

    }
}
