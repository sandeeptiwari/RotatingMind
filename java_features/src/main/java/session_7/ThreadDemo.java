package session_7;

import java.util.Map;

class Test implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

/**
 * Java doesn't allow multiple inheritance
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    /**
     * creat --> Queue -> running state -> dead state OR waiting state
     * @param args
     */
    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        //demo.start();
        System.out.println("Thread in running");

        //By runnable interface



        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        t.start();

    }
}
