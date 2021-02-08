package ch7.concurrency;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    public ProducerConsumer(int size) {
        WareHouse wareHouse = new WareHouse(size);
        new Producer(wareHouse).start();
        new Producer(wareHouse).start();
        new Producer(wareHouse).start();
        new Producer(wareHouse).start();

        new Consumer(wareHouse).start();
        new Consumer(wareHouse).start();
        new Consumer(wareHouse).start();

    }

    class WareHouse {
        private final Deque<Integer> stock;
        private final int MAX_SIZE;
        private final ReentrantLock locker = new ReentrantLock();
        final Condition notFull = locker.newCondition();
        final Condition notEmpty = locker.newCondition();
        int i = 0;

        WareHouse(int size) {
            MAX_SIZE = size;
            this.stock = new ArrayDeque<>();
        }

        void add() throws InterruptedException {
            locker.lock();
            try {
                while (stock.size() == MAX_SIZE) {
                    notFull.await();
                }
                System.out.println("Adding by " + Thread.currentThread().getName() + " : " + i);
                stock.addFirst(i++);
                notEmpty.signal();
            } finally {
                locker.unlock();
            }
        }

        void remove() throws InterruptedException {
            locker.lock();
            try {
                while (stock.size() == 0) {
                    notEmpty.await();
                }
                System.out.println("Removing by " + Thread.currentThread().getName() + " : " + stock.getLast());
                stock.removeLast();
                notFull.signal();
            } finally {
                locker.unlock();
            }
        }
    }

    class Producer extends Thread {
        WareHouse wareHouse;

        public Producer(WareHouse wareHouse) {
            this.wareHouse = wareHouse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    wareHouse.add();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        WareHouse wareHouse;

        public Consumer(WareHouse wareHouse) {
            this.wareHouse = wareHouse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    wareHouse.remove();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer(50);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
    }
}
