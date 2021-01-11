package com.bdg.homework.customCollections.MyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList
{
	public static void main(String[] args)
	{
		CustomLinkedList<String> customLinkedList = new CustomLinkedList();
		
		customLinkedList.add("1 Element");
		customLinkedList.add("2 Element");
		customLinkedList.add("3 Element");
		customLinkedList.add("4 Element");
		
		customLinkedList.print();
		
		
	}
}
