package thread.pp.producer_consumer;

public class Main {

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        Thread t1 = new Thread(new TaskGen(taskQueue));
        t1.setName("Producer");
        Thread t2 = new Thread(new TaskExecutor(taskQueue));
        t2.setName("Consumer");

        t1.start();
        t2.start();

        System.out.println("Bye from main...");
    }
}
