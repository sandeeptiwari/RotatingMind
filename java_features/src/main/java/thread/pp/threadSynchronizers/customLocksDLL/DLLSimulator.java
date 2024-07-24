package thread.pp.threadSynchronizers.customLocksDLL;

public class DLLSimulator {

    public static void main(String[] args) throws InterruptedException {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Thread t1 = new Thread(new DLLWorker(doublyLinkedList, 80));
        Thread t2 = new Thread(new DLLWorker(doublyLinkedList, 1));
        Thread t3 = new Thread(new DLLWorker(doublyLinkedList, 75));
        Thread t4 = new Thread(new DLLWorker(doublyLinkedList, 50));
        Thread t5 = new Thread(new DLLWorker(doublyLinkedList, 100));
        Thread t6 = new Thread(new DLLWorker(doublyLinkedList, 20));
        Thread t7 = new Thread(new DLLWorker(doublyLinkedList, 76));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();

        doublyLinkedList.traverse();

    }
}
