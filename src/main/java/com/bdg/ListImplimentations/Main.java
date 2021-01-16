package com.bdg.ListImplimentations;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> cll = new CustomLinkedList<>();
        cll.add(1);
        cll.add(5);
        cll.add(6);
        cll.add(3);
        cll.add(8);
        cll.add(9);

        System.out.println(cll);
        cll.remove(1);
        cll.remove(3);
        System.out.println(cll);
        System.out.println(cll.size());



        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

        Random random = new Random();

        for(int i=0;i<12;i++){
            customArrayList.add(random.nextInt(100));
        }
        System.out.println(customArrayList);
        System.out.println(customArrayList.size());
        // customArrayList.clear();
        System.out.println(customArrayList.contains(15));

    }
}
