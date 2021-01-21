package com.bdg.thread;

public class Main {
    public static void main(String[] args) {
        TrRunnable trRun = new TrRunnable();

        Thread threads[] = new Thread[5];
        for (int i = 0; i <= 4; i++) {
            threads[i] = new Thread(trRun);
            threads[i].setName("TrRunnable - Thread - " + i);
            threads[i].start();
        }

        for (int i = 0; i <= 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("sum is = " + trRun.sum);
    }
}
