package com.rotatingmind.thread;

public class PrintEvenOdd {

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();
        PrintEvenOddTask task1 = new PrintEvenOddTask(printer, false);
        PrintEvenOddTask task2 = new PrintEvenOddTask(printer, true);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}

class PrintEvenOddTask implements Runnable {
    private final EvenOddPrinter printer;
    private final boolean isEven;
    private final int MAX_NUMBER = 20;

    PrintEvenOddTask(EvenOddPrinter printer, boolean isEven) {
        this.printer = printer;
        this.isEven = isEven;
    }


    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number < MAX_NUMBER) {
            if (!isEven) {
                try {
                    printer.printOdd(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    printer.pintEven(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number += 2;
        }
    }
}

class EvenOddPrinter {
    private boolean isOdd = true;

    public void pintEven(int number) throws InterruptedException {
        synchronized (this) {
            while (isOdd) {
                this.wait();
            }
        }
        System.out.print(number + ", ");
        isOdd = true;
        synchronized (this) {
            this.notify();
        }
    }

    public void printOdd(int number) throws InterruptedException {
        synchronized (this) {
            while (!isOdd) {
                this.wait();
            }
        }
        System.out.print(number + ", ");
        isOdd = false;
        synchronized (this) {
            this.notify();
        }
    }
}
