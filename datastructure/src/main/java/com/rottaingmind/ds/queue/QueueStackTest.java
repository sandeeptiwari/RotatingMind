package com.rottaingmind.ds.queue;

public class QueueStackTest {

    public static void main(String[] args) {
        QueueWithStack<String> peopleQueue = new QueueWithStack<>();
        peopleQueue.enQueue("Sandeep Tiwari");
        peopleQueue.enQueue("Vibha Tiwari");
        peopleQueue.enQueue("Kavya Tiwari");
        peopleQueue.enQueue("Navya Tiwari");

        System.out.println(peopleQueue.dequeue());
        System.out.println(peopleQueue.dequeue());
        System.out.println(peopleQueue.dequeue());
        System.out.println(peopleQueue.dequeue());

        peopleQueue.enQueue("A");
        peopleQueue.enQueue("B");
        peopleQueue.enQueue("C");

        System.out.println(peopleQueue.dequeue());
        System.out.println(peopleQueue.dequeue());
    }
}
