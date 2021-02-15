package com.bdg.homework2.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedListCustom<Integer> list = new LinkedListCustom<>();
        list.addFirst(1);
        //System.out.println(list.size());
        list.add(2,15);
        list.add(3,16);
        list.remove(3);
        list.remove(2);
    }
}
