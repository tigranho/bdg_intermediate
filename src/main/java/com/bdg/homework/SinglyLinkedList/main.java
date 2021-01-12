package com.bdg.homework.SinglyLinkedList;

import java.util.*;

public class main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.push_back(0);
        list.push_back(1);
        list.push_back(2);
        list.push_back(3);
        list.push_back(4);
        list.push_back(5);

        list.push_front(99);

        list.remove_at(3);

        list.pop_back();

        list.pop_front();

        list.insert(200, 4);

        list.print_list();

        System.out.print(" " + list.get_size());

    }
}