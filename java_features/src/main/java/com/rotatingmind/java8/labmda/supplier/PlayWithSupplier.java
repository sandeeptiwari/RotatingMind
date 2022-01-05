package com.rotatingmind.java8.labmda.supplier;

import java.util.function.Supplier;

public class PlayWithSupplier {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Sandeep Tiwari";
        System.out.println(supplier.get());
    }
}
