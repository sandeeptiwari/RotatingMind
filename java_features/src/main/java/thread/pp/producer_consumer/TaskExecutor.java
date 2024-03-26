package thread.pp.producer_consumer;

import static thread.pp.producer_consumer.TaskType.NO_OP;

public class TaskExecutor implements Runnable {

    private final TaskQueue queue;

    public TaskExecutor(TaskQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            while (queue.isEmpty()) {}
            Task t = queue.pop();
            int res = 0;
            switch (t.getTaskType()) {
                case ADD -> {
                    res = t.getOp1() + t.getOp2();
                }
                case MUL -> {
                    res = t.getOp1() * t.getOp2();
                }
                case SUB -> {
                    res = t.getOp1() - t.getOp2();
                }
                case DIV -> {
                    res = t.getOp1() / t.getOp2();
                }

            }
            System.out.println("Result " + res);
        }
    }

    /*@Override
    public void run() {
        while (true) {
           // while (queue.isEmpty()) {} // busy waiting issue
            synchronized (queue) {
            if (queue.isEmpty()) {

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

            } else {
                Task t = queue.pop();
                int res = 0;
                switch (t.getTaskType()) {
                    case ADD -> {
                        res = t.getOp1() + t.getOp2();
                    }
                    case MUL -> {
                        res = t.getOp1() * t.getOp2();
                    }
                    case SUB -> {
                        res = t.getOp1() - t.getOp2();
                    }
                    case DIV -> {
                        res = t.getOp1() / t.getOp2();
                    }
                }
                System.out.println("Result " + res);
                queue.notifyAll();
            }
            }
        }
    }*/

    /*public void run() {
        while (true) {
            // while (queue.isEmpty()) {} // busy waiting issue
            synchronized (queue) {
                if (queue.isEmpty()) {

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    Task t = queue.pop();
                    int res = 0;
                    if (t.getTaskType().equals(NO_OP)) {
                        break;
                    }
                    switch (t.getTaskType()) {
                        case ADD -> {
                            res = t.getOp1() + t.getOp2();
                        }
                        case MUL -> {
                            res = t.getOp1() * t.getOp2();
                        }
                        case SUB -> {
                            res = t.getOp1() - t.getOp2();
                        }
                        case DIV -> {
                            res = t.getOp1() / t.getOp2();
                        }

                    }
                    System.out.println("Result " + res);
                    queue.notify();
                }
            }
        }
    }*/
}
