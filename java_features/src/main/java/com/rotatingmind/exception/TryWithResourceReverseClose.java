package com.rotatingmind.exception;

import com.rotatingmind.youtube.Comparator;

import java.net.InetAddress;

public class TryWithResourceReverseClose {

    public static void main(String[] args)  {
        Comparator<String> cmp = String::compareTo;

        int val = cmp.compare("123 sandeep tiwari", "123");


        System.out.println(val);
        /*try (var one = new MyResource("One");
             var two = new MyResource("two")) {
                throw new RuntimeException();
        }*/

        try {
            InetAddress addr = InetAddress.getLocalHost();
            String hostname = addr.getHostName();
            System.out.println("Hostname: " + hostname);
        } catch (Exception e) {
            System.err.println("Error getting hostname: " + e.getMessage());
        }

    }
}
