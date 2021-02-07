package com.bdg.examples;

import java.util.concurrent.*;

public class AddData {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service=null;
        try{
            service= Executors.newSingleThreadExecutor();
            Future<Integer> submit = service.submit(() -> 30 + 11);
            System.out.println(submit.get());
            service.submit(()->{Thread.sleep(1000);return null;});
            service.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service!=null){
                service.shutdown();
            }
        }

        if (service!=null){
             service.awaitTermination(1, TimeUnit.MINUTES);
             if (service.isTerminated()){
                 System.out.println("all task finished");
             }else{
                 System.out.println("task  tis still running");
             }
        }

    }
}
