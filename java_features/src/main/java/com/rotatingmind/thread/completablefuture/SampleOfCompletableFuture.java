package com.rotatingmind.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

//https://www.youtube.com/watch?v=9ueIL0SwEWI
public class SampleOfCompletableFuture {

    private int compute() {
        // System.out.println("Compute " + Thread.currentThread());
        return 2;
    }

    public  CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static void main(String[] args) {
        SampleOfCompletableFuture obj = new SampleOfCompletableFuture();
        obj.create().thenAccept(data -> System.out.println(data));
    }
}
