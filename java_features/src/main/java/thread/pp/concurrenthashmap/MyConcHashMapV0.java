package thread.pp.concurrenthashmap;

class Node1 {
    private final Integer key;
    private Integer value;
    private Node1 next;

    Node1(Integer key, Integer value) {
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

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}


public class MyConcHashMapV0 {
    private static final int NUM_BUCKETS = 1024;

    private final Node1[] buckets;

    public MyConcHashMapV0() {
        this.buckets = new Node1[NUM_BUCKETS];

        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new Node1(null, null);
        }

    }

    public void put(Integer key, Integer val) {
        int hash = getHash(key);
        Node1 curr = buckets[hash].getNext();
        Node1 prev = buckets[hash];

        while(curr != null) {
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
        Node1 n = new Node1(key, val);
        prev.setNext(n);
    }

    public Integer get(Integer key) {
        int hash = getHash(key);
        Integer ans = null;
        Node1 curr = buckets[hash];
        while (curr != null) {
            if (key.equals(curr.getKey())) {
                ans = curr.getValue();
                break;
            }
            curr = curr.getNext();
        }
        return ans;
    }

    private int getHash(Integer key) {
        return key & (NUM_BUCKETS - 1); // always result between 0 n -1
    }


}
