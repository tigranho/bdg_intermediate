package com.bdg.ArrayList;

import java.util.*;

public class ArrayListMain {public static void main(String[] arqs) {
    List<Person> list = new ArrayList<>();
    Person person1 = new Person("Anna");
    Person person2 = new Person("Armen");
    Person person3 = new Person("Katrina");
    Person person4 = new Person("Artur");
    Person person5 = new Person("Ani");

    list.add(person1);
    list.add(person2);
    list.add(person3);
    list.add(person4);

    Person person1FromCollection = list.get(0);
    Person person2FromCollection = list.get(1);
    Person person3FromCollection = list.get(2);
    Person person4FromCollection = list.get(3);
    System.out.println(person1FromCollection);
    System.out.println(person2FromCollection);
    System.out.println(person3FromCollection);
    System.out.println(person4FromCollection);

    boolean remove = list.remove(person2);
    System.out.println(remove);
    list.add(1, person2);
    System.out.println(person2);

    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == person3) {
            list.remove(i);
        }
    }
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }
    System.out.println(list.size());

    list.add(person4);
    System.out.println(list.contains(person5));

    list.set(2, person5);
    System.out.println("ArrayList after replacing : " + list + "\n");


    LinkedList<Flowers> flowers1LinkedList = new LinkedList<>();
    Flowers flowers1 = new Flowers("Rose");
    Flowers flowers2 = new Flowers("Peony");
    Flowers flowers3 = new Flowers("Orchids");
    Flowers flowers4 = new Flowers("Aster");
    Flowers flowers5 = new Flowers("Tulips");
    Flowers flowers6 = new Flowers("Jasmine");

    flowers1LinkedList.add(0, flowers1);
    flowers1LinkedList.add(1, flowers2);
    flowers1LinkedList.add(2, flowers3);
    flowers1LinkedList.add(3, flowers4);
    flowers1LinkedList.add(4, flowers5);
    flowers1LinkedList.add(5, flowers6);

}}
