package thread.pp.sortedjobs.evenoddv1;

public class OddWorker implements Runnable {

    private final String name;
    private final Object lock;


    public OddWorker(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    /*1-
    @Override
    public void run() {
        while (Main.curr < Main.limit) {
            if (Main.curr % 2 != 0) {
                System.out.println(name + " " + Main.curr);
                Main.curr++;
            }
        }
    }*/

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (Main.curr > Main.limit) {
                    break;
                }
                if (Main.curr % 2 != 0) {
                    System.out.println(name + " " + Main.curr);
                    Main.curr++;
                }
            }
        }
    }


}
