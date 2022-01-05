package com.rotatingmind.java16.record;

public class TestRecord {

    public static void main(String[] args) {
        Product p = new Product("Fridge", 14000, true);
        System.out.println(p);
        System.out.println(p.isInStock());
    }
}
