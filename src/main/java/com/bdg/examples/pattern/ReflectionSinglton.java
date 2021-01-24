package com.bdg.examples.pattern;

import java.lang.reflect.Constructor;

public class ReflectionSinglton {
    public static void main(String[] args) {
        EagerSingleton one = EagerSingleton.getInstance();
        EagerSingleton two = null;
        try{
            Constructor[] constructors=EagerSingleton.class.getDeclaredConstructors();
            for (Constructor constructor:constructors){
                constructor.setAccessible(true);
                two= (EagerSingleton) constructor.newInstance();
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
    }
}
