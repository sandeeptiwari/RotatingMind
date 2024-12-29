package thread.pp.executorservice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService; // extends executor interface
import java.util.concurrent.Executors;

//IN java we have multiple threadpools
public class Main {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            System.out.println("1 " + Thread.currentThread().getName());
            System.out.println("1 "  + Thread.currentThread().getName());
            System.out.println("1 "  + Thread.currentThread().getName());
        };
        Runnable r2 = () -> {
            System.out.println("2 " + Thread.currentThread().getName());
            System.out.println("2 "  + Thread.currentThread().getName());
            System.out.println("2 "  + Thread.currentThread().getName());
        };
        Runnable r3 = () -> {
            System.out.println("3 " + Thread.currentThread().getName());
            System.out.println("3 "  + Thread.currentThread().getName());
            System.out.println("3 "  + Thread.currentThread().getName());
        };
        Runnable r4 = () -> {
            System.out.println("4 " + Thread.currentThread().getName());
            System.out.println("4 "  + Thread.currentThread().getName());
            System.out.println("4 "  + Thread.currentThread().getName());
        };
        try(ExecutorService executor = Executors.newFixedThreadPool(3)) {
            executor.execute(r1);
            executor.submit(r2);
            executor.submit(r3);
            executor.submit(r4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
