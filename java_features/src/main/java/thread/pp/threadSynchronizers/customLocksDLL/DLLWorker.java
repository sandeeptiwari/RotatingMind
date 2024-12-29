package thread.pp.threadSynchronizers.customLocksDLL;

public class DLLWorker implements Runnable {

    private int value;
    private DoublyLinkedList doublyLinkedList;

    public DLLWorker(DoublyLinkedList doublyLinkedList, int val) {
        this.value = val;
        this.doublyLinkedList = doublyLinkedList;
    }

    @Override
    public void run() {
        doublyLinkedList.insertNode(value);
    }
}
