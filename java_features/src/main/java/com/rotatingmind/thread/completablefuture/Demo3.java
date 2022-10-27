package com.rotatingmind.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Name -1 " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(60);
                System.out.println("Name -2 " + Thread.currentThread().getName());
            } catch(InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }).get();
        System.out.println("it will run in a separate thread than the main thread.");
    }
}
