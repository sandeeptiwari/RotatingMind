package thread;

import java.util.concurrent.*;

public class CommonDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("Hello World!");
        //way-1
        Thread thread = new Thread(task);
        //thread.start();

        //way-2
        Executor executor = Executors.newSingleThreadExecutor();
        //executor.execute(task);


        CommonDemo demo = new CommonDemo();
        //demo.test1();
        demo.test2();

    }

    private void test1() {
        Runnable task = () -> System.out.println("I am in thread "+ Thread.currentThread().getName());
        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            //Thread t = new Thread(task);
            //t.start();
            service.execute(task);
        }
       service.shutdown();
    }

    private void test2() throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(300);
            return  "I am in thread "+ Thread.currentThread().getName();
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            Future<String> future = service.submit(task);
            System.out.println("I get " + future.get());
        }
        service.shutdown();

    }
}
