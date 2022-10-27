package com.rotatingmind.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                new IllegalStateException(e);
            }
            String sleepString = "Waited for a minute!";
            String resultString = "result of the asynchronous computation";
            String supplierResult = sleepString + resultString;
            return supplierResult;
        });

        //block and get the result of the future
        String result = completableFuture.get();
        System.out.println(result);
    }
}
