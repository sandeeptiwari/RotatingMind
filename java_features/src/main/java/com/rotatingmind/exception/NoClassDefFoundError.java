package com.rotatingmind.exception;

public class NoClassDefFoundError {

    public static void main(String[] args) {
        try {
            new Calculator(); //ExceptionInitializerError
        } catch (Throwable t) {
            System.out.println(t); // swallow the above exception
        }

        new Calculator(); //NoClassDefFoundError
    }


    public static class Calculator {
        static int i = 2 / 0;
    }
}
