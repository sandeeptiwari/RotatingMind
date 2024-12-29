package thread.pp.basic.concurrencyBasics.containerSum;

public class ContainerSumSimulator {

    public static int totalSum = 0;
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        Object lock = new Object();
        Thread t1 = new Thread(new SumWorker(container, lock));
        Thread t2 = new Thread(new SumWorker(container, lock));
        Thread t3 = new Thread(new SumWorker(container, lock));
        Thread t4 = new Thread(new SumWorker(container, lock));
        Thread t5 = new Thread(new SumWorker(container, lock));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println(totalSum);
    }
}
