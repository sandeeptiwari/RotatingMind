package com.rotatingmind.java16.record;

/**
 * This is immutable, final and has equals, hashcode and toString method
 */
public record Product(String name, int price, boolean isInStock) {

    public Product {
        if (price < 0) {
            price = 100;
        }
    }

    @Override
    public String toString() {
        if (isInStock) {
            return name;
        }
        return "Out of Stock";
    }
}
