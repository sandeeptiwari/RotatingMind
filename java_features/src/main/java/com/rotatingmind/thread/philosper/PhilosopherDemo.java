package com.rotatingmind.thread.philosper;

public class PhilosopherDemo {

    public static void main(String[] args) {
        String[] forks = {
                "Fork-1", "Fork-2", "Fork-3", "Fork-4", "Fork-5"
        };

        Philosopher[] philosophers = {
               new Philosopher(forks[0], forks[1]),
                new Philosopher(forks[1], forks[2]),
                new Philosopher(forks[2], forks[3]),
                new Philosopher(forks[3], forks[4]),
                new Philosopher(forks[4], forks[0]),
        };

        Thread ph1Thread = new Thread(philosophers[0], "Philosopher-1");
        Thread ph2Thread = new Thread(philosophers[1], "Philosopher-2");
        Thread ph3Thread = new Thread(philosophers[2], "Philosopher-3");
        Thread ph4Thread = new Thread(philosophers[3], "Philosopher-4");
        Thread ph5Thread = new Thread(philosophers[4], "Philosopher-5");

        ph1Thread.start();
        ph2Thread.start();
        ph3Thread.start();
        ph4Thread.start();
        ph5Thread.start();

    }
}
