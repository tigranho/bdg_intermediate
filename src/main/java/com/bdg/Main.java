package com.bdg;

import com.bdg.generic.CustomArrayList;

/**
 * @author Tigran
 */
public class Main {

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>(3);
        customArrayList.add(10);
        customArrayList.add(2);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(1);

        customArrayList.remove(new Integer(4));


    }


}
