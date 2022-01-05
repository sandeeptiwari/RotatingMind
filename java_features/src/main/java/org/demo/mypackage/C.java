package org.demo.mypackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Kotlin");
        map.put(3, "Scala");
        map.put(4, "Python");

        String lng = map.getOrDefault(input, "Unknown number");

        if (lng.equals("Java")) {
            System.out.println("Yes!");
        } else  if (lng.equals("Unknown number")) {
            System.out.println("Unknown number");
        } else {
            System.out.println("No!");
        }

        //float f = 20d + 20.02f; // 1
        long n = 10 + 2L;       // 2
        //int b = n + 5;         // 3
    }
}
