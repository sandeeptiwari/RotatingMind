package sessions.one;

public class Even implements Runnable {
    @Override
    public void run() {
        while (Main.num < Main.limit) {
            if (Main.num % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + Main.num);
                Main.num++;
            }
        }
    }
}
