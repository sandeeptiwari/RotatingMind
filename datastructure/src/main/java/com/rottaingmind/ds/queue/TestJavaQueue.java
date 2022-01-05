package com.rottaingmind.ds.queue;

import java.util.Queue;
import java.util.LinkedList;

public class TestJavaQueue {

    public static void main(String[] args) {
        Queue<Task> queue = new LinkedList<>();
        queue.add(new Task(1));
        queue.add(new Task(2));
        queue.add(new Task(3));
        queue.add(new Task(4));

        while (!queue.isEmpty()) {
            Task task = queue.remove();
            task.execute();
        }

    }
}
