package com.bdg.thread;

public class Main {
    public static void main(String[] args) {
        RandomNumberThread sumThread1 = new RandomNumberThread();

        Thread thread1 = new Thread(sumThread1);
        Thread thread2 = new Thread(sumThread1);
        Thread thread3 = new Thread(sumThread1);
        Thread thread4 = new Thread(sumThread1);
        Thread thread5 = new Thread(sumThread1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = sumThread1.getSum();

        System.out.println("sum = " + sum);
    }
}
