package thread.pp.threadSynchronizers.customLocksDLL;

public class DoublyLinkedList {

    private final Node head, tail;

    public DoublyLinkedList() {
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void insertNode(int value) {
        Node currNode = head;
        Node nextNode = null;

        currNode.lock.lock();
        try{
            while (true){
                try {
                    nextNode = currNode.next;
                    nextNode.lock.lock();

                    if(nextNode.val <= value){
                        Thread.sleep(1000);
                        Node node = new Node(value);
                        node.next = nextNode;
                        node.prev = currNode;
                        currNode.next = node;
                        nextNode.prev = node;
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    currNode.lock.unlock();
                    currNode = nextNode;
                }
            }
        }
        finally {
            nextNode.lock.unlock();
        }

    }

    public void traverse(){
        Node temp = head;

        while(temp != null){
            System.out.printf(temp.val + " ");
            temp = temp.next;
        }
    }
}
