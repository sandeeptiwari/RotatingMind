package com.rotatingmind.thread.course;

import java.math.BigInteger;

public class Chapter03 {

    public static void main(String[] args) {
        Thread t = new Thread(
                new LongComputationTask(
                        new BigInteger("200000"), new BigInteger("1000000000"))
               );
        t.setDaemon(true);
        t.start();
        t.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" +power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0;
                 i = i.add(BigInteger.ONE)) {

               /* if daemon is true no need this else case it requires to interupt the thread
               if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }*/
                result = result.multiply(base);
            }
            return result;
        }
    }
}
