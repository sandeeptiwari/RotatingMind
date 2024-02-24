package sessions.one;

import java.util.Scanner;

public class Main {
    // limit till 20
    // Even -> 2, 4, 6, 8 ... 20
    //Odd -> 1, 3, ... 19
    // 1, 2,3 4, 5, ... limit

    // shared vars between even and odd threads
    public static int limit = 20;
    public static int num = 1;

    public static void main(String[] args) {
        //task-1
        Thread t = new Thread(Main::userInput);
        t.start();

        //task-2
        swap();
    }

    private static void swap() {
        int a = 10;
        int b = 20;
        System.out.println("Before Swap -> a : " + a + " b: " + b);
        a = (a + b) - a;
        b = (a + b) - b;
        System.out.println("After swap -> a : " + a + " b: " + b);
    }

    private static void userInput() {
        System.out.println("provide you input...");
        Scanner sc = new Scanner(System.in);
        String topic = sc.next();
        System.out.println("Topic is -> " + topic);
    }
}
