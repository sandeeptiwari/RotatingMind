package sessions.one;

public class Odd implements Runnable {
    @Override
    public void run() {
        while (Main.num < Main.limit) {
            if (Main.num % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + Main.num);
                Main.num++;
            }

            //Thread.sleep("3000");
        }
    }
}
