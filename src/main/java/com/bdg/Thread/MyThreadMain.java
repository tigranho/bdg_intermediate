package com.bdg.Thread;

public class MyThreadMain {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        new MyThread("MyThread").start();
        System.out.println("Main thread finished...");
    }
}

