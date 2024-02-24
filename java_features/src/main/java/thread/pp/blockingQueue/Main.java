package thread.pp.blockingQueue;

public class Main {

    public static void main(String[] args) {
        MyBlockingQueue q = new MyBlockingQueue(5);

        Thread producer = new Thread(new Producer(q));
        Thread consumer = new Thread(new Consumer(q));

        producer.start();
        consumer.start();
    }
}
