package com.rotatingmind.java8.stream.consumer;


public class PlayWihConsumer {

    public static void main(String[] args) {
        Consumer<String> c1 = s1 -> System.out.println("c1 = " + s1);
        Consumer<String> c2 = s2 -> System.out.println("c2 = " + s2);

       //1:  c1.accept("Hello");

        //consumer chaining

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };
        //2:  c3.accept("How are you");
        /*
           but this is not good way to create chaining it should something like : c3 = c1.andThen(c2, let see.
           For that I have added andThen method in Consumer interface
         */
        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("How are you");

       // Consumer<String> c5 = c1.andThen(null);
        System.out.println("Done");
    }
}
