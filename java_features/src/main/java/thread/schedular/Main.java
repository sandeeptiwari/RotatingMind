package thread.schedular;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            public void run() {
                // Define the task to run
                System.out.println("Scheduler is running...");
            }
        };

        // Schedule the task to run every 5 seconds
        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);

        // Shutdown the scheduler when the program is terminated
        Runtime.getRuntime().addShutdownHook(new Thread(() -> scheduler.shutdown()));
    }

}
