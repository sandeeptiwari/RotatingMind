package thread.pp.second;

public class Join {
    public static void main(String[] args) {
        NumberStore numberStore = new NumberStore();
        Object o1 = new Object(), o2 = new Object();
        Thread t1 = new Thread(new Worker(numberStore, o1));
        Thread t2 = new Thread(new Worker(numberStore, o2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(numberStore.getNum());
    }
}
