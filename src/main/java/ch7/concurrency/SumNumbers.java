package ch7.concurrency;

import java.util.Random;

public class SumNumbers {

    public static class Summing implements Runnable {
        int sum=0;

        @Override
        public void run() {
            Random random = new Random();
            int num = random.nextInt(10) + 1;
            System.out.println("Generated number: " + num);
            sum += num;

        }
    }


    public static void main(String[] args) throws InterruptedException {

        Summing summing = new Summing();
        Thread thread1 = new Thread(summing);
        Thread thread2 = new Thread(summing);
        Thread thread3 = new Thread(summing);
        Thread thread4 = new Thread(summing);
        Thread thread5 = new Thread(summing);

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



        System.out.println("Summary is: " + summing.sum);
    }
}
