package com.bdg.design_pattern.singleton;

/**
 * @author Artur
 * Sigleton Pattern example
 */

public class SingletonExample {
    private static SingletonExample instance;

    private SingletonExample() {
    }

    public static SingletonExample getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (SingletonExample.class) {
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }
}
