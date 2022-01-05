package com.rotatingmind.thread.completablefuture;

import java.util.Random;
import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //submit task and accept the placeholder object for the return value
        Future<Integer> future = service.submit(new Task());
        try {

            //get the task return value
            Integer result = future.get();//blocking
            System.out.println("Result from the task is " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
}
