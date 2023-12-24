package thread.pp.basic;

public class Worker implements Runnable {

    private final char c;

    public Worker(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(c);
        }
        System.out.println("Bye Bye From :: " + Thread.currentThread().getName());
    }
}
