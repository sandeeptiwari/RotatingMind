package org.brainy.class1;

import java.util.Scanner;

public class Welcome {

    public static void main(String[] args) {
        //task-1
        Thread task1Worker = new Thread(Welcome::userInput);
        task1Worker.start();

        swap(); //Task -2 - Main worker
    }

    private static void userInput() {
        Scanner sc = new Scanner(System.in);
        String topic = sc.next();
        System.out.println("Topic :: " + topic);
    }

    private static void swap() {
        int a = 20;
        int b = 10;
        System.out.println("After swap :: a = " + a + " b = " + b);

        // Swapping without using a third variable
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swap :: a = " + a + " b = " + b);

    }
}
