package com.rotatingmind.thread.course;

public class Chapter02 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           try {
             Thread.sleep(500000);
           } catch(InterruptedException e) {
               System.out.println("Exiting blocking thread");
           }
        });
        t.start();

        t.interrupt();
    }
}
