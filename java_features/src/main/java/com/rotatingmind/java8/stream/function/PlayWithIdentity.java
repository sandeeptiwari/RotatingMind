package com.rotatingmind.java8.stream.function;

public class PlayWithIdentity {

    public static void main(String[] args) {

        Function<String, String> identity = s -> s;
        Function<String, String> identity1 = Function.identity();
    }
}
