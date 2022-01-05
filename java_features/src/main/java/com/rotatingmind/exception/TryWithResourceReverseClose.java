package com.rotatingmind.exception;

public class TryWithResourceReverseClose {

    public static void main(String[] args)  {
        try (var one = new MyResource("One");
             var two = new MyResource("two")) {
                throw new RuntimeException();
        }
    }
}
