package com.rotatingmind.thread.course;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * What happen if t1 is depends on T2 then we can handle with join check in example
 * also we can check in loop but that is busy way
 */
public class ThreadCoordinationWithJoin {

    public static void main(String[] args) throws InterruptedException {
        List<Long> elements = List.of(0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
        //we want to calculate the factorials of 0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L
        List<FactorialThread> threads = new ArrayList<>();

        elements.forEach(ele -> {
            threads.add(new FactorialThread(ele));
        });

        threads.forEach(Thread::start);

        for (FactorialThread factorialThread : threads) {
            //factorialThread.join();
            factorialThread.join(2000);
        }

        for (int i = 0; i < elements.size(); i++) {
            FactorialThread thread = threads.get(i);
            if (thread.isFinished) {
                System.out.println("Factorial of " + elements.get(i) + " is " + thread.result);
                System.out.println("\n\n");
            } else {
                System.out.println("The calculation for " + elements.get(i) + " is still in progress ");
                System.out.println("\n\n");
            }
        }

    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long inputNumber) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = 2; i < inputNumber; i++) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }

            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
