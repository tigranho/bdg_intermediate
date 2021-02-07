package com.bdg.examples;

import java.util.concurrent.*;

interface Tests<T> {

    void print(T t);

}

public class Optionals {
    static  int counter=0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service=null;
//        try{
//            System.out.println("begin");
//            service= Executors.newSingleThreadExecutor();
////            service.execute(new PrintData());
//            service.execute(System.out::println);
//            service.execute(()->{for (int i=0; i<3;i++)
//                System.out.println("Printing record "+i);});
//            service.execute(()-> System.out.println("printng zoo imventory"));
//            System.out.println("end");
//        }finally {
//            if (service!=null)
//                service.shutdown();
//
//        }

       // service.shutdownNow().forEach(System. out::println);
        service=Executors.newSingleThreadExecutor();
        Future<?> submit = service.submit(()-> System.out.println("hello zoo"));
        try {
            System.out.println(submit.get());
            //submit.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service!=null){
                service.shutdown();
            }
        }

        System.out.println(submit.isDone());
        System.out.println(submit.isCancelled());




//        service.execute(()-> System.out.println("helllo"));

    }
}

class PrintData implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Printing recorde: " + i);

        }
    }
}

class ReadInventoryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }
}
