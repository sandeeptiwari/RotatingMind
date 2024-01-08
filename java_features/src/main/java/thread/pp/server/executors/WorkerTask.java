package thread.pp.server.executors;

public class WorkerTask implements Runnable {

    private final String message;

    public WorkerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Its me " + Thread.currentThread().getName());
        System.out.println("Its me " + Thread.currentThread().getName());
        System.out.println("Its me " + Thread.currentThread().getName());
        System.out.println("Its me " + Thread.currentThread().getName());
    }
}
