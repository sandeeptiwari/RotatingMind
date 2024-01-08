package thread.pp.producer_consumer;

import java.util.List;
import java.util.Random;

import static thread.pp.producer_consumer.TaskType.NO_OP;

public class TaskGen implements Runnable {

    private final TaskQueue queue; // can use as lock because its common

    public TaskGen(TaskQueue queue) {
        this.queue = queue;
    }

/*    @Override
    public void run() {
        Random r = new Random();
        List<TaskType> types = List.of(TaskType.values());
        while (true) {
            // while (queue.isFull()) {}
            synchronized (queue) {
                if (queue.isFull()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Task task = new Task(r.nextInt(10, 20), r.nextInt(10, 20), types.get(r.nextInt(0, 4)));
                    queue.push(task);
                    System.out.println("Added task " + task);
                    queue.notifyAll();
                }
            }

        }

    }*/

    @Override
    public void run() {
        Random r = new Random();
        List<TaskType> types = List.of(TaskType.values());
        while (true) {
             while (queue.isFull()) {}
            /*synchronized (queue) {
                if (queue.isFull()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Task task = new Task(r.nextInt(10, 20), r.nextInt(10, 20), types.get(r.nextInt(0, 5)));
                    queue.push(task);
                    System.out.println("Added task " + task);
                    if (task.getTaskType().equals(NO_OP)) {
                        break;
                    }
                    queue.notify();
                }
            }*/
            Task task = new Task(r.nextInt(10, 20), r.nextInt(10, 20), types.get(r.nextInt(0, 5)));
            queue.push(task);
            System.out.println("Added task " + task);
        }

    }
}
