package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        Object lock = new Object();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable{
    private List<Integer> buffer;
    private Random random;

    Producer(List<Integer> buffer ) {
        this.buffer = buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            while (buffer.size() != 0) {
                synchronized (buffer) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            buffer.add(random.nextInt(10));
            synchronized (buffer) {
                buffer.notifyAll();
            }

            try{
                Thread.sleep(1000);// remove it then deadlock
            }catch(InterruptedException ie){}
        }
    }
}

class Consumer implements Runnable{
    private List<Integer> buffer;

    Consumer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            while (buffer.isEmpty()) {
                synchronized (buffer) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println(buffer.get(0));
            buffer.clear();

            synchronized (buffer) {
                buffer.notifyAll();
            }

            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){}
        }

    }
}