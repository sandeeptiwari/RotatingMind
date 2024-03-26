package thread.pp.producer_consumer;

public class Task {

    private final int op1, op2;
    private final TaskType taskType;

    public Task(int op1, int op2, TaskType taskType) {
        this.op1 = op1;
        this.op2 = op2;
        this.taskType = taskType;
    }

    public int getOp1() {
        return op1;
    }

    public int getOp2() {
        return op2;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "Task{" +
                "op1=" + op1 +
                ", op2=" + op2 +
                ", taskType=" + taskType +
                '}';
    }
}
