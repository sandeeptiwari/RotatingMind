package com.rotatingmind.thread.course;

/**
 * Context Switch : Each instace of application run in an isolated proces
 * each process can have multiple threads.
 *
 * Start t1 and stopping t2 vice verse among the process known as context switch
 *
 * Thread Scheduling :
 */
public class Introduction {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(" I am running");
            throw new RuntimeException("This exception demo from thread");
        });

        thread.setName("Loader");

        /**
         * unchecked exception in java simply bring down entire thread
         * so we have to handle it as like below
         */
        thread.setUncaughtExceptionHandler((t, e) -> {
            //release the resources
            System.out.println("Lets clean the resource because Thread " + t.getName() +
                    " has stopped with exception " + e.getMessage());
        });

        thread.start();
    }
}
