package com.rottaingmind.ds.queue;

public class App {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println(queue.size());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.size());
    }
}
