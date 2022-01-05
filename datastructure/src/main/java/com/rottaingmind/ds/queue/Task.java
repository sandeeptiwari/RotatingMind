package com.rottaingmind.ds.queue;

public class Task {

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    public void execute() {
        System.out.println("Executing task with Id : " + this.taskId);
    }
}
