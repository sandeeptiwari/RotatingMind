package com.rotatingmind.thread.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class IntroDemo {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        IntStream.range(0, 2).forEach(index -> {
            service.execute(() -> {
                System.out.println(" I am running on index " + index);
            });
        });
    }
}
