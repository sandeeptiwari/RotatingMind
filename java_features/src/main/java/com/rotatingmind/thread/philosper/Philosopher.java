package com.rotatingmind.thread.philosper;

import java.util.Random;

public class Philosopher implements Runnable {
    private static Random rnd = new Random();
    private final String leftFork;
    private final String rightFork;

    public Philosopher(String leftFork, String rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + ": thinking");
            doIt();
            synchronized (leftFork) {
                System.out.println(Thread.currentThread().getName() + ": took the left fork ( " +
                        leftFork + ")");
                doIt();
                synchronized (rightFork) {
                    System.out.println(Thread.currentThread().getName() + ": took the right fork ( " +
                            rightFork + ") and eating");
                    doIt();

                    System.out.println(Thread.currentThread().getName() + ": put the right fork" +
                            rightFork + " on the table");
                    doIt();
                }
                System.out.println(Thread.currentThread().getName() + ": put the left fork" +
                        leftFork + " on the table and thinking");
                doIt();
            }
        }
    }

    private static void doIt() {
        try {
            Thread.sleep(rnd.nextInt(2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Exception " + e.getMessage());
        }
    }
}
