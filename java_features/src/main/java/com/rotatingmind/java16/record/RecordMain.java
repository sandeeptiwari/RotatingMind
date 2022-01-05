package com.rotatingmind.java16.record;

/**
 * https://openjdk.java.net/jeps/395
 */
public class RecordMain {

    public static void main(String[] args) {
        /* Range rage = new Range(15, 10);
        System.out.println("Exception");*/

        Product p1 = new Product("Peanut Butter", 200, true);
        Product p2 = new Product("Peanut Butter", 200, true);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));


        record DiscountedProduct(Product product, boolean discounted) {}

        System.out.println(new DiscountedProduct(p1, true));

    }
}
