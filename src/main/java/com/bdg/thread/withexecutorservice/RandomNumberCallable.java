package com.bdg.thread.withexecutorservice;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberCallable implements Callable<Integer> {


    private int number;
    private String name;

    public RandomNumberCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        number = random.nextInt(10) +1;
        return number;
    }
}
