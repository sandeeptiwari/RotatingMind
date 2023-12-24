package thread.pp.basic;

public class Number {
    private int x;


    public Number(int x) {
        this.x = x;
    }

    public void incr() {
        x++;
    }

    public int getX() {
        return x;
    }

    public synchronized void plus(int curr) {
        x = x + curr;
    }
}
