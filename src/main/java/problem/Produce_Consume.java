package problem;

import java.util.LinkedList;

public class Produce_Consume {
    LinkedList<Integer> list = new LinkedList<>();
    int size = 2;


    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == size)
                    wait();
                System.out.println("Producer produced-" + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }


        }
    }


    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (this)
            {
                while (list.size() == 0)
                    wait();
                int val = list.removeFirst();
                System.out.println("Consumer consumed-" + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }

}