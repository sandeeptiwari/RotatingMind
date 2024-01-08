package thread.pp.semaphore;

public class CharPrinter implements Runnable {

    private final char c;
    private final Semaphore semaphore;

    public CharPrinter(char c, Semaphore semaphore) {
        this.c = c;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        try {
            semaphore.acquire();

            for (int i = 0; i < 10; i++) {
                System.out.println(c);
                Thread.sleep(50);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
