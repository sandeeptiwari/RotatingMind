package thread;

import java.util.concurrent.Semaphore;

public class SemaPhoreDemo {

    public static void main(String[] args) {
        try {
            IncorrectSemaphoreExample.incorrectSema();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class IncorrectSemaphoreExample {

    public static void incorrectSema() throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(() -> {
           while (true) {
               try {
                   semaphore.acquire();

                   try {
                       throw new RuntimeException("exception happens at runtime.");
                   } catch (Exception e) {
                       // handle any program logic exception and exit the function
                       return;
                   } finally {
                       semaphore.release();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               // Thread was meant to run forever but runs into an
               // exception that causes the thread to crash.

               //throw new RuntimeException("exception happens at runtime.");

               // The following line to signal the semaphore is never reached
               //semaphore.release();
               System.out.println("released...");
           }
        });

        badThread.start();

        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);

        final  Thread goodThread = new Thread(() -> {
            System.out.println("Good thread patiently waiting to be signalled.");

            try {
                semaphore.acquire();
                System.out.println("11111111111111111111111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        goodThread.start();

        badThread.join();
        goodThread.join();

        System.out.println("Exiting from program");
    }
}