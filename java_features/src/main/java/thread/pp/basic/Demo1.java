package thread.pp.basic;

public class Demo1 {

    public static void main(String[] args) {
        Worker worker = new Worker('A');
        Worker worker1 = new Worker('B');
        Worker worker2 = new Worker('C');
        Worker worker3 = new Worker('D');

        Thread t = new Thread(worker);
        t.start();

        Thread t1 = new Thread(worker1);
        t1.start();

        Thread t2 = new Thread(worker2);
        t2.start();

        Thread t3 = new Thread(worker3);
        t3.start();

        System.out.println("Hi I am " + Thread.currentThread().getName());
    }
}
