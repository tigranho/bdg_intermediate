package com.bdg.examples;

import java.util.concurrent.*;

public class CheckResult {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int temp = 10;
        ExecutorService service = null;
        service = Executors.newSingleThreadExecutor();
        Future<?> result = service.submit(() -> {
            for (int i = 0; i < 500; i++) {
                CheckResult.counter++;
            }
        });

        result.get(1000, TimeUnit.HOURS);

        if (service != null) {
            service.shutdown();
            ;
        }
    }


}
