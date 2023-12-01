package thread.pp.fourth;

public class Number {
    private int x;

    public Number() {
        this.x = 0;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public synchronized void increment() {
        int oldVal = getX();
        setX(oldVal + 1);
    }
}
