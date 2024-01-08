package thread.pp.h2omolecule;



import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        H2OSemaphore semaphore = new H2OSemaphore();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread o = new Thread(new Oxygen(semaphore));
            threads.add(o);
        }
        for (int i = 0; i < 20; i++) {
            Thread h1 = new Thread(new Hydrogen(semaphore));
            threads.add(h1);
        }
        for (int i = 0; i < 30; i++) {
            threads.get(i).start();
        }
    }
}
