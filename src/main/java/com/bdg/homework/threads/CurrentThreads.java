package com.bdg.homework.threads;

import java.util.Random;

public class CurrentThreads {
    public static void main(String[] args) throws InterruptedException {
        int number = 0;
         Thr tr = new Thr();
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(()->{
                tr.randomValue(new Random().nextInt(10)+1);
            });
            thread.start();
            thread.join();
            number += tr.getValue();
            System.out.println("the first number " + tr.getValue());
        }

        System.out.println("total value of number" + number);



    }
}

class Thr {
    int value;

    void randomValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}

