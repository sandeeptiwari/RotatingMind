package com.rotatingmind.stackoverflow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Expected output
 * I expect the output to contain the names of different threads, since I use parallel on the stream.
 * But instead it only displays one thread name for each file in the directory.
 */
public class ProblemFile70359734 {

    public static void main(String[] args) {
        try {
            Files.list(Path.of("/Users/x/Desktop/targets")).parallel().forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    System.out.println("From thread " + Thread.currentThread().getName());
                }
            });
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void example1() throws IOException {
        Path dir = Path.of("args[0]");

        var threads = new ConcurrentHashMap<String, AtomicInteger>();

        try(var stream = Files.list(dir)) {
            stream.parallel()
                    //.peek(p -> System.out.println("Thread" + Thread.currentThread().getName()+" - "+p))
                    .forEach(p -> threads.computeIfAbsent(Thread.currentThread().getName(), tn -> new AtomicInteger()).incrementAndGet());
        }

        System.out.println("Number of files: " + threads.values().stream().mapToInt(AtomicInteger::get).sum());
        System.out.println("Threads used: " + threads.size() +" => "+threads);
    }

    public static void example2() {
        List<String> list = Arrays.asList("amit", "shah", "pren");
        List<Character> result = list.stream().map(l -> l.charAt(0)).collect(Collectors.toList());
    }
}
