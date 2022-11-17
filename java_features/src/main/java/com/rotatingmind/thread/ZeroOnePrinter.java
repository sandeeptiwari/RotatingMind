package com.rotatingmind.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ZeroOnePrinter {

    public static void main(String[] args) {

        ExecutorService service1 = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            t.setName("first");
            return t;
        });

        ExecutorService service2 = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            t.setName("second");
            return t;
        });


        IntStream.range(0, 101)
                .forEach(num -> {
                    CompletableFuture<Integer> cf1 = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(ele -> {
                                if (ele % 2 == 1) {
                                    System.out.print(1 + " ");
                                }
                                return ele;
                            }, service1);
                    cf1.join();

                    CompletableFuture<Integer> cf2 = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(ele -> {
                                if (ele % 2 == 0) {
                                    System.out.print(0 + " ");
                                }
                                return ele;
                            }, service2);

                    cf2.join();
                });

        service2.shutdown();
        service1.shutdown();
    }
}
