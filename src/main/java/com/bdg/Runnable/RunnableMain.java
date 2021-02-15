package com.bdg.Runnable;

public class RunnableMain {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        Thread myThreadRun = new Thread();
        myThreadRun.start();
        System.out.println("Main thread finished...");
    }
}
