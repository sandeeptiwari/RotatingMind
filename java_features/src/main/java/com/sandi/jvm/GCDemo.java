package com.sandi.jvm;

public class GCDemo implements Runnable {
    static int [] arr = new int[2*1024*1024];// 8.4 mb
    private String name;
    public GCDemo(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        /*System.out.println("1");
        synchronized (args) {
            System.out.println("2");
            try {
                args.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("3");*/

        new Thread(new GCDemo("Wallace")).start();
        new Thread(new GCDemo("Gromit")).start();
    }

    public synchronized void message(int n) {
        System.out.println(name + "-" + n+"");
    }

    @Override
    public void run() {
        message(1);
        message(2);
    }
}
