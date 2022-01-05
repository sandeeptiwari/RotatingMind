package com.rotatingmind.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintZeroOne {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static Queue<Integer> queue = new LinkedList<>();
    private static final int MAX = 100;
    private static final int COUNT = 100;
    private static int zero_wait_time = 01;
    private static int one_wait_time = 50;

    public static void main(String[] args) {
        PrinterWithCondition printer = new PrinterWithCondition(lock, condition);

        Thread zeroTask = new Thread(new ZeroOneTaskV1(printer, true));
        Thread oneTask = new Thread(new ZeroOneTaskV1(printer, false));

        zeroTask.start();
        oneTask.start();
    }
}

class ZeroOneTask implements Runnable {
    private Printer print;
    private boolean isZero;

    public ZeroOneTask(Printer print, boolean isZero){
        this.print = print;
        this.isZero = isZero;
    }

    @Override
    public void run() {
        while(true){
            if(isZero){
                try {
                    print.printZero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    print.printOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Printer {

    boolean isZero = true;

    public void printZero() throws InterruptedException {
        synchronized (this) {
            while(!isZero){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("0");
            Thread.sleep(1000);
            isZero = false;
            notifyAll();
        }
    }

    public void printOne() throws InterruptedException {
        synchronized (this) {
            while(isZero){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(", 1, ");
            Thread.sleep(1000);
            isZero = true;
            notifyAll();
        }
    }
}

class ZeroOneTaskV1 implements Runnable {
    private PrinterWithCondition print;
    private boolean isZero;

    public ZeroOneTaskV1(PrinterWithCondition print, boolean isZero){
        this.print = print;
        this.isZero = isZero;
    }

    @Override
    public void run() {
        while(true){
            if(isZero){
                try {
                    print.printZero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    print.printOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class PrinterWithCondition {

    private boolean isZero = true;
    private Lock lock;
    private Condition condition;

    PrinterWithCondition(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void printZero() throws InterruptedException {
        lock.lock();
         try {
            while(!isZero){
                    condition.await();
            }
            System.out.print("0");
            Thread.sleep(1000);
            isZero = false;
            condition.signal();
        } finally {
             lock.unlock();
         }
    }

    public void printOne() throws InterruptedException {
        lock.lock();
        try {
            while(isZero){
               condition.await();
            }
            System.out.print(", 1, ");
            Thread.sleep(1000);
            isZero = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}