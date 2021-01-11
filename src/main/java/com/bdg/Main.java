package com.bdg;

import com.bdg.generic.list.CustomArrayList;

/**
 * @author Aram
 */
public class Main {

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList(3);
        customArrayList.add(10);
        customArrayList.add(2);
        customArrayList.add(4);
        customArrayList.add(2,6);

        System.out.println(customArrayList.contains(new Integer(1)));


    }


}
