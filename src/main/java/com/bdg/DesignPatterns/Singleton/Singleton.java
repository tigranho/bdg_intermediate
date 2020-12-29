package com.bdg.DesignPatterns.Singleton;

public class Singleton {
    private static Singleton instance;
    int i = 10;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Main  {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        s1.i=10;
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s1.hashCode() +"\n"+s2.hashCode());
        System.out.println(s1.i);
        System.out.println(s2.i);

    }
}

