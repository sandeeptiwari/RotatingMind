package com.rotatingmind.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProducerConsumerProblemNew {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ProducerConsumer producerConsumer = new ProducerConsumer(lock, condition, 2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            while(true) {
                producerConsumer.produce();
            }
        });
        executor.execute(() -> {
            while(true) {
                producerConsumer.consume();
            }
        });

        executor.shutdown();
    }

}

class ProducerConsumer {
    private final ReentrantLock lock;
    private final Condition condition;
    private final List<Integer> items = new LinkedList<Integer>();
    private final int size;


    ProducerConsumer(ReentrantLock lock, Condition condition, int size) {
        this.lock = lock;
        this.condition = condition;
        this.size = size;
    }

    public void produce() {
            try {
                lock.lock();

                while (items.size() >= size) {
                    condition.await();
                }

                Random rnd = new Random();

                IntStream.range(0, size)
                        .forEach(index -> {
                            int number = rnd.nextInt(20);
                            System.out.println("Produce -> " + number);
                            items.add(number);
                        });
                condition.signal();
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }

    public void consume() {
        try {
            lock.lock();

            while (items.size() < size) {
                condition.await();
            }

            items.stream().forEach(item -> System.out.println("Consume -> " + item));
            items.clear();
            condition.signal();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
