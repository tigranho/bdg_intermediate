package com.bdg.collections.map;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();


        for (int i = 0; i < 16; i++) {
            map.put(i, "A" + i);
        }
        System.out.println(map.toString());

        System.out.println(map.remove(0));
        System.out.println(map.get(0));


    }
}
