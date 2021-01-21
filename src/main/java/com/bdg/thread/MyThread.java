package com.bdg.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                test.SUM+=i;

            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 3; i < 5; i++) {
                test.SUM+=i;

            }
        });
        Thread thread3 = new Thread(()->{
            for (int i = 5; i < 7; i++) {
                test.SUM+=i;

            }
        });
        Thread thread4 = new Thread(()->{
            for (int i = 7; i < 9; i++) {
                test.SUM+=i;

            }
        });
        Thread thread5 = new Thread(()->{
            for (int i = 9; i < 11; i++) {
                test.SUM+=i;

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println(test.SUM);


    }
}

class Test {
    public int SUM;
}
