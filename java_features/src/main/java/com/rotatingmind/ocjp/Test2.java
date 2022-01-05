package com.rotatingmind.ocjp;

import java.util.function.Predicate;

public class Test2 {

    public static void main(String[] args) {
        String [] arr = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};

        Predicate<String> p = s -> s.toUpperCase().substring(0,1).equals("A");

        //processStringArray(arr, p);

        Thread t = new Thread(() -> {
            System.out.println("Hi");
        });
        t.start();
    }

    private static void processStringArray(String [] arr,
                                           Predicate<String> predicate) {
        for(String str : arr) {
            if(predicate.test(str)) {
                System.out.println(str);
            }
        }
    }
}
