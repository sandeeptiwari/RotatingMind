package thread.pp.blockingQueue;

public class Main {

    public static void main(String[] args) {
        MyBlockingQueue q = new MyBlockingQueue(5);

        Thread producer = new Thread(Producer(q));
        Thread consumer = new Thread(Consumer(q));
    }
}
