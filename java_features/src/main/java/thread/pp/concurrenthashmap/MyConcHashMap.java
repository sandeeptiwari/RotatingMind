package thread.pp.concurrenthashmap;


class Node {
    private final Integer key;
    private Integer value;
    private Node next;

    Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}


public class MyConcHashMap {
    private static final int NUM_BUCKETS = 1024;

    private final Node[] buckets;

    public MyConcHashMap() {
        this.buckets = new Node[NUM_BUCKETS];

        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new Node(null, null);
        }

    }

    public void put(Integer key, Integer val) {
        int hash = getHash(key);

        synchronized (buckets[hash]) { // head of certain bucket
            Node curr = buckets[hash].getNext();
            Node prev = buckets[hash];

            while (curr != null) {
                if (curr.getKey().equals(key)) {
                    curr.setValue(val);
                    return;
                }
                prev = curr;
                curr = curr.getNext();
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Node n = new Node(key, val);
            prev.setNext(n);
        }

    }

    public Integer get(Integer key) {
        int hash = getHash(key);
        Integer ans = null;
        synchronized (buckets[hash]) {
            Node curr = buckets[hash];
            while (curr != null) {
                if (key.equals(curr.getKey())) {
                    ans = curr.getValue();
                    break;
                }
                curr = curr.getNext();
            }
            return ans;
        }
    }

    private int getHash(Integer key) {
        return key & (NUM_BUCKETS - 1); // always result between 0 n -1
    }


}
