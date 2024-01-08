package thread.pp.latch;

public class OverallSum {

    private int val;

    public OverallSum() {
        this.val = 0;
    }

    public synchronized  void add(int x) {
        val += x;
    }

    public synchronized int getVal() {
        return val;
    }
}
