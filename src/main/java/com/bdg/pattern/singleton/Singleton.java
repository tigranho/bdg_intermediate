package com.bdg.pattern.singleton;

public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    return instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
