package com.bdg.collections.list;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        System.out.println("____________ size = " + customArrayList.size() + ",isEmpty " + customArrayList.isEmpty());
        System.out.println(customArrayList.toString());
        customArrayList.add("AA");
        customArrayList.add("AA");
        customArrayList.add("AA");
        customArrayList.add("BA");
        customArrayList.add("CA");

        System.out.println(customArrayList.toString());
        System.out.println("removed element index 3 " + customArrayList.remove(4));
        System.out.println("removed element onj BA " + customArrayList.remove("BA"));
        print(customArrayList);
        System.out.println("contains AA " + customArrayList.contains("AA"));
        System.out.println("contains  BA " + customArrayList.contains("BA"));
        customArrayList.add(0, "11");
        System.out.println("add by index string '11' in index 0 and get " + customArrayList.get(0));
        System.out.println(customArrayList.set(0, "22"));
        System.out.println("set  string '22' in index 0 and get " + customArrayList.get(0));
        System.out.println("___________________");
        print(customArrayList);

        for (int i = 0; i < 16; i++) {
            customArrayList.add(String.valueOf(i));
        }
        System.out.println("____________ size = " + customArrayList.size() + ",isEmpty " + customArrayList.isEmpty());
        print(customArrayList);

    }

    private static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
