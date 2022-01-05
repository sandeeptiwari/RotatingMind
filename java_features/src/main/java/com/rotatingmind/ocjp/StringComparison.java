package com.rotatingmind.ocjp;

public class StringComparison {

    public static void main(String[] args) {
        case1();
    }

    public static void case1() {
        String str = "Java";
        String str1 = new String("Java");

        System.out.print(str.equals(str1));
        System.out.println(" ");
        System.out.println(str == str1);
        System.out.println(" ");
        System.out.println(str.compareTo(str1));
    }
}
