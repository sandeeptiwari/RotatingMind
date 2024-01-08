package thread.pp.deadlock;

public class MyLock {
    private final int id;

    public MyLock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
