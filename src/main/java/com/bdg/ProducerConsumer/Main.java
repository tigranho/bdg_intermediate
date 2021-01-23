package com.bdg.ProducerConsumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Queue<Integer> storage;
    static File log;
    static final int LIMIT = 10;
    static final Object lock = new Object();

    public static void produce(int producers) {
        Thread[] producersArray = new Thread[producers];
        Random random = new Random();
        for (int i = 0; i < producersArray.length; i++) {

            producersArray[i] = new Thread(() -> {
                try {
                    while (true) {
                        synchronized (lock) {
                            while (storage.size() == LIMIT) {
                                lock.wait();
                            }
                            storage.offer(random.nextInt(100));
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            producersArray[i].start();

        }
    }

    public static void consume(int consumer) throws IOException {
        Thread[] consumerArray = new Thread[consumer];
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(log);


        for (int i = 0; i < consumerArray.length; i++) {

            consumerArray[i] = new Thread(() -> {
                try {
                    while (true) {
                        synchronized (lock) {
                            while (storage.size() == 0) {
                                lock.wait();

                            }
                            storage.poll();
                            System.out.println(storage);
                            fileWriter.write(storage.toString());
                            fileWriter.write("\r\n");
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            });
            consumerArray[i].start();


        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type number of Producers");
        int numberOfProducers = scanner.nextInt();
        System.out.println("type number of consumers");
        int consumers = scanner.nextInt();
        storage = new LinkedList<>();
        log = new File("C:\\Users\\Pertsh\\Desktop\\data.txt");    //!!!!!!!!!! please change pathname to create data.txt


        produce(numberOfProducers);
        consume(consumers);


    }
}
